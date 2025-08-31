package emailSending.service;

import emailSending.dto.ApplicationFormRequest;
import emailSending.sender.EmailSender;
import emailSending.sender.EmailSender.EmailAttachment;
import emailSending.template.EmailTemplateRenderer;
import jakarta.validation.Valid;
import java.util.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EmailSendingService {

    private final EmailTemplateRenderer renderer;
    private final EmailSender emailSender;
    private final String from;
    private final String subjectPrefix;

    public EmailSendingService(
            EmailTemplateRenderer renderer,
            EmailSender emailSender,
            @Value("${email.from}") String from,
            @Value("${email.subject-prefix}") String subjectPrefix
    ) {
        this.renderer = renderer;
        this.emailSender = emailSender;
        this.from = from;
        this.subjectPrefix = subjectPrefix;
    }

    public void sendToApplicant(@Valid ApplicationFormRequest req, List<MultipartFile> files) {
        Map<String, Object> model = new HashMap<>();
        model.put("title", "동아리 지원서");
        model.put("applicantName", req.getApplicantName());
        model.put("applicantEmail", req.getApplicantEmail());
        model.put("clubName", req.getClubName());
        model.put("paragraph1", req.getParagraph1());
        model.put("paragraph2", req.getParagraph2());
        model.put("answers", Optional.ofNullable(req.getAnswers()).orElse(List.of()));
        model.put("submittedAt", java.time.ZonedDateTime.now().toString());

        String html = renderer.render("email-body-applicant", model);

        String subject = (req.getSubject() != null && !req.getSubject().isBlank())
                ? subjectPrefix + " " + req.getSubject()
                : subjectPrefix + " " + req.getClubName() + " - " + req.getApplicantName();

        emailSender.sendHtml(
                from,
                List.of(req.getApplicantEmail()),
                subject,
                html,
                toAttachments(files)
        );
    }
    private List<EmailAttachment> toAttachments(List<MultipartFile> files) {
        if (files==null || files.isEmpty()) return List.of();
        List<EmailAttachment> list = new ArrayList<>();
        for (MultipartFile f : files) {
            if (f.isEmpty()) continue;
            try {
                list.add(new EmailAttachment(
                        Optional.ofNullable(f.getOriginalFilename()).orElse("attachment"),
                        f.getBytes(),
                        Optional.ofNullable(f.getContentType()).orElse("application/octet-stream")
                ));
            } catch (Exception e) {
                throw new RuntimeException("첨부파일 읽기 실패: " + f.getOriginalFilename(), e);
            }
        }
        return list;
    }
}

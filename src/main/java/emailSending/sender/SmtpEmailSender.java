package emailSending.sender;

import java.util.List;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class SmtpEmailSender implements EmailSender {

    private final JavaMailSender mailSender;

    public SmtpEmailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendHtml(String from, List<String> to, String subject, String htmlBody, List<EmailAttachment> attachments) {
        try {
            MimeMessage mime = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mime, true, "UTF-8");
            helper.setFrom(from);
            helper.setTo(to.toArray(new String[0]));
            helper.setSubject(subject);
            helper.setText(htmlBody, true);

            if (attachments != null) {
                for (EmailAttachment att : attachments) {
                    helper.addAttachment(att.filename(), () -> new java.io.ByteArrayInputStream(att.bytes()), att.contentType());
                }
            }
            mailSender.send(mime);
        } catch (Exception e) {
            throw new RuntimeException("SMTP send failed", e);
        }
    }
}

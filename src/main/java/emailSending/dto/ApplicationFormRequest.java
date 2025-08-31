package emailSending.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

public class ApplicationFormRequest {

    @NotBlank @Size(max = 50)
    private String applicantName;

    @Email @NotBlank
    private String applicantEmail;

    @NotBlank @Size(max = 100)
    private String clubName;

    @Size(max = 200)
    private String subject;

    @NotBlank
    private String paragraph1;

    @NotBlank
    private String paragraph2;

    private List<Answer> answers;

    private List<String> portfolioLinks; // 선택

    // 첨부파일은 컨트롤러에서 Multipart 로 받음

    public String getApplicantName() { return applicantName; }
    public void setApplicantName(String applicantName) { this.applicantName = applicantName; }
    public String getApplicantEmail() { return applicantEmail; }
    public void setApplicantEmail(String applicantEmail) { this.applicantEmail = applicantEmail; }
    public String getClubName() { return clubName; }
    public void setClubName(String clubName) { this.clubName = clubName; }
    public String getSubject() { return subject; }
    public void setSubject(String title) { this.subject = subject; }
    public String getParagraph1() { return paragraph1; }
    public void setParagraph1(String paragraph1) { this.paragraph1 = paragraph1; }
    public String getParagraph2() { return paragraph2; }
    public void setParagraph2(String paragraph2) { this.paragraph2 = paragraph2; }
    public List<Answer> getAnswers() { return answers; }
    public void setAnswers(List<Answer> a) { this.answers = a; }
    public List<String> getPortfolioLinks() { return portfolioLinks; }
    public void setPortfolioLinks(List<String> portfolioLinks) { this.portfolioLinks = portfolioLinks; }
}

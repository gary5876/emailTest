package emailSending.sender;

import java.util.List;


public interface EmailSender {
    void sendHtml(String from, List<String> to, String subject, String htmlBody, List<EmailAttachment> attachments);

    record EmailAttachment(String filename, byte[] bytes, String contentType) {
    }
}

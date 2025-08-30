package emailSending.controller;

import emailSending.dto.ApplicationFormRequest;
import emailSending.service.EmailSendingService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/applications")
public class ApiController {

    private final EmailSendingService emailSendingService;

    public ApiController(EmailSendingService emailSendingService) {
        this.emailSendingService = emailSendingService;
    }

    @PostMapping(value = "/send", consumes = {"multipart/form-data"})
    public ResponseEntity<?> send(
            @Valid @RequestPart("form") ApplicationFormRequest form,
            @RequestPart(name = "files", required = false) List<MultipartFile> files
    ) {
        emailSendingService.sendToApplicant(form, files);
        return ResponseEntity.ok().body("{\"status\":\"SENT\"}");
    }
}

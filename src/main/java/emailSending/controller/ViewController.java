package emailSending.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/email")
public class ViewController {

    @GetMapping("/form")
    public String showForm() {
        return "main";
    }
}

package emailSending.controller;

import emailSending.exampleQuestions.FormSchemaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/email")
public class ViewController {
    private final FormSchemaService schema;
    public ViewController(FormSchemaService schema) { this.schema = schema; }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("questions", schema.getQuestions());
        return "main";
    }
}

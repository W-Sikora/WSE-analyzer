package pl.wsikora.wseanalyzer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

    @GetMapping
    public String goToSwaggerPanel() {
        return "redirect:/swagger-ui.html";
    }

}

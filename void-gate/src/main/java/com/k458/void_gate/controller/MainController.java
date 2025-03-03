package com.k458.void_gate.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Return the login.html Thymeleaf template
    }

    @GetMapping("/home")
    public String homePage(Model model, Authentication authentication) {
        model.addAttribute("principal", authentication.getPrincipal());
        return "home";
    }
}

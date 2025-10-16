package com.anket.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Anket Sistemi");
        return "index";
    }
    
    @GetMapping("/surveys")
    public String surveys(Model model) {
        model.addAttribute("title", "Anketler");
        return "surveys";
    }
    
    @GetMapping("/surveys/create")
    public String createSurvey(Model model) {
        model.addAttribute("title", "Yeni Anket Oluştur");
        return "create-survey";
    }
    
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("title", "Giriş Yap");
        return "login";
    }
    
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("title", "Kayıt Ol");
        return "register";
    }
}
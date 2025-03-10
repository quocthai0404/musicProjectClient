package com.music.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
    @GetMapping("/")
    public String redirectToHome(Model model) {
        model.addAttribute("activePage", "home/index"); // Đặt trạng thái active
        return "index"; // Trả về trang index
    }
}

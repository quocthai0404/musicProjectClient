package com.music.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("genre")
public class GenreController {

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("activePage", "index");
        return "genre/index";
    }

}

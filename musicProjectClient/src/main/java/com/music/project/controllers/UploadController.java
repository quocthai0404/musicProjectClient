package com.music.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("upload")
public class UploadController {

    @GetMapping("/index")
    public String index(Model model) {
//        model.addAttribute("activePage", "artist/index");
        return "upload/index";
    }


}
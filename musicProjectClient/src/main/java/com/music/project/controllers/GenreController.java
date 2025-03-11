package com.music.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.music.project.models.GenreModel;
import com.music.project.services.GenreService;

@Controller
@RequestMapping("genre")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping("/index")
    public String index(Model model) {
        // goi api lay ds genre
        List<GenreModel> genres = genreService.getAllGenres();
        
        // truyen ds genre
        model.addAttribute("genres", genres);
        model.addAttribute("activePage", "genre/index");
        return "genre/index";
    }
}
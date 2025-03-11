package com.music.project.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MusicPlayerController {
    @GetMapping("/music-player")
    public String getMusicPlayer(Model model) {
        model.addAttribute("currentSong"," songService.getCurrentSong()");
        model.addAttribute("queueSongs", "songService.getQueueSongs()");
        return "fragments/musicPlayer :: musicPlayer";
    }
//    @GetMapping("/music-player")
//    public String getMusicPlayer(Model model) {
//
//        return "iframe/musicPlayer";
//    }
}
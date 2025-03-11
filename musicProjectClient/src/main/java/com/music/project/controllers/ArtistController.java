package com.music.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.music.project.models.ArtistModel;
import com.music.project.models.SongResultDTO;
import com.music.project.services.ArtistService;

@Controller
@RequestMapping("artist")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping("/index")
    public String index(Model model) {
        // test api connection
        String testResult = artistService.test();
        model.addAttribute("testResult", testResult);
        
        // goi api lay ds artist
        List<ArtistModel> artists = artistService.getAllArtistInfo();
        
        // truyen ds artists 
        model.addAttribute("artists", artists);
        model.addAttribute("activePage", "artist/index");
        return "artist/index";
    }
    
    @GetMapping("/index/detail/{artistId}")
    public String detail(@PathVariable int artistId, Model model) {
        // goi api lay chi tiet id
        ArtistModel artist = artistService.getArtistById(artistId);
        List<SongResultDTO> songs = artistService.getSongsByArtist(artistId);
        
        // truyen artist
        model.addAttribute("artist", artist);
        model.addAttribute("songs", songs);
        System.out.println(songs.size());
        model.addAttribute("activePage", "artist/index");
        return "artist/artistDetail";
    }
}
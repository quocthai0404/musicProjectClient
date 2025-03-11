package com.music.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.music.project.models.Album;
import com.music.project.services.AlbumService;

@Controller
@RequestMapping("album")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping("/index")
    public String index(Model model) {
        // goi api lay ds album
        List<Album> albums = albumService.getAllAlbums();

        // truyen ds albums
        model.addAttribute("albums", albums);
        model.addAttribute("album", new Album()); // them album moi
        model.addAttribute("activePage", "album/index");
        return "album/index";
    }
    
    @GetMapping("/detail/{albumId}")
    public String detail(@PathVariable int albumId, Model model) {
        // goi api lay chi tiet album theo id
        Album album = albumService.getAlbumById(albumId);
        
        // truyen album
        model.addAttribute("album", album);
        model.addAttribute("activePage", "album/index");
        return "album/detail";
    }
}
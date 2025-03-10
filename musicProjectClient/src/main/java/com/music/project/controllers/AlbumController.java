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
        // Gọi API để lấy danh sách albums
        List<Album> albums = albumService.getAllAlbums();
        
        // Truyền danh sách albums vào model
        model.addAttribute("albums", albums);
        model.addAttribute("activePage", "album/index");
        return "album/index";
    }
    
    @GetMapping("/detail/{albumId}")
    public String detail(@PathVariable int albumId, Model model) {
        // Gọi API để lấy chi tiết album theo ID
        Album album = albumService.getAlbumById(albumId);
        
        // Truyền album vào model
        model.addAttribute("album", album);
        model.addAttribute("activePage", "album/index");
        return "album/detail";
    }
}
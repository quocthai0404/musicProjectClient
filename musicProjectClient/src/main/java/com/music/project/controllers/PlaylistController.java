package com.music.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.music.project.models.Album;
import com.music.project.models.ArtistModel;
import com.music.project.models.PlaylistModel;
import com.music.project.models.PlaylistResult;
import com.music.project.models.SongResultDTO;
import com.music.project.services.AlbumService;
import com.music.project.services.PlaylistService;

@Controller
@RequestMapping("playlist")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/index")
    public String index(Model model) {
        // goi api lay ds album
//        List<Album> albums = albumService.getAllAlbums();

        // truyen ds albums
//        model.addAttribute("albums", albums);
//        model.addAttribute("album", new Album()); // them album moi
    	List<PlaylistModel> playlists = playlistService.getAllPlaylist();
        
        // truyen ds artists 
        model.addAttribute("playlists", playlists);
        System.out.println(playlists.size());
        model.addAttribute("activePage", "playlist/index");
        return "playlist/index";
    }
    
//    @GetMapping("/detail/{albumId}")
//    public String detail(@PathVariable int albumId, Model model) {
//        // goi api lay chi tiet album theo id
//        Album album = albumService.getAlbumById(albumId);
//        
//        // truyen album
//        model.addAttribute("album", album);
//        model.addAttribute("activePage", "album/index");
//        return "album/detail";
//    }
    
    @GetMapping("/index/detail/{playlistId}")
    public String detail(@PathVariable int playlistId, Model model) {
        // goi api lay chi tiet id
//        ArtistModel artist = artistService.getArtistById(artistId);
//        List<SongResultDTO> songs = 
        PlaylistResult PlaylistResult = playlistService.getAllSongByPlaylistId(playlistId);
        // truyen artist
        model.addAttribute("name", PlaylistResult.getName());
        model.addAttribute("photo", PlaylistResult.getPhoto());
        model.addAttribute("songs", PlaylistResult.getSongs());
//        System.out.println(songs.size());
        model.addAttribute("activePage", "playlist/index");
        return "playlist/playlistDetail";
    }
    @GetMapping("/upload")
    public String uploadGet(Model model) {
        // goi api lay ds album
//        List<Album> albums = albumService.getAllAlbums();

        // truyen ds albums
//        model.addAttribute("albums", albums);
//        model.addAttribute("album", new Album()); // them album moi
    	List<PlaylistModel> playlists = playlistService.getAllPlaylist();
        
        // truyen ds artists 
        model.addAttribute("playlists", playlists);
        model.addAttribute("activePage", "playlist/upload");
        return "playlist/upload";
    }
}
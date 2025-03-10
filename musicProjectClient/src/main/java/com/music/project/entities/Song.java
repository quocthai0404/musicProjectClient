package com.music.project.entities;

import java.util.List;

public class Song {
    private Integer id;
    private String name;
    private String photo;
    private String urlSource;
    private List<Artist> artists;


    // Getters và Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer Id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUrlSource() {
        return urlSource;
    }

    public void setUrlSource(String urlSource) {
        this.urlSource = urlSource;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }
}

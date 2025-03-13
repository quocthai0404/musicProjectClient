package com.music.project.models;

import java.util.Date;

public class PlaylistModel {
    private Integer id;
    private Integer userId;
    private String name;
    private String slug;
    private String photo;
    private Object songs;
    
    public PlaylistModel() {
		
	}
    
	public PlaylistModel(Integer id, Integer userId, String name, String slug, String photo, Object songs) {
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.slug = slug;
		this.photo = photo;
		this.songs = songs;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Object getSongs() {
		return songs;
	}
	public void setSongs(Object songs) {
		this.songs = songs;
	}
    
    

    
    
   
}
package com.music.project.models;

import java.util.Date;
import java.util.List;

public class PlaylistResult {
	
    
    private Integer id;
	private Integer userId;
	private String name;
	private String slug;
	private String photo;
	private List<SongResultDTO> songs;
	
	public PlaylistResult() {
		
	}

	public PlaylistResult(Integer id, Integer userId, String name, String slug, String photo,
			List<SongResultDTO> songs) {
		super();
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

	public List<SongResultDTO> getSongs() {
		return songs;
	}

	public void setSongs(List<SongResultDTO> songs) {
		this.songs = songs;
	}
	
	
   
}
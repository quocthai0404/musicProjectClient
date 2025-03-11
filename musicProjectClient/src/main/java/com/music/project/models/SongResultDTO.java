package com.music.project.models;

import java.util.List;

public class SongResultDTO {
	private int id;
    private String name;
    private String slug;
    private String urlSource;
    private String photo;
    private String releaseDay;
    private List<ArtistResultDTO> artists;
    private List<GenreResultDTO> genres;

    // Getter & Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }

    public String getUrlSource() { return urlSource; }
    public void setUrlSource(String urlSource) { this.urlSource = urlSource; }

    public String getPhoto() { return photo; }
    public void setPhoto(String photo) { this.photo = photo; }

    public String getReleaseDay() { return releaseDay; }
    public void setReleaseDay(String releaseDay) { this.releaseDay = releaseDay; }

    public List<ArtistResultDTO> getArtists() { return artists; }
    public void setArtists(List<ArtistResultDTO> artists) { this.artists = artists; }

    public List<GenreResultDTO> getGenres() { return genres; }
    public void setGenres(List<GenreResultDTO> genres) { this.genres = genres; }
}

package com.music.project.models;

public class ArtistResultDTO {
	private int songId;
    private int id;
    private String stageName;

    public int getSongId() { return songId; }
    public void setSongId(int songId) { this.songId = songId; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getStageName() { return stageName; }
    public void setStageName(String stageName) { this.stageName = stageName; }
}

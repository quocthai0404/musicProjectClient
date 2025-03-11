package com.music.project.models;

import com.music.project.entities.Song;

import java.util.List;

public class SongResponse {
    private List<Song> content; // Danh sách bài hát

    public List<Song> getContent() {
        return content;
    }

    public void setContent(List<Song> content) {
        this.content = content;
    }
}

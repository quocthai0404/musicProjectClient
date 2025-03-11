package com.music.project.models;

import java.util.Date;

public class GenreModel {
    private Integer id;
    private String name;
    private String slug;
    private String photo;
    private Date createdAt;
    private Date updateAt;
    

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
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
    
    public Date getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    public Date getUpdateAt() {
        return updateAt;
    }
    
    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
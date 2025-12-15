package org.example.bephim.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movie")

public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String description;

    private Integer totalEpisodes;

    @CreationTimestamp
    private Date updateDate;

    @UpdateTimestamp
    private Date createDate;

    @OneToMany(mappedBy = "movie")
    private List<LinkVideo> linkVideos;

    @OneToMany(mappedBy = "movie")
    private List<Episode> episodes;

    @ManyToMany(mappedBy = "movies")
    private List<Category> categories;

    public Movie() {
    }

    public Movie(Integer id, String title, String description, Integer totalEpisodes, Date updateDate, Date createDate, List<LinkVideo> linkVideos, List<Episode> episodes, List<Category> categories) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.totalEpisodes = totalEpisodes;
        this.updateDate = updateDate;
        this.createDate = createDate;
        this.linkVideos = linkVideos;
        this.episodes = episodes;
        this.categories = categories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTotalEpisodes() {
        return totalEpisodes;
    }

    public void setTotalEpisodes(Integer totalEpisodes) {
        this.totalEpisodes = totalEpisodes;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<LinkVideo> getLinkVideos() {
        return linkVideos;
    }

    public void setLinkVideos(List<LinkVideo> linkVideos) {
        this.linkVideos = linkVideos;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}


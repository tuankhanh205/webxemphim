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
    private List<Episode> episodes;

   @OneToMany(mappedBy = "movie")
   private List<MovieCategory> movieCategories;

    public Movie() {
    }

    public Movie(Integer id, String title, String description, Integer totalEpisodes, Date updateDate, Date createDate, List<Episode> episodes, List<MovieCategory> movieCategories) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.totalEpisodes = totalEpisodes;
        this.updateDate = updateDate;
        this.createDate = createDate;
        this.episodes = episodes;
        this.movieCategories = movieCategories;
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



    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    public List<MovieCategory> getMovieCategories() {
        return movieCategories;
    }

    public void setMovieCategories(List<MovieCategory> movieCategories) {
        this.movieCategories = movieCategories;
    }
}


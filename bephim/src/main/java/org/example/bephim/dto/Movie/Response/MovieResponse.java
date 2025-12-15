package org.example.bephim.dto.Movie.Response;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.relational.core.sql.In;

import java.util.Date;

public class MovieResponse {
    private Integer id;
    private String title;
    private String description;
    private Integer totalEpisodes;
    private Date updateDate;
    private Date createDate;

    public MovieResponse() {
    }

    public MovieResponse(Integer id, String title, String description, Integer totalEpisodes, Date updateDate, Date createDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.totalEpisodes = totalEpisodes;
        this.updateDate = updateDate;
        this.createDate = createDate;
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
}

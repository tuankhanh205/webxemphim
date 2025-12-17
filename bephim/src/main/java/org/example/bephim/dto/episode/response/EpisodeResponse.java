package org.example.bephim.dto.episode.response;
import org.example.bephim.dto.link_video.response.LinkVideoResponse;

import java.util.Date;
import java.util.List;

public class EpisodeResponse {
    private Integer id;
    private Integer episodeNumber; //số thứ tự của tâpk
    private String title;
    private Date updateDate;
    private Date createDate;
    private Integer movieId;
    private List<LinkVideoResponse> linkVideos;
    public EpisodeResponse() {
    }

    public EpisodeResponse(Integer id, Integer episodeNumber, String title, Date updateDate, Date createDate, Integer movieId, List<LinkVideoResponse> linkVideos) {
        this.id = id;
        this.episodeNumber = episodeNumber;
        this.title = title;
        this.updateDate = updateDate;
        this.createDate = createDate;
        this.movieId = movieId;
        this.linkVideos = linkVideos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(Integer episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public List<LinkVideoResponse> getLinkVideos() {
        return linkVideos;
    }

    public void setLinkVideos(List<LinkVideoResponse> linkVideos) {
        this.linkVideos = linkVideos;
    }
}

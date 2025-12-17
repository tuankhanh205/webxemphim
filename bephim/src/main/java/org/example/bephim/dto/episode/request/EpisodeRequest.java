package org.example.bephim.dto.episode.request;

import java.util.Date;

public class EpisodeRequest {
    private Integer episodeNumber; //số thứ tự của tâpk
    private String title;
    private Integer movieId;

    public EpisodeRequest() {
    }

    public EpisodeRequest(Integer episodeNumber, String title, Integer movieId) {
        this.episodeNumber = episodeNumber;
        this.title = title;
        this.movieId = movieId;
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

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }
}

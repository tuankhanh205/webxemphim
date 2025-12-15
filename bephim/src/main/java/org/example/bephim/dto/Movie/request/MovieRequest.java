package org.example.bephim.dto.Movie.request;

public class MovieRequest {

    private String title;
    private String description;
    private Integer totalEpisodes;

    public MovieRequest() {
    }

    public MovieRequest(String title, String description, Integer totalEpisodes) {
        this.title = title;
        this.description = description;
        this.totalEpisodes = totalEpisodes;
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
}

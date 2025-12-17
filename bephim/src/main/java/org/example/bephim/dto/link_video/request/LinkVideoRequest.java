package org.example.bephim.dto.link_video.request;

public class LinkVideoRequest {
    private String name;

    private Integer episodeId;

    public LinkVideoRequest() {
    }

    public LinkVideoRequest(String name, Integer episodeId) {
        this.name = name;
        this.episodeId = episodeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(Integer episodeId) {
        this.episodeId = episodeId;
    }
}

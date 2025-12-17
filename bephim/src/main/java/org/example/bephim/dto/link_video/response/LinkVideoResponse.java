package org.example.bephim.dto.link_video.response;

public class LinkVideoResponse {
    private Integer id;

    private String url;

    private String name;

    private Integer episodeId;

    public LinkVideoResponse() {
    }

    public LinkVideoResponse(Integer id, String url, String name, Integer episodeId) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.episodeId = episodeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

package org.example.bephim.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "linkVideo")
public class LinkVideo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String url;

    private String name;

    @OneToMany(mappedBy = "linkVideo")
    private List<History> histories;

    @ManyToOne
    @JoinColumn(name="episodeId",referencedColumnName = "id")
    private Episode episode;

    public LinkVideo() {
    }

    public LinkVideo(Integer id, String url, String name, List<History> histories, Episode episode) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.histories = histories;
        this.episode = episode;
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

    public List<History> getHistories() {
        return histories;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }

    public Episode getEpisode() {
        return episode;
    }

    public void setEpisode(Episode episode) {
        this.episode = episode;
    }
}

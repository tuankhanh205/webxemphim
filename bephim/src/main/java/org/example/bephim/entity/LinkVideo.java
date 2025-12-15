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

    @ManyToOne
    @JoinColumn(name="movieId",referencedColumnName = "id")
    private Movie movie;



}

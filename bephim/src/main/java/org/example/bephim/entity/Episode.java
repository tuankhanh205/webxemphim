package org.example.bephim.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "episode")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer episodeNumber; //số thứ tự của tâpk

    private String title;

    @UpdateTimestamp
    private Date updateDate;

    @CreationTimestamp
    private Date createDate;

    @OneToMany(mappedBy = "episode")
    private List<LinkVideo> linkVideos;

    @ManyToOne
    @JoinColumn(name = "movieId",referencedColumnName = "id")
    private Movie movie;

}

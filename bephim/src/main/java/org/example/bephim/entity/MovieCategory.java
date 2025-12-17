package org.example.bephim.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "movieCategory")
public class MovieCategory {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "movieId",referencedColumnName = "id")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name="category")
    private Category category;
}

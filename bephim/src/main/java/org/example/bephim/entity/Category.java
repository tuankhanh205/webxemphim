package org.example.bephim.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ManyToAny;

import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany
    @JoinTable(name = "movie_category",joinColumns = @JoinColumn(name = "categoryId"),
    inverseJoinColumns = @JoinColumn(name = "movieId"))
    private List<Movie> movies;
}

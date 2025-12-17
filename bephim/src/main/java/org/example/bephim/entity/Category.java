package org.example.bephim.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

  @OneToMany(mappedBy = "category")

  private List<MovieCategory> movieCategories;

    public Category() {
    }

    public Category(Integer id, String name, List<MovieCategory> movieCategories) {
        this.id = id;
        this.name = name;
        this.movieCategories = movieCategories;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MovieCategory> getMovieCategories() {
        return movieCategories;
    }

    public void setMovieCategories(List<MovieCategory> movieCategories) {
        this.movieCategories = movieCategories;
    }
}

package org.example.bephim.repository;

import org.example.bephim.entity.Category;
import org.example.bephim.entity.MovieCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}

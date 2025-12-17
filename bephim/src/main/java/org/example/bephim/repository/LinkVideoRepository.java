package org.example.bephim.repository;

import org.example.bephim.entity.LinkVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkVideoRepository extends JpaRepository<LinkVideo, Integer> {
}

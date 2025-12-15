package org.example.bephim.service.admin.movie;

import org.example.bephim.dto.Movie.Response.MovieResponse;
import org.example.bephim.dto.Movie.request.MovieRequest;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MovieService {
     MovieResponse createMovie(MovieRequest movieRequest);
     List<MovieResponse> getAllMovie();
     MovieResponse updateMovie(Long id,MovieRequest movieRequest);
     List<MovieResponse> getMovieByTitle(String title);

}

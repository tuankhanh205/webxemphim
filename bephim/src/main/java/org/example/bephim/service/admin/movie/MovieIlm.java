package org.example.bephim.service.admin.movie;

import org.example.bephim.dto.Movie.Response.MovieResponse;
import org.example.bephim.dto.Movie.request.MovieRequest;
import org.example.bephim.entity.Movie;
import org.example.bephim.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class MovieIlm implements MovieService{

    private final MovieRepository movieRepository;

    public MovieIlm(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public MovieResponse createMovie(MovieRequest movieRequest) {
        Movie movie=new Movie();
        movie.setTitle(movieRequest.getTitle());
        movie.setDescription(movieRequest.getDescription());
        movie.setTotalEpisodes(movieRequest.getTotalEpisodes());
        movieRepository.save(movie);
        return mapResponse(movie);
    }

    @Override
    public List<MovieResponse> getAllMovie() {
        List<Movie> movies=movieRepository.findAll();
        return movies.stream().map(movie->mapResponse(movie)).collect(Collectors.toList());
    }

    @Override
    public MovieResponse updateMovie(Integer id,MovieRequest movieRequest) {
        Movie movie=movieRepository.findById(id).orElseThrow(()->new RuntimeException("ko có id movie này"));
        movie.setTitle(movieRequest.getTitle());
        movie.setDescription(movieRequest.getDescription());
        movie.setTotalEpisodes(movieRequest.getTotalEpisodes());
        movieRepository.save(movie);
        return mapResponse(movie);
    }

    @Override
    public List<MovieResponse> getMovieByTitle(String title) {
        List<Movie> movies=movieRepository.findByTitle(title);
        return movies.stream().map(this::mapResponse).collect(Collectors.toList());
    }

    MovieResponse mapResponse(Movie movie) {
        MovieResponse movieResponse=new MovieResponse();
        movieResponse.setId(movie.getId());
        movieResponse.setTitle(movie.getTitle());
        movieResponse.setDescription(movie.getDescription());
        movieResponse.setTotalEpisodes(movie.getTotalEpisodes());
        movieResponse.setCreateDate(movie.getCreateDate());
        movieResponse.setUpdateDate(movie.getUpdateDate());
        return movieResponse;
    }
}

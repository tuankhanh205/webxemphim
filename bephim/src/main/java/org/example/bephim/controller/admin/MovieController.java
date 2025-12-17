package org.example.bephim.controller.admin;

import org.example.bephim.dto.Movie.Response.MovieResponse;
import org.example.bephim.dto.Movie.request.MovieRequest;
import org.example.bephim.service.admin.movie.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/movie")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/get_all")
    List<MovieResponse> getAllMovie(){
        return movieService.getAllMovie();
    }
    @PostMapping("/create_movie")
    MovieResponse createMovie(@RequestBody MovieRequest movieRequest){
        return movieService.createMovie(movieRequest);
    }
    @PutMapping("/update_movie/{id}")
    MovieResponse updateMovie(@RequestBody MovieRequest movieRequest,@PathVariable("id") Integer id){
        return movieService.updateMovie(id,movieRequest);
    }
    @GetMapping("/finByTitle")
    List<MovieResponse> getMovieByTitle(@RequestParam String title){
        return movieService.getMovieByTitle(title);
    }

}

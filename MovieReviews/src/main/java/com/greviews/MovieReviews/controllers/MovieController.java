package com.greviews.MovieReviews.controllers;

import com.greviews.MovieReviews.dtos.CreateSearchRequest;
import com.greviews.MovieReviews.models.Movie;
import com.greviews.MovieReviews.servcie.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173/")

@RestController
public class MovieController {
   @Autowired
   MovieService movieService;
    @GetMapping("/movie")
    public Movie get(@RequestParam("id") int movieId)
    {
        return movieService.get(movieId);
    }
   @GetMapping("/movies")
    public List<Movie> get()
   {
       return movieService.get();
   }
    @PostMapping("/search")
    public List<Movie> search(@RequestBody @Valid CreateSearchRequest createSearchRequest) throws Exception
    {
        return movieService.search(createSearchRequest);
    }
    @GetMapping("/sort")
    public  List<Movie> sort(@RequestParam("by") String key)
    {
        return movieService.sort(key);
    }

    @GetMapping("/moviestoday")
    public List<Movie> moviesToday()
    {
        return  movieService.moviesToday();
    }
}

package com.greviews.MovieReviews.controllers;

import com.greviews.MovieReviews.dtos.CreateMovieRequest;
import com.greviews.MovieReviews.dtos.CreateUpdateMovieRequest;
import com.greviews.MovieReviews.models.Movie;
import com.greviews.MovieReviews.servcie.AdminService;
import com.greviews.MovieReviews.servcie.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://192.168.1.4:8081", "https://bapanapalligopi.github.io/MovieReviewsFrontEnd/"})

public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/create/movie")
    public Movie createMovie(@RequestBody @Valid CreateMovieRequest createMovieRequest )
    {
        Movie movie=createMovieRequest.toMovie();
        return adminService.create(movie);
    }
    @DeleteMapping("delete/movie")
    public String deleteMovie(@RequestParam("id")int movieId) throws  Exception
    {
       return adminService.deleteMovie(movieId);
    }
    @PutMapping("update/movie")
    public Movie updateMovie(@RequestParam("id") int movieId,@RequestBody @Valid CreateUpdateMovieRequest createUpdateMovieRequest) throws Exception
    {
        return adminService.update(movieId,createUpdateMovieRequest.To());
    }

}

package com.greviews.MovieReviews.repository;

import com.greviews.MovieReviews.models.Genre;
import com.greviews.MovieReviews.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
    List<Movie> findAllByTitle(String title);
    List<Movie> findAllByGenre(Genre genre);
    List<Movie> findByRating(Double rating);
    List<Movie> findAllByDirector(String director);
    List<Movie> findByRatingLessThan(Double rating);
    List<Movie> findByRatingGreaterThan(Double rating);
    List<Movie> findByRatingLessThanEqual(Double rating);
    List<Movie> findByRatingGreaterThanEqual(Double rating);

    List<Movie> findByDuration(int duration);
    List<Movie> findByDurationLessThan(int duration);
    List<Movie> findByDurationGreaterThan(int duration);
    List<Movie> findByDurationLessThanEqual(int duration);
    List<Movie> findByDurationGreaterThanEqual(int duration);
    List<Movie> findByReleaseDate(LocalDate localDate);

}

package com.greviews.MovieReviews.repository;

import com.greviews.MovieReviews.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Movie,Integer>
{

}

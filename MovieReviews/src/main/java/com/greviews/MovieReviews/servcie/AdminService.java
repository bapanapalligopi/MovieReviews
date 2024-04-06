package com.greviews.MovieReviews.servcie;

import com.greviews.MovieReviews.dtos.CreateMovieRequest;
import com.greviews.MovieReviews.models.Movie;
import com.greviews.MovieReviews.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    MovieService movieService;
    @Autowired
    AdminRepository adminRepository;
    public Movie create(Movie movie)
    {

        return adminRepository.save(movie);
    }
    public String deleteMovie(int movieId) throws  Exception
    {
        Movie movie= movieService.get(movieId);
        if (movie==null)  throw new Exception("movie with id is not found");
        try{
            adminRepository.deleteById(movieId);
            return "Movie Deleted Successfully";
        }
        catch (Exception e){throw new Exception("Movie Deletion not done yet due some issue at back end");}
    }

    public Movie update(int movieId,Movie movie) throws Exception
    {
        Movie oldMovie= movieService.get(movieId);
        if(oldMovie==null) throw  new Exception("movie not found for update");
        oldMovie.setRating(movie.getRating());
        oldMovie.setMinusPoints(movie.getMinusPoints());
        oldMovie.setPlusPoints(movie.getPlusPoints());
        oldMovie.setReviewUpdatedOn(movie.getReviewUpdatedOn());
        oldMovie.setReviewDescription(movie.getReviewDescription());
        oldMovie.setOneWord(movie.getOneWord());
        oldMovie.setThreeWord(movie.getThreeWord());
        oldMovie.setVerdict(movie.getVerdict());
        oldMovie.setStory(movie.getStory());
        oldMovie.setTechnicalAssets(movie.getTechnicalAssets());
        return adminRepository.save(oldMovie);
    }



}

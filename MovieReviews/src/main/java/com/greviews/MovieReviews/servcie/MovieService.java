package com.greviews.MovieReviews.servcie;

import com.greviews.MovieReviews.dtos.CreateSearchRequest;
import com.greviews.MovieReviews.models.Genre;
import com.greviews.MovieReviews.models.Movie;
import com.greviews.MovieReviews.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public Movie get(int id)
    {
        return movieRepository.findById(id).orElse(null);
    }
    public List<Movie> get()
    {
        return movieRepository.findAll();
    }
    public List<Movie> search(CreateSearchRequest createSearchRequest) throws Exception
    {
        //go and check if this request is valid or not
        if(!createSearchRequest.validate(createSearchRequest)) throw  new Exception("search key is invalid");
        switch (createSearchRequest.getKey())
        {
            case "title":return movieRepository.findAllByTitle(createSearchRequest.getValue());
            case "genre": return movieRepository.findAllByGenre(Genre.valueOf(createSearchRequest.getValue()));
            case "director":return movieRepository.findAllByDirector(createSearchRequest.getValue());
            case "rating":
                switch (createSearchRequest.getOp())
                {
                    case "=":return movieRepository.findByRating(Double.parseDouble(createSearchRequest.getValue()));
                    case "<":return movieRepository.findByRatingLessThan(Double.parseDouble(createSearchRequest.getValue()));
                    case ">":return movieRepository.findByRatingGreaterThan(Double.parseDouble(createSearchRequest.getValue()));
                    case "<=":return movieRepository.findByRatingLessThanEqual(Double.parseDouble(createSearchRequest.getValue()));
                    case ">=":return movieRepository.findByRatingGreaterThanEqual(Double.parseDouble(createSearchRequest.getValue()));
                }
            case "duration":
                switch (createSearchRequest.getOp())
                {
                    case "=":return movieRepository.findByDuration(Integer.parseInt(createSearchRequest.getValue()));
                    case "<":return movieRepository.findByDurationLessThan(Integer.parseInt(createSearchRequest.getValue()));
                    case ">":return movieRepository.findByDurationGreaterThan(Integer.parseInt(createSearchRequest.getValue()));
                    case "<=":return movieRepository.findByDurationLessThanEqual(Integer.parseInt(createSearchRequest.getValue()));
                    case ">=":return movieRepository.findByDurationGreaterThanEqual(Integer.parseInt(createSearchRequest.getValue()));
                }
            default:throw  new Exception("Please Enter valid Search key");
        }
    }

    public List<Movie> sort(String key)
    {
        Sort sort = Sort.by(Sort.Direction.DESC, key);
        return movieRepository.findAll(sort);
    }

    public List<Movie> moviesToday()
    {
        LocalDate todayDate=LocalDate.now();
        return movieRepository.findByReleaseDate(todayDate);
    }

}

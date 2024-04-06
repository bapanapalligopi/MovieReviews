package com.greviews.MovieReviews.dtos;

import com.greviews.MovieReviews.models.Genre;
import com.greviews.MovieReviews.models.Movie;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateMovieRequest
{
    @NotBlank
    private String title;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    private int duration;
    @NotBlank
    private String cast;
    private LocalDate releaseDate;
    @NotBlank
    private  String director;
    @NotBlank
    private  String producers;
    @NotBlank
    private  String musicDirector;
    @NotBlank
    private  String cinematographer;
    @NotBlank
    private  String editor;
    @NotBlank
    private  String imageUrl;
    @NotBlank
    private  String trailerUrl;
    @NotBlank
    private String reviewDescription;
    @NotBlank
    private  String story;
    @NotBlank
    private  String plusPoints;
    @NotBlank
    private  String minusPoints;
    @Max(5)
    @Min(1)
    private double rating;
    @NotBlank
    private String oneWord;
    @NotBlank
    private String threeWord;
    @NotBlank
    private String verdict;
    @NotBlank
    private String technicalAssets;
    public Movie toMovie()
    {
        return Movie.builder()
                .title(this.title)
                .genre(this.genre)
                .duration(this.duration)
                .cast(this.cast)
                .releaseDate(this.releaseDate)
                .musicDirector(this.musicDirector)
                .director(this.director)
                .editor(this.editor)
                .producers(this.producers)
                .cinematographer(this.cinematographer)
                .imageUrl(this.imageUrl)
                .trailerUrl(this.trailerUrl)
                .story(this.story)
                .reviewDescription(this.reviewDescription)
                .plusPoints(this.plusPoints)
                .minusPoints(this.minusPoints)
                .rating(this.rating)
                .oneWord(this.oneWord)
                .threeWord(this.threeWord)
                .technicalAssets(this.technicalAssets)
                .verdict(this.verdict)
                .build();
    }
}

package com.greviews.MovieReviews.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String title;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    @Enumerated(value = EnumType.STRING)
    private Language language;

    private int duration;
    @NotBlank
    private String cast;
    private LocalDate releaseDate;
    private  double rating;
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
    @Lob
    private String reviewDescription;
    @CreationTimestamp
    private Date reviewCreatedOn;
    @UpdateTimestamp
    private Date reviewUpdatedOn;
    @NotBlank
    @Lob
    private  String story;
    @NotBlank
    @Lob
    private  String plusPoints;
    @NotBlank
    @Lob
    private  String minusPoints;
    @NotBlank
    private String oneWord;
    @NotBlank
    private String threeWord;
    @NotBlank
    private String verdict;
    @NotBlank
    private String technicalAssets;

    public  Movie toMovie()
    {
        return  Movie.builder()
                .id(this.id)
                .title(this.title)
                .genre(this.genre)
                .language(this.language)
                .duration(this.duration)
                .cast(this.cast)
                .releaseDate(this.releaseDate)
                .rating(this.rating)
                .musicDirector(this.musicDirector)
                .director(this.director)
                .editor(this.editor)
                .producers(this.producers)
                .cinematographer(this.cinematographer)
                .imageUrl(this.imageUrl)
                .trailerUrl(this.trailerUrl)
                .reviewDescription(this.reviewDescription)
                .minusPoints(this.minusPoints)
                .plusPoints(this.plusPoints)
                .reviewCreatedOn(this.reviewCreatedOn)
                .reviewUpdatedOn(this.reviewUpdatedOn)
                .story(this.story)
                .oneWord(this.oneWord)
                .threeWord(this.threeWord)
                .technicalAssets(this.technicalAssets)
                .verdict(this.verdict)
                .build();
    }

}

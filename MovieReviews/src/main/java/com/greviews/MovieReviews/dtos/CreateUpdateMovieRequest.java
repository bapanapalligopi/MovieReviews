package com.greviews.MovieReviews.dtos;

import com.greviews.MovieReviews.models.Movie;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateUpdateMovieRequest
{
    @NotBlank
    @Lob
    private String reviewDescription;
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
    @Max(5)
    @Min(1)
    private Double rating;
    @UpdateTimestamp
    private Date reviewUpdatedOn;
    public Movie To()
    {
        return Movie.builder()
                .story(this.story)
                .reviewDescription(this.reviewDescription)
                .plusPoints(this.plusPoints)
                .minusPoints(this.minusPoints)
                .rating(this.rating)
                .oneWord(this.oneWord)
                .threeWord(this.threeWord)
                .technicalAssets(this.technicalAssets)
                .verdict(this.verdict)
                .reviewUpdatedOn(new Date())
                .build();
    }

}

package com.sistemaRecomendacion.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieRecommendation {

    @JsonProperty("movie_id")
    private int movieId;

    @JsonProperty("movie_title")
    private String movieTitle;

    private double score;
}

package com.sistemaRecomendacion.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserRecommendation {

    @JsonProperty("user_id")
    private int userId;

    private int cluster;

    private List<MovieRecommendation> recommendations;
}

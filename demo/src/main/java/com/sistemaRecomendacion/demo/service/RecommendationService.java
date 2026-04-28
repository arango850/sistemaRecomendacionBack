package com.sistemaRecomendacion.demo.service;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;
import com.sistemaRecomendacion.demo.model.UserRecommendation;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

    private List<UserRecommendation> recommendations;
    private Map<Integer, UserRecommendation> byUserId;

    @PostConstruct
    public void loadData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("data/recommendations.json");
        recommendations = mapper.readValue(
                resource.getInputStream(),
                new TypeReference<List<UserRecommendation>>() {}
        );
        byUserId = recommendations.stream()
                .collect(Collectors.toMap(UserRecommendation::getUserId, Function.identity()));
    }

    public List<UserRecommendation> getAll() {
        return recommendations;
    }

    public Optional<UserRecommendation> getByUserId(int userId) {
        return Optional.ofNullable(byUserId.get(userId));
    }
}

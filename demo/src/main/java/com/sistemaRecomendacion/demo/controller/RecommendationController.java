package com.sistemaRecomendacion.demo.controller;

import com.sistemaRecomendacion.demo.model.UserRecommendation;
import com.sistemaRecomendacion.demo.service.RecommendationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
@CrossOrigin(origins = "*")
public class RecommendationController {

    private final RecommendationService service;

    public RecommendationController(RecommendationService service) {
        this.service = service;
    }

    // GET /recommendations — returns all user recommendations
    @GetMapping
    public ResponseEntity<List<UserRecommendation>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // GET /recommendations/{user_id} — returns recommendations for a single user
    // Returns 404 if the user is not found
    @GetMapping("/{user_id}")
    public ResponseEntity<UserRecommendation> getByUserId(@PathVariable("user_id") int userId) {
        return service.getByUserId(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

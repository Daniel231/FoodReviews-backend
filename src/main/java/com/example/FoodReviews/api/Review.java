package com.example.FoodReviews.api;

import java.util.Map;

import com.example.FoodReviews.models.ReviewModel;
import com.example.FoodReviews.services.ReviewService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/review")
public class Review {
    
    @Autowired
	private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> findAll(
		@RequestParam(required = false) String score,
	    @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(required = false) String productId
    ) {
        Map<String, Object> Reviews = reviewService.getReviews(productId, score, page, size);
        
        return ResponseEntity.ok().body(Reviews);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewModel> findById(@PathVariable(required = true) String id) {
        ReviewModel Review= reviewService.getReview(id);

        if(Review == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "review not found"
            );
        }
        
        return ResponseEntity.ok().body(Review);
    }
}
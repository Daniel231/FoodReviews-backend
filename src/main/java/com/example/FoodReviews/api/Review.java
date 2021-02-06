package com.example.FoodReviews.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/review")
public class Review {

    @GetMapping
    public String findAll() {
        return "hello";
    }

    @GetMapping("/{reviewId}")
    public String findById(@PathVariable String reviewId) {
        return reviewId;
    }

    @GetMapping("/statistic")
    public String aggregateReviewersStatistics() {
        return "hi";
    }
}
package com.example.FoodReviews.repositories;

import com.example.FoodReviews.models.ReviewModel;

import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<ReviewModel, Long> {
    ReviewModel findById(String id);
}

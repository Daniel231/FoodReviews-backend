package com.example.FoodReviews.services;

import java.util.Map;

import com.example.FoodReviews.models.ReviewModel;

public interface ReviewServiceInterface {

	ReviewModel getReview(String id);
	Map<String, Object> getReviews(String productId, String score, int page, int size);

}
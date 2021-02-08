package com.example.FoodReviews.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.FoodReviews.models.ReviewModel;
import com.example.FoodReviews.models.ReviewModelLite;
import com.example.FoodReviews.repositories.ReviewLiteRepository;
import com.example.FoodReviews.repositories.ReviewRepository;

@Service
@Transactional
public class ReviewService implements ReviewServiceInterface{

	@Autowired
	private ReviewLiteRepository reviewRepositoryLite;

	@Autowired
	private ReviewRepository reviewRepository;

	@Override
	public Map<String, Object> getReviews(String productId, String score, int page, int size) {
		Pageable paging = PageRequest.of(page, size);

		ReviewModelLite exampleReview = new ReviewModelLite();
		exampleReview.setScore(score);
		exampleReview.setProductId(productId);

		Page<ReviewModelLite> reviewsPage = reviewRepositoryLite.findAll(Example.of(exampleReview), paging);
		List<ReviewModelLite> reviews = reviewsPage.getContent();

		reviews = reviewsPage.getContent();
	    Map<String, Object> response = new HashMap<>();
	    response.put("reviews", reviews);
	    response.put("currentPage", reviewsPage.getNumber());
	    response.put("totalItems", reviewsPage.getTotalElements());
	    response.put("totalPages", reviewsPage.getTotalPages());
		return response;
	}

	@Override
	public ReviewModel getReview(String id) {
		return reviewRepository.findById(id);
	}

}
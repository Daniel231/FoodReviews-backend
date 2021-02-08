package com.example.FoodReviews.repositories;

import com.example.FoodReviews.models.ReviewModelLite;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface ReviewLiteRepository extends CrudRepository<ReviewModelLite, Long>, QueryByExampleExecutor<ReviewModelLite> {

    Page<ReviewModelLite> findAll(Pageable paging);
}

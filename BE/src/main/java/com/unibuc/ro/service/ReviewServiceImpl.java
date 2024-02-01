package com.unibuc.ro.service;

import com.unibuc.ro.model.Order;
import com.unibuc.ro.model.Review;
import com.unibuc.ro.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review getReviewForOrder(Order order) {
        if (reviewRepository.findReviewByOrder(order).isPresent())
            return reviewRepository.findReviewByOrder(order).get();
        else return null;
    }
}

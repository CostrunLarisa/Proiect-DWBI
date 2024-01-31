package com.unibuc.ro.service;


import com.unibuc.ro.model.Order;
import com.unibuc.ro.model.Review;

public interface ReviewService {

    Review getReviewForOrder(Order order);
}

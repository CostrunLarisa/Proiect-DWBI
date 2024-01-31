package com.unibuc.ro.repository;

import com.unibuc.ro.model.Order;
import com.unibuc.ro.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    Optional<Review> findReviewByOrder(Order order);
}

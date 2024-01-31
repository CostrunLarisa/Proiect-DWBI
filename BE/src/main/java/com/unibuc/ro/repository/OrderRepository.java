package com.unibuc.ro.repository;

import com.unibuc.ro.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByUserUsername(String username);
    List<Order> findAllByUserUsernameAndDatePlaced(String username, Date date);
}

package com.unibuc.ro.repository;

import com.unibuc.ro.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByUserUsername(String username);
    List<Order> findAllByUserUsernameAndDatePlaced(String username, Date date);
}

package com.unibuc.ro.service;

import com.unibuc.ro.model.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface OrderService {

    List<Order> findAllOrdersForUser(String username);
    List<Order> findAllOrdersForUserByDate(String username, Date date);

    Set<Order> findOrderByAddress(OrderAddress address);

    Order newOrder(String username, OrderDto orderDto, List<ProductOrderDto> products);

    void addReview(String username, Long orderId, String review);
}

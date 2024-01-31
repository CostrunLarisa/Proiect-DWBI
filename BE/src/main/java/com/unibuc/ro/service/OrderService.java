package com.unibuc.ro.service;

import com.unibuc.ro.model.Order;
import com.unibuc.ro.model.OrderDto;
import com.unibuc.ro.model.ProductOrder;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface OrderService {

    List<Order> findAllOrdersForUser(String username);
    List<Order> findAllOrdersForUserByDate(String username, Date date);
    Order newOrder(String username, OrderDto orderDto, Set<ProductOrder> products);
}

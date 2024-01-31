package com.unibuc.ro.resource;

import com.unibuc.ro.model.Order;
import com.unibuc.ro.model.OrderDto;
import com.unibuc.ro.service.OrderService;
import com.unibuc.ro.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderResource {

    private final OrderService orderService;
    private final UserService userService;

    public OrderResource(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<Order>> getAllOrdersForUser(@RequestHeader(value = "Authorization-Token", required = true) String token, Date date) {
        String username = userService.decryptToken(token);
        List<Order> orders;
        if (date != null) {
            orders = orderService.findAllOrdersForUserByDate(username, date);
        } else {
            orders = orderService.findAllOrdersForUser(username);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/new")
    public ResponseEntity<Order> newOrder(@RequestHeader(value = "Authorization-Token", required = true) String token, OrderDto orderDto) {
        String username = userService.decryptToken(token);
        Order order = orderService.newOrder()
    }

}

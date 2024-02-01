package com.unibuc.ro.resource;

import com.unibuc.ro.model.Order;
import com.unibuc.ro.model.OrderDto;
import com.unibuc.ro.model.ProductOrderDto;
import com.unibuc.ro.service.OrderService;
import com.unibuc.ro.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Order>> getAllOrdersForUser(@RequestHeader(value = "Authorization-Token", required = true) String token,
                                                           @RequestParam  Date date) {
        String username = userService.decryptToken(token);
        List<Order> orders;
        if (date != null) {
            orders = orderService.findAllOrdersForUserByDate(username, date);
        } else {
            orders = orderService.findAllOrdersForUser(username);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
    // TODO: Trebuie sa se primeasca un obiect/doua obiecte de tip @RequestBody
    @PostMapping("/new")
    public ResponseEntity<Order> newOrder(@RequestHeader(value = "Authorization-Token", required = true) String token,
                                          OrderDto orderDto,
                                          List<ProductOrderDto> productsDto) {
        String username = userService.decryptToken(token);
        Order order = orderService.newOrder(username, orderDto, productsDto);

        try {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Order> addReview(@RequestHeader(value = "Authorization-Token", required = true) String token, Long orderId, String review) {
        String username = userService.decryptToken(token);

        try {
            orderService.addReview(username, orderId, review);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

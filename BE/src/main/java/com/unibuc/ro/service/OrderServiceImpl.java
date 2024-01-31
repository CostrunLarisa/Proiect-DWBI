package com.unibuc.ro.service;

import com.unibuc.ro.model.Order;
import com.unibuc.ro.model.OrderDto;
import com.unibuc.ro.model.ProductOrder;
import com.unibuc.ro.model.UserDetails;
import com.unibuc.ro.repository.OrderRepository;
import com.unibuc.ro.repository.ShopRepository;
import com.unibuc.ro.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService{
    private final ShopRepository shopRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderServiceImpl(ShopRepository shopRepository,
                            OrderRepository orderRepository,
                            UserRepository userRepository) {
        this.shopRepository = shopRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Order> findAllOrdersForUser(String username) {
        return orderRepository.findAllByUserUsername(username);
    }

    @Override
    public List<Order> findAllOrdersForUserByDate(String username, Date date) {
        return orderRepository.findAllByUserUsernameAndDatePlaced(username, date);
    }

    @Override
    public Order newOrder(String username, OrderDto orderDto, Set<ProductOrder> products) {
        Double totalPrice = products.stream().mapToDouble(productOrder -> productOrder.getProduct().getPrice() * productOrder.getQuantity()).sum();
        Optional<UserDetails> userDetails = userRepository.findByUsername(username);
        if (userDetails.isPresent()) {
            Order newOrder = Order.builder().shop(shopRepository.getById(orderDto.getShopId()))
                    .totalPrice(totalPrice)
                    .datePlaced(new Date())
                    .user(userDetails.get())
                    .products(products)
                    .build();
            return orderRepository.save(newOrder);
        } else {
            return null;
        }

    }
}

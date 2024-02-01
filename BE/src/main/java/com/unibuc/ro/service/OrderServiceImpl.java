package com.unibuc.ro.service;

import com.unibuc.ro.model.*;
import com.unibuc.ro.repository.*;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{

    private final ShopRepository shopRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;
    private final ProductOrderRepository productOrderRepository;
    private final ReviewRepository reviewRepository;

    public OrderServiceImpl(ShopRepository shopRepository,
                            OrderRepository orderRepository,
                            UserRepository userRepository,
                            AddressRepository addressRepository,
                            ProductRepository productRepository,
                            ProductOrderRepository productOrderRepository,
                            ReviewRepository reviewRepository) {
        this.shopRepository = shopRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.productRepository = productRepository;
        this.productOrderRepository = productOrderRepository;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Order> findAllOrdersForUser(String username) {
        return orderRepository.findAllByUser(username);
    }

    @Override
    public List<Order> findAllOrdersForUserByDate(String username, Date date) {
        return orderRepository.findAllByUserUsernameAndDatePlaced(username, date);
    }

    @Override
    public Set<Order> findOrderByAddress(OrderAddress address) {
        return orderRepository.findAllByOrderAddress(address);
    }

    @Override
    public Order newOrder(String username, OrderDto orderDto, List<ProductOrderDto> productsDto) {
        Order order = new Order();
        List<Product> products = productRepository.findAllByIds(productsDto.stream().map(ProductOrderDto::getProductId).collect(Collectors.toList()));
        Set<ProductOrder> finalProducts = convertToProductOrder(productsDto, products, order.getOrderId());
        Double totalPrice = finalProducts.stream().mapToDouble(productOrder -> productOrder.getProduct().getPrice() * productOrder.getQuantity()).sum();
        UserDetails userDetails = userRepository.findByUsername(username).get();
        OrderAddress orderAddress = addressRepository.findByAddressId(orderDto.getAddressId()).get();
        Shop shop = shopRepository.getById(orderDto.getShopId());

        order.setUser(userDetails);
        order.setOrderAddress(orderAddress);
        order.setDatePlaced(new Date());
        order.setProducts(finalProducts);
        order.setShop(shop);
        order.setTotalPrice(totalPrice);
        order.setReviews(new HashSet<>());

        orderRepository.save(order);

        return order;
    }

    @Override
    public void addReview(String username, Long orderId, String review) {
        Order order = orderRepository.getById(orderId);
        Review review1 = Review.builder().order(order).content(review).build();

        reviewRepository.save(review1);
        Set<Review> orderReviews = order.getReviews();
        orderReviews.add(review1);
        order.setReviews(orderReviews);

        orderRepository.save(order);
    }

    private Set<ProductOrder> convertToProductOrder(List<ProductOrderDto> dtos, List<Product> products, Long orderId) {
        Set<ProductOrder> finalSet = new HashSet<>();
        for (int i = 0; i < dtos.size(); i++) {
            ProductOrder productOrder = ProductOrder.builder().product(products.get(i)).quantity(dtos.get(i).getQuantity()).productOrderId(orderId).build();
            finalSet.add(productOrder);
            productOrderRepository.save(productOrder);
        }
        return finalSet;
    }


}

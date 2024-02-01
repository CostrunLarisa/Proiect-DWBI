package com.unibuc.ro.repository;

import com.unibuc.ro.model.Order;
import com.unibuc.ro.model.OrderAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select o from Order o where o.user.username=?1")
    List<Order> findAllByUser(String username);

    @Query("select o from Order o where o.user.username=?1 and o.datePlaced=?2")
    List<Order> findAllByUserAndDatePlaced(String username, Date date);
    Set<Order> findAllByOrderAddress(OrderAddress address);
}

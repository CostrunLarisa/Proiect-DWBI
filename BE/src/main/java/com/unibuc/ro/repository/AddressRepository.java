package com.unibuc.ro.repository;

import com.unibuc.ro.model.OrderAddress;
import com.unibuc.ro.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<OrderAddress, Long> {

    List<OrderAddress> findAllByUser(UserDetails user);
}

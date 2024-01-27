package com.unibuc.ro.repository;

import com.unibuc.ro.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByShop_ShopId(Long shopId);
    List<Product> findAllByAddedByUser(String username);
    Optional<Product> findByProductIdAndAddedByUser(Long id, String username);
}
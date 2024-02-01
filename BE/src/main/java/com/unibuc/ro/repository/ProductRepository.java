package com.unibuc.ro.repository;

import com.unibuc.ro.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM product p JOIN shop s ON p.shop.shopId = s.shopId where p.shop.shopId = ?1")
    List<Product> findAllByShop_ShopId(Long shopId);
    List<Product> findAll();
    Optional<Product> findByProductId(Long id);

    @Query("select p from product p where p.productId in ?1")
    List<Product> findAllByIds(List<Long> ids);
}
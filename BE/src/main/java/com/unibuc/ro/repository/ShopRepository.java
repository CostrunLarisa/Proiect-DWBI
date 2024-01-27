package com.unibuc.ro.repository;

import com.unibuc.ro.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
    Optional<Shop> findByShopIdAndUsername(Long id,String username);
    List<Shop> findAllByUsername (String username);
}
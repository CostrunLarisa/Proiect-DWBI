package com.unibuc.ro.service;

import com.unibuc.ro.model.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopService {
    List<Shop> getAllShops(String token);

    Shop addShop( Shop shop);

    Optional<Shop> findById( Long id);
}
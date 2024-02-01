package com.unibuc.ro.service;

import ch.qos.logback.classic.Logger;
import com.unibuc.ro.model.Shop;
import com.unibuc.ro.repository.ShopRepository;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService{
    private final ShopRepository shopRepository;
    private final UserService userService;

    private final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ShopServiceImpl.class);

    public ShopServiceImpl(ShopRepository shopRepository, UserService userService) {
        this.shopRepository = shopRepository;
        this.userService = userService;
    }

    @Override
    public List<Shop> getAllShops() {
        return shopRepository.findAll().stream().toList();
    }

    @Override
    public Shop addShop( Shop shop) {
        Shop newShop = Shop.builder().name(shop.getName()).build();
        return shopRepository.save(newShop);
    }

    @Override
    public Optional<Shop> findById( Long id) {
        return shopRepository.findByShopId(id);
    }


}
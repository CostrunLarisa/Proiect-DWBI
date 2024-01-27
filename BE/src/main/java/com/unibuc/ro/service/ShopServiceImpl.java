package com.unibuc.ro.service;

import com.unibuc.ro.model.Shop;
import com.unibuc.ro.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService{
    private final ShopRepository shopRepository;
    private final UserService userService;
    public ShopServiceImpl(ShopRepository shopRepository, UserService userService) {
        this.shopRepository = shopRepository;
        this.userService = userService;
    }

    @Override
    public List<Shop> getAllShops() {
//        String username = userService.getUsername(token);
        String username = "Bianca";
        return shopRepository.findAllByUsername(username).stream().toList();
    }

    @Override
    public Shop addShop( Shop shop) {
//        String username = userService.getUsername(token);
        String username = "Bianca";
        Shop newShop = Shop.builder().name(shop.getName()).username(username).build();
        return shopRepository.save(newShop);
    }

    @Override
    public Optional<Shop> findById( Long id) {
//        String username = userService.getUsername(token);
        String username = "Bianca";
        return shopRepository.findByShopIdAndUsername(id,username);
    }


}
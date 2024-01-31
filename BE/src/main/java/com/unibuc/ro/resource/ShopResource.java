package com.unibuc.ro.resource;

import com.unibuc.ro.model.Shop;
import com.unibuc.ro.service.ShopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shops")
public class ShopResource {

    private final ShopService shopService;

    public ShopResource(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("/add")
    public ResponseEntity<Shop> addShop(@RequestBody @Valid Shop shop){
        return ResponseEntity.ok(shopService.addShop(shop));
    }

    @GetMapping
    public ResponseEntity<List<Shop>> getAll(){
        return ResponseEntity.ok(shopService.getAllShops());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Shop>> getShopById(@PathVariable("id") Long id){
        return ResponseEntity.ok(shopService.findById(id));
    }


}

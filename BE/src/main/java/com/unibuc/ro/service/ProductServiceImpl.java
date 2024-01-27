package com.unibuc.ro.service;

import com.unibuc.ro.model.Product;
import com.unibuc.ro.model.ProductDto;
import com.unibuc.ro.model.Shop;
import com.unibuc.ro.repository.ProductRepository;
import com.unibuc.ro.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final ShopRepository shopRepository;
    private final ShopService shopService;
    private final UserService userService;

    public ProductServiceImpl(ProductRepository productRepository, ShopRepository shopRepository,
                              ShopService shopService,
                              UserService userService) {
        this.productRepository = productRepository;
        this.shopRepository = shopRepository;
        this.shopService = shopService;
        this.userService = userService;
    }

    @Override
    public List<Product> getAllProducts() {
//        String username = userService.getUsername(token);
        String username = "Bianca";
        return productRepository.findAllByAddedByUser(username).stream().toList();
    }

    @Override
    public List<Product> getAllProductsByShopId( Long shopId) {
//        String username = userService.getUsername(token);
        String username = "Bianca";
        Optional<Shop> shop = shopService.findById(shopId);
        if (shop.isPresent()){
            return productRepository.findAllByShop_ShopId(shopId).stream().toList();
        }
        else {
            throw new RuntimeException("Shop not found");
        }
    }

    @Override
    public Product getProductById( Long id) {
//        String username = userService.getUsername(token);
        String username = "Bianca";
        return productRepository.findByProductIdAndAddedByUser(id,username).orElseThrow(()->new RuntimeException("Product not found"));
    }

    @Override
    public Product addProduct(ProductDto productDto) {
//        String addedByUser = userService.getUsername(token);
        String addedByUser = "Bianca";
        Optional<Shop> shop = shopService.findById( productDto.getShopId());
        if (shop.isPresent()){
            Product newProduct = Product.builder()
                    .name(productDto.getName())
                    .price(productDto.getPrice())
                    .inStock(productDto.isInStock())
                    .discount(productDto.getDiscount())
                    .description(productDto.getDescription())
                    .addedByUser(addedByUser)
                    .shop(shop.get()).build();
            shop.get().getProductsList().add(newProduct);
            shopRepository.save(shop.get());
//            shopService.addShop(token, shop.get());
            return productRepository.save(newProduct);
        }
        else {
            throw new RuntimeException("Shop not found");
        }
    }

    @Override
    public Product updateProductById( Long id, ProductDto productDto) {
//        String username = userService.getUsername(token);
        String username = "Bianca";
        Optional<Product> productToUpdate = productRepository.findById(id);
        if(productToUpdate.isPresent())
        {
            productToUpdate.get().setName(productDto.getName());
            productToUpdate.get().setPrice(productDto.getPrice());
            productToUpdate.get().setDiscount(productDto.getDiscount());
            productToUpdate.get().setInStock(productDto.isInStock());
            Optional<Shop> shop = shopService.findById( productDto.getShopId());
            if (shop.isPresent()){
                productToUpdate.get().setShop(shop.get());
            }
            return productRepository.save(productToUpdate.get());
        }
        else {
            throw new RuntimeException("Product not found");
        }
    }
}
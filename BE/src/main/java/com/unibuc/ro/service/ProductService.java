package com.unibuc.ro.service;

import com.unibuc.ro.model.Product;
import com.unibuc.ro.model.ProductDto;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    List<Product> getAllProductsByShopId( Long shopId);
    Product getProductById( Long id);
    Product addProduct(ProductDto productDto);
    Product updateProductById( Long id, ProductDto productDto);


}

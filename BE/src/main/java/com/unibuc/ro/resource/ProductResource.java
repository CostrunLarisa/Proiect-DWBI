package com.unibuc.ro.resource;

import com.unibuc.ro.model.Product;
import com.unibuc.ro.model.ProductDto;
import com.unibuc.ro.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductResource {
    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody @Valid ProductDto productDto){
        return ResponseEntity.ok(productService.addProduct(productDto));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(productService.getAllProducts());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
        return ResponseEntity.ok(productService.getProductById( id));
    }

    @GetMapping("/shop/{shopId}")
    public ResponseEntity<List<Product>> getAllProductsByShopId(@PathVariable("shopId") Long shopId){
        return ResponseEntity.ok(productService.getAllProductsByShopId( shopId));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProductById(@PathVariable("id") Long id,
                                                     @RequestBody ProductDto productDto) {
        Product productUpdated = productService.updateProductById( id, productDto);
        return new ResponseEntity<>(productUpdated, HttpStatus.OK);
    }

}

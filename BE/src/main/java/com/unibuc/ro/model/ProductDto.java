package com.unibuc.ro.model;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
    @NonNull
    private String name;

    @NonNull
    private Float price;

    private String description;

    private Float discount;

    private char inStock;

    private Long shopId;

    private int stock;

}
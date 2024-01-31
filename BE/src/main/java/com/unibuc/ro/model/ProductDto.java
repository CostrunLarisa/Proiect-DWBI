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

    private boolean inStock;

    private Long shopId;

    private int stock;

}
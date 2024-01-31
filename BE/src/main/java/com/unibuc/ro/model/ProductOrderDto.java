package com.unibuc.ro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductOrderDto implements Serializable {
    private Long productId;
    private Integer quantity;
}

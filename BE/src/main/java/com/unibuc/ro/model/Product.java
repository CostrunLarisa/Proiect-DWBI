package com.unibuc.ro.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name="product")
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @NonNull
    private String name;

    @NonNull
    private Float price;

    private String description;

    private Float discount;

    private boolean inStock;

    private String addedByUser;

    @JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;


}
package com.unibuc.ro.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "product")
@Table(name="product")
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_seq")
    @SequenceGenerator(name = "product_id_seq", sequenceName = "ID", allocationSize = 1)
    @Column(name = "product_id", nullable = false)
    private Long productId;

    @NonNull
    private String name;

    @NonNull
    private Float price;

    private String description;

    private Float discount;

    private char inStock;

    private int stock;

    @JsonBackReference
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    @JsonManagedReference
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY,mappedBy = "product")
    private Set<ProductOrder> orderSet;

}
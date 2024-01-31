package com.unibuc.ro.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="product_order")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prodOrd_id_seq")
    @SequenceGenerator(name = "prodOrd_id_seq", sequenceName = "ID", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long productOrderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product product;

    @NotNull
    private Integer quantity;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    private Order order;

}

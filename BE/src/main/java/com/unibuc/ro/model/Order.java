package com.unibuc.ro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="order")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @NotNull
    private Date datePlaced;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private UserDetails user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="shop_id", nullable = false)
    private Shop shop;

    @OneToMany(mappedBy = "order")
    Set<ProductOrder>  products;

    private Double totalPrice;
}

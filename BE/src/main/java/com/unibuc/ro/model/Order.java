package com.unibuc.ro.model;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="user_order")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @NotNull
    private Date datePlaced;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private UserDetails user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="shop_id", nullable = false)
    private Shop shop;

    @OneToMany(mappedBy = "order")
    Set<ProductOrder>  products;

    private Double totalPrice;
}

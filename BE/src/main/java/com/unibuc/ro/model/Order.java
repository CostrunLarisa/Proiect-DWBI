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
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "order_id_Sequence")
    @SequenceGenerator(name = "order_id_Sequence", sequenceName = "ORDER_ID_SEQ", allocationSize = 1)
    @Column(name = "order_id")
    private Long orderId;

    @NotNull
    private Date datePlaced;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserDetails user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="shop_id", nullable = false)
    private Shop shop;

    @OneToMany(mappedBy = "order")
    Set<ProductOrder>  products;

    private Double totalPrice;

    @OneToMany(mappedBy = "order")
    private Set<Review> reviews;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private OrderAddress orderAddress;
}

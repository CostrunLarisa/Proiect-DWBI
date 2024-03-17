package com.unibuc.ro.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="order_address")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class OrderAddress {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "address_id_Sequence")
    @SequenceGenerator(name = "address_id_Sequence", sequenceName = "ADDRESS_ID_SEQ", allocationSize = 1)
    @Column(name = "address_id")
    private Long addressId;

    private String country;
    private String county;
    private String city;
    private String street;
    private Integer streetNumber;
    private String building;
    private Integer floorNumber;
    private Integer flatNumber;

    @JsonManagedReference
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY,mappedBy = "orderAddress")
    private Set<Order> orders;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserDetails user;
}

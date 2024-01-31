package com.unibuc.ro.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.unibuc.ro.utils.Categorie;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "shop")
@Table(name = "shop")
@Builder
@Getter
@Setter
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shop_id_seq")
    @SequenceGenerator(name = "shop_id_seq", sequenceName = "ID", allocationSize = 1)
    @Column(name = "shop_id", nullable = false)
    private Long shopId;

    private String name;

    @JsonManagedReference
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "shop")
    private List<Product> productsList = new ArrayList<>();

    @OneToMany(mappedBy = "shop")
    private Set<Order> orders;

    private Categorie categorie;
}
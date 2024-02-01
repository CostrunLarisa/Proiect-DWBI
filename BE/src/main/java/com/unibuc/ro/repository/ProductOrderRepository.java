package com.unibuc.ro.repository;

import com.unibuc.ro.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {

    @Query("select po from ProductOrder po where po.product.productId in ?1")
    Set<ProductOrder> findAllByProductId(Set<Long> prodIds);
}

package com.pvit.estore.productsservice.core.data.dao;

import com.pvit.estore.productsservice.core.data.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

    Product findByProductId(String productId);

    Product findByProductIdOrTitle(String productId, String title);
}

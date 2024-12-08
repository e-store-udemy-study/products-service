package com.pvit.estore.productsservice.core.data.dao;

import com.pvit.estore.productsservice.core.data.ProductLookup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductLookupRepository extends JpaRepository<ProductLookup, String> {

    ProductLookup findByProductIdOrTitle(String productId, String title);
}

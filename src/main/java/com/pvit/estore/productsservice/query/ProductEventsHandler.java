package com.pvit.estore.productsservice.query;

import com.pvit.estore.productsservice.core.data.Product;
import com.pvit.estore.productsservice.core.data.dao.ProductRepository;
import com.pvit.estore.productsservice.core.events.ProductCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductEventsHandler {

    private final ProductRepository productRepository;

    public ProductEventsHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventHandler
    public void on(ProductCreatedEvent event) {
        Product product = new Product();
        BeanUtils.copyProperties(event, product);

        productRepository.save(product);
    }
}

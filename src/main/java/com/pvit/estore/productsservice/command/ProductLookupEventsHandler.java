package com.pvit.estore.productsservice.command;

import com.pvit.estore.productsservice.core.data.ProductLookup;
import com.pvit.estore.productsservice.core.data.dao.ProductLookupRepository;
import com.pvit.estore.productsservice.core.events.ProductCreatedEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("product-group")
public class ProductLookupEventsHandler {

    private final ProductLookupRepository productLookupRepository;

    public ProductLookupEventsHandler(ProductLookupRepository productLookupRepository) {
        this.productLookupRepository = productLookupRepository;
    }

    @EventHandler
    public void on(ProductCreatedEvent event) {
        ProductLookup productLookup = new ProductLookup(event.getProductId(), event.getTitle());
        productLookupRepository.save(productLookup);
    }
}

package com.pvit.estore.productsservice.query;

import com.pvit.estore.productsservice.core.data.Product;
import com.pvit.estore.productsservice.core.data.dao.ProductRepository;
import com.pvit.estore.productsservice.model.ProductRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductsQueryHandler {

    private final ProductRepository productRepository;

    public ProductsQueryHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler
    public List<ProductRestModel> findProducts(FindProductsQuery query) {

        List<ProductRestModel> productRestModelList = new ArrayList<>();
        List<Product> products = productRepository.findAll();

        for(Product product : products) {
            ProductRestModel productRestModel = new ProductRestModel();
            BeanUtils.copyProperties(product, productRestModel);
            productRestModelList.add(productRestModel);
        }

        return productRestModelList;
    }
}

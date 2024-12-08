package com.pvit.estore.productsservice.core.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_lookup")
public class ProductLookup implements Serializable {

    @Serial
    private static final long serialVersionUID = 7628446505063709495L;

    @Id
    private String productId;

    @Column(unique = true)
    private String title;
}

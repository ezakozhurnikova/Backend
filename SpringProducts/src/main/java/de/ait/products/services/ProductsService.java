package de.ait.products.services;

import de.ait.products.models.Product;

import java.util.List;

public interface ProductsService {

    void addProduct(String name, int count, boolean expired);
    List<Product> getAllProducts();
}

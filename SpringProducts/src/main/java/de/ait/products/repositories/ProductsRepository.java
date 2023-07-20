package de.ait.products.repositories;


import de.ait.products.models.Product;

import java.util.List;

public interface ProductsRepository {

    void save(Product product);

    List<Product> findAll();
}

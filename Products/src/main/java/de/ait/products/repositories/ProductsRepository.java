package de.ait.products.repositories;

import de.ait.products.models.Product;

import java.util.List;

public interface ProductsRepository {

    List<Product> findAll();
}

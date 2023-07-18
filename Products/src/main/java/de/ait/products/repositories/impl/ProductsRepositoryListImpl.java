package de.ait.products.repositories.impl;

import de.ait.products.models.Product;
import de.ait.products.repositories.ProductsRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductsRepositoryListImpl implements ProductsRepository {

    private List<Product> products = new ArrayList<>();

    public ProductsRepositoryListImpl() {
        Product product1 = new Product("Milk", 6, true);
        Product product2 = new Product("Tomatoes", 100, false);
        Product product3 = new Product("Cherry", 50, false);
        Product product4 = new Product("Meat", 11, true);

        this.products = Arrays.asList(product1, product2, product3, product4);
    }

    @Override
    public List<Product> findAll() {
        return products;
    }
}

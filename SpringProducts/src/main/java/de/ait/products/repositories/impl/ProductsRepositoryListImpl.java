package de.ait.products.repositories.impl;

import de.ait.products.models.Product;
import de.ait.products.repositories.ProductsRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductsRepositoryListImpl implements ProductsRepository {

    private List<Product> products = new ArrayList<>();

    @Override
    public void save(Product product) {
        this.products.add(product);
    }

    @Override
    public List<Product> findAll() {
        return products;
    }
}

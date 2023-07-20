package de.ait.products.services.impl;


import de.ait.products.models.Product;
import de.ait.products.repositories.ProductsRepository;
import de.ait.products.services.ProductsService;
import de.ait.products.validators.NameValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductsServiceImpl implements ProductsService {

    private final ProductsRepository productsRepository;
    private final NameValidator nameValidator;


    @Override
    public void addProduct(String name, int count, boolean expired) {
        nameValidator.validate(name);
        Product product = new Product(name, count, expired);
        productsRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productsRepository.findAll();
    }
}

package de.ait.products.services.impl;

import de.ait.products.models.Product;
import de.ait.products.repositories.ProductsRepository;
import de.ait.products.services.ProductsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    private final ProductsRepository productsRepository;
    public ProductsServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }
    @Override
    public List<Product> getAllProducts() {
        return productsRepository.findAll();
    }
}

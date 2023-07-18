package de.ait.products.controllers;

import de.ait.products.services.ProductsService;
import de.ait.products.services.impl.ProductsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductsController {

    private final ProductsService productsService;

    public ProductsController (ProductsServiceImpl service) {
        this.productsService = service;
    }

    @GetMapping("/products")
    @ResponseBody
    public List<de.ait.products.models.Product> getAllProducts() {
        return productsService.getAllProducts();
    }
}

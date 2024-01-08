package com.example.webshopapi.dao;

import com.example.webshopapi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductDAO {

    private final ProductRepository productRepository;

    @Autowired
    public ProductDAO(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    public Product save(Product newProduct) {
        return productRepository.save(newProduct);
    }

    public List<Product> getProductsByCategory(int categoryid) {
        return productRepository.findByCategoryId(categoryid);
    }
}

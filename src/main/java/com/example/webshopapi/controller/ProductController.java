package com.example.webshopapi.controller;

import com.example.webshopapi.dao.CustomerDAO;
import com.example.webshopapi.dao.ProductDAO;
import com.example.webshopapi.model.Product;
import com.example.webshopapi.service.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private final ProductDAO productDAO;


    private final CustomerDAO customerDAO;
    @Autowired
    public ProductController(ProductDAO productDAO, CustomerDAO customerDAO) {
        this.productDAO = productDAO;
        this.customerDAO = customerDAO;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(@RequestParam UUID id) {
        if (customerDAO.existsByIdAndRole(id, Role.ADMIN)) {
            List<Product> products = productDAO.getAllProducts();
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable int id) {
            return productDAO.getProductById(id);
    }


    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable int categoryId) {
        List<Product> products = productDAO.getProductsByCategory(categoryId);
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product, UUID id) {
        if (customerDAO.existsByIdAndRole(id, Role.ADMIN)) {
            Product createdProduct = productDAO.save(product);
            return ResponseEntity.ok(createdProduct);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    }
}


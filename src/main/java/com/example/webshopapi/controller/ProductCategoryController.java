package com.example.webshopapi.controller;

import com.example.webshopapi.dao.ProductCategoryDAO;
import com.example.webshopapi.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productcategory")
@CrossOrigin(origins = "*")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryDAO productCategoryDAO;

    @GetMapping
    public List<ProductCategory> getAllProductCategories() {
        return productCategoryDAO.getAllProductCategories();
    }

    @GetMapping("/{id}")
    public ProductCategory getProductCategoryById(@PathVariable int id) {
        return productCategoryDAO.getProductCategoryById(id);
    }


}

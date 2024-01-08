package com.example.webshopapi.dao;

import com.example.webshopapi.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductCategoryDAO {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public List<ProductCategory> getAllProductCategories() {
        return productCategoryRepository.findAll();
    }

    public ProductCategory getProductCategoryById(int id) {
        return productCategoryRepository.findById(id).orElse(null);
    }

    public ProductCategory saveProductCategory(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    public void deleteProductCategory(int id) {
        productCategoryRepository.deleteById(id);
    }
}

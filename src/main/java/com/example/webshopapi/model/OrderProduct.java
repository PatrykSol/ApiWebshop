package com.example.webshopapi.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

@Entity
@Table(name = "orderproduct")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    private Back_Order order;

    @ManyToOne
    private Product product;

    private int quantity;

    public OrderProduct(Back_Order order, Product product, int numberOfProducts) {
        this.order = order;
        this.product = product;
        this.quantity = numberOfProducts;
    }

    public OrderProduct() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Back_Order getOrder() {
        return order;
    }

    public void setOrder(Back_Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int numberOfProducts) {
        this.quantity = numberOfProducts;
    }
}

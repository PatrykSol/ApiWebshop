package com.example.webshopapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class OrderProductId implements Serializable {
    @Column(name = "order_id")
    private UUID orderId;

    @Column(name = "product_id")
    private int productId;

}

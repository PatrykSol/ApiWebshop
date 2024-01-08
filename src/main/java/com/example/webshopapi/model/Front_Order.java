package com.example.webshopapi.model;


import java.util.UUID;

public class Front_Order {

    private UUID id;

    private UUID userid;

    private String status;

    private String order_date;

    private OrderProduct[] orderProducts;

    public Front_Order(UUID id, UUID userid, String status, String order_date, OrderProduct[] orderProducts) {
        this.id = id;
        this.userid = userid;
        this.status = status;
        this.order_date = order_date;
        this.orderProducts = orderProducts;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public OrderProduct[] getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(OrderProduct[] orderProducts) {
        this.orderProducts = orderProducts;
    }

    public UUID getUser() {
        return userid;
    }

    public void setUser(UUID userid) {
        this.userid = userid;
    }

    public String getOrderDate() {
        return order_date;
    }

    public void setOrderDate(String order_date) {
        this.order_date = order_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

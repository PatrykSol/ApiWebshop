package com.example.webshopapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Back_Order {


    @Id
    private UUID id;

    private UUID userid;

    private String status;

//    private double totalAmount;

    private String order_date;

    public Back_Order() {
    }

    public Back_Order(UUID id, UUID userid, String status, String order_date, List<OrderProduct> products) {
        this.id = id;
        this.userid = userid;
        this.status = status;
        this.order_date = order_date;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserid() {
        return userid;
    }

    public void setUserid(UUID userid) {
        this.userid = userid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }
}

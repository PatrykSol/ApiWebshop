package com.example.webshopapi.dao;

import com.example.webshopapi.model.OrderProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderProductDAO {

    @Autowired
    private OrderProductRepository orderProductRepository;

    public OrderProduct save(OrderProduct orderProduct) {
        return orderProductRepository.save(orderProduct);
    }

    public List<OrderProduct> findAll() {
        return orderProductRepository.findAll();
    }

    public List<OrderProduct> findByOrderId(UUID orderId) {
        return orderProductRepository.findByOrderId(orderId);
    }

    public void delete(OrderProduct orderProduct) {
        orderProductRepository.delete(orderProduct);
    }
}

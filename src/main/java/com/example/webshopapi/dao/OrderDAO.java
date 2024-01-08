package com.example.webshopapi.dao;

import com.example.webshopapi.model.Back_Order;
import com.example.webshopapi.model.OrderProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderDAO {

    @Autowired
    private OrderRepository orderRepository;

    public Back_Order save(Back_Order order) {
        // Manually set UUID if not already set
        if (order.getId() == null) {
            order.setId(UUID.randomUUID());
        }
        return orderRepository.save(order);
    }

    public List<Back_Order> findAll() {
        return (List<Back_Order>) orderRepository.findAll();
    }

    public Optional<Back_Order> findById(UUID id) {
        return orderRepository.findById(id);
    }


    public void delete(Back_Order order) {
        orderRepository.delete(order);
    }

}

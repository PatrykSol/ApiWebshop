package com.example.webshopapi.dao;


import com.example.webshopapi.model.Back_Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Back_Order, UUID> {
}

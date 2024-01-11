package com.example.webshopapi.dao;

import com.example.webshopapi.model.Customer;
import com.example.webshopapi.service.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    Optional<Customer> findByUsername(String username);

    Optional<Customer> findByEmail(String email);
    boolean existsByUsernameAndRole(String username, Role role);

    boolean existsByIdAndRole(UUID id,Role role);

}
package com.example.webshopapi.service;

import com.example.webshopapi.dao.CustomerRepository;
import com.example.webshopapi.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// CustomerService.java
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public Customer save(Customer account) {
        return this.customerRepository.save(account);
    }

    public List<Customer> findAll() {
        return (List<Customer>) this.customerRepository.findAll();
    }

    public Optional<Customer> findById(UUID id) {
        return this.customerRepository.findById(id);
    }

    public Optional<Customer> findByName(String username) {
        return this.customerRepository.findByUsername(username);
    }

    public void delete(Customer account) {
        this.customerRepository.delete(account);
    }
}




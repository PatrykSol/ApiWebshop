package com.example.webshopapi.dao;

import com.example.webshopapi.model.Customer;
import com.example.webshopapi.service.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerDAO {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(UUID id) {
        return customerRepository.findById(id).orElse(null);
    }

    public boolean existsByIdAndRole(UUID id, Role role){
        return customerRepository.existsByIdAndRole(id, role);
    }

//    public boolean existsByUsernameAndRole(UUID id, Role role) {
//        return customerRepository.existsByIdAndRole(id, role);
//    }
}


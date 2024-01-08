package com.example.webshopapi.seeder;

import com.example.webshopapi.controller.CustomerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder {
    private boolean alreadySeeded = false;

    @Autowired
    private ProductSeeder productSeeder;

    @Autowired
    private CustomerController customerController;


//    @EventListener(ApplicationReadyEvent.class)
//    public void seed() {
//        if (!alreadySeeded) {
//            customerController.createAdminAccount();
//            alreadySeeded = true;
//        }
//    }
}

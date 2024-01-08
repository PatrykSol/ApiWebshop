package com.example.webshopapi.controller;

import com.example.webshopapi.model.Customer;
import com.example.webshopapi.service.CustomerService;
import com.example.webshopapi.service.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public CustomerController(CustomerService customerService, BCryptPasswordEncoder passwordEncoder) {
        this.customerService = customerService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<Customer> getAccount(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String enteredPassword = credentials.get("password");

        Optional<Customer> optionalAccount = customerService.findByName(username);
        if (optionalAccount.isPresent()) {
            Customer account = optionalAccount.get();
            String storedSalt = account.getSalt();
            String hashedEnteredPassword = hashPassword(enteredPassword, storedSalt);

            if (passwordEncoder.matches(enteredPassword, account.getPassword())) {
                return ResponseEntity.status(HttpStatus.OK).body(account);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @PostMapping("/create-account")
    public ResponseEntity<Customer> createAccount(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");
        String email = credentials.get("email");

        String salt = generateRandomSalt();
        String saltedPassword = password + salt;

        Customer account = new Customer();
        account.setUsername(username);
        account.setPassword(passwordEncoder.encode(password));
        account.setSalt(salt);
        account.setRole(Role.CUSTOMER);
        account.setEmail(email);

        this.customerService.save(account);

        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }

    private String generateRandomSalt() {
        SecureRandom random = new SecureRandom();
        byte[] saltBytes = new byte[16];
        random.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);
    }

    private String hashPassword(String password, String salt) {
        String saltedPassword = password + salt;

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = messageDigest.digest(saltedPassword.getBytes(StandardCharsets.UTF_8));

            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password.", e);
        }
    }
}
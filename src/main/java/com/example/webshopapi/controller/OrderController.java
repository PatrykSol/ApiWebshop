package com.example.webshopapi.controller;

import com.example.webshopapi.dao.CustomerDAO;
import com.example.webshopapi.dao.OrderDAO;
import com.example.webshopapi.model.Back_Order;
import com.example.webshopapi.model.Front_Order;
import com.example.webshopapi.model.OrderProduct;
import com.example.webshopapi.service.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
    @Autowired
    private final OrderDAO orderDAO;

    private final ProductOrderController productOrderController;
    private final CustomerDAO customerDAO;

    public OrderController(OrderDAO orderDAO, ProductOrderController productOrderController, CustomerDAO customerDAO) {
        this.orderDAO = orderDAO;
        this.productOrderController = productOrderController;
        this.customerDAO = customerDAO;
    }

    @PostMapping
    public ResponseEntity<Front_Order> createOrder(@RequestBody Front_Order frontendOrder) {
        System.out.println(frontendOrder.getId() + "\n" + frontendOrder.getUser()+ "\n" + Arrays.toString(frontendOrder.getOrderProducts()) + "\n" + frontendOrder.getOrderDate() + "\n" + frontendOrder.getStatus());

        Back_Order backendOrder = rewriteOrder(frontendOrder);
        System.out.println(backendOrder.getId());

        orderDAO.save(backendOrder);
        productOrderController.saveProducts(backendOrder, frontendOrder);

        return ResponseEntity.ok(frontendOrder);
    }

    private Back_Order rewriteOrder(Front_Order frontendOrder) {
        return new Back_Order(frontendOrder.getId(), frontendOrder.getUser(), frontendOrder.getStatus(), frontendOrder.getOrderDate(),Arrays.asList(frontendOrder.getOrderProducts()));
    }

    @GetMapping
    public ResponseEntity<List<Front_Order>> getAllOrders(@RequestParam(name = "id") UUID id) {
        if (customerDAO.existsByIdAndRole(id, Role.ADMIN)) {
            List<Back_Order> backendOrders = orderDAO.findAll();
            List<Front_Order> frontendOrders = backendOrders.stream()
                    .map(this::convertToFrontendOrder)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(frontendOrders);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    private Front_Order convertToFrontendOrder(Back_Order backendOrder) {
        return new Front_Order(
                backendOrder.getId(),
                backendOrder.getUserid(),
                backendOrder.getStatus(),
                backendOrder.getOrder_date(),
                findProductsByOrder(backendOrder.getId())
        );
    }

    private OrderProduct[] findProductsByOrder(UUID id){
        return this.productOrderController.getProductsByOrderId(id);
    }
}

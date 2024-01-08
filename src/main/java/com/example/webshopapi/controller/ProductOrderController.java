package com.example.webshopapi.controller;

import com.example.webshopapi.dao.OrderProductDAO;
import com.example.webshopapi.model.Back_Order;
import com.example.webshopapi.model.Front_Order;
import com.example.webshopapi.model.OrderProduct;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
public class ProductOrderController {

    @Autowired
    private OrderProductDAO orderProductDAO;

    public void saveProducts(Back_Order backendOrder, Front_Order frontendOrder){
        for (OrderProduct product : frontendOrder.getOrderProducts()){
            OrderProduct productInShoppingCart = new OrderProduct(backendOrder, product.getProduct(), product.getQuantity());
            this.orderProductDAO.save(productInShoppingCart);
        }
    }

    public OrderProduct[] getProductsByOrderId(UUID orderId) {
        List<OrderProduct> orderProducts = this.orderProductDAO.findByOrderId(orderId);

        return orderProducts.toArray(new OrderProduct[0]);
    }

}

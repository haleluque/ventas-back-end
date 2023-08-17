package com.hluque.sales.controllers;

import com.hluque.sales.entities.Order;
import com.hluque.sales.entities.Product;
import com.hluque.sales.services.OrderService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderServiceImp;
    
    @GetMapping
    public List<Order> getAllOrders(){
        return orderServiceImp.getAllOrders();
    }
    
    @GetMapping("/{serial}")
    public Order getBySerial(@PathVariable UUID serial) {
        return orderServiceImp.getOrderBySerial(serial);
    }
    
    @PostMapping
    public Order insertOrder(@RequestBody Order order){
        return orderServiceImp.insertOrder(order);
    }
    
    @PutMapping("/{serial}")
    public void addProductToOrder(@PathVariable UUID serial, @RequestBody Product product){
        orderServiceImp.addProductToOrder(serial, product);
    }
}

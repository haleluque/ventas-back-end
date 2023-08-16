package com.hluque.sales.controllers;

import com.hluque.sales.entities.Order;
import com.hluque.sales.services.OrderServiceImp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderServiceImp orderServiceImp;
    
    @GetMapping
    public List<Order> getAllOrders(){
        return orderServiceImp.getAllOrders();
    }
}

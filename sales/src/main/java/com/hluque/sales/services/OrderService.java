package com.hluque.sales.services;

import com.hluque.sales.entities.Order;
import com.hluque.sales.entities.Product;
import java.util.List;
import java.util.UUID;

public interface OrderService {
    
    public Order getOrderBySerial(UUID serial);
    
    public List<Order> getAllOrders();
    
    public Order insertOrder(Order order);
    
    public void addProductToOrder(Product product);
}

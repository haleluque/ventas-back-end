package com.hluque.sales.services;

import com.hluque.sales.entities.Order;
import com.hluque.sales.entities.Product;
import com.hluque.sales.repositories.OrderRepo;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Override
    public Order getOrderBySerial(UUID serial) {
        Optional<Order> order = orderRepo.findByOrderSerial(serial);
        return order.isPresent() ? order.get() : null;
    }

    public double calculateTotalOrder(UUID serial) {
        Order order = getOrderBySerial(serial);
        if (order == null) {
            throw new NoSuchElementException("The order with serial " + serial + " doesn't exist");
        }
        return order.calculateTotal();
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public Order insertOrder(Order order) {
        return orderRepo.save(order);
    }

    @Override
    public void addProductToOrder(UUID orderSerial, Product product) {
        Order order = getOrderBySerial(orderSerial);
        if (order == null) {
            throw new NoSuchElementException("The order with serial " + orderSerial + " doesn't exist");
        }
        order.getProducts().add(product);
        orderRepo.save(order);
    }
}

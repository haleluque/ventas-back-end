package com.hluque.sales.entities;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "order")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "order_serial")
    private UUID orderSerial;

    public Order() {
    }    
    
    public Order(Set<Product> products, UUID orderSerial) {
        this.products = products;
        this.orderSerial = orderSerial;
    }

    @ManyToMany
    @JoinTable(
            name = "order_products",
            joinColumns = @JoinColumn(name = "id_order", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_product", referencedColumnName = "id"))
    private Set<Product> products;

    public Long getId() {
        return id;
    }

    public UUID getOrderSerial() {
        return orderSerial;
    }

    public Set<Product> getProducts() {
        return products == null ? new HashSet<>() : products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public double calculateTotal() {
        double totalProducts = 0;
        for (Product product : this.getProducts()) {
            totalProducts += product.getPrice();
        }
        return totalProducts;
    }
}

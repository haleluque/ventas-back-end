package com.hluque.sales.controllers;

import com.hluque.sales.entities.Product;
import com.hluque.sales.services.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @GetMapping
    public List<Product> getAllOrders(){
        return productService.getAllProducts();
    }
    
    @GetMapping("/{id}")
    public Product getBySerial(@PathVariable long id) {
        return productService.getProductById(id);
    }
    
    @PostMapping
    public Product insertProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
    
    @PutMapping
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

}

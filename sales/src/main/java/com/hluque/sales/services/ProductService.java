package com.hluque.sales.services;

import com.hluque.sales.entities.Product;
import java.util.List;

public interface ProductService {

    public Product getProductById(long id);

    public List<Product> getAllProducts();

    public Product createProduct(Product product);

    public Product updateProduct(Product product);
}

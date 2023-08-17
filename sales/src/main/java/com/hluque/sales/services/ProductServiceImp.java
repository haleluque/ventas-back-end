package com.hluque.sales.services;

import com.hluque.sales.entities.Product;
import com.hluque.sales.repositories.ProductRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    public ProductRepo productRepo;

    @Override
    public Product getProductById(long id) {
        Optional<Product> product = productRepo.findById(id);
        return product.isPresent() ? product.get() : null;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product foundProduct = getProductById(product.getId());
        foundProduct.setName(product.getName());
        foundProduct.setPrice(product.getPrice());
        return productRepo.save(foundProduct);
    }
}

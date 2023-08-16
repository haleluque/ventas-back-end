package com.hluque.sales.controllers;

import com.hluque.sales.services.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class ProductController {

    @Autowired
    private ProductServiceImp productServiceImp;

}

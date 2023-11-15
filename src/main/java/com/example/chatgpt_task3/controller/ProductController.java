package com.example.chatgpt_task3.controller;

import com.example.chatgpt_task3.model.Product;
import com.example.chatgpt_task3.model.User;
import com.example.chatgpt_task3.service.CartService;
import com.example.chatgpt_task3.service.OrderService;
import com.example.chatgpt_task3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }
}



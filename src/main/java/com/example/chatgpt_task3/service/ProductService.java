package com.example.chatgpt_task3.service;

import com.example.chatgpt_task3.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long productId);
}


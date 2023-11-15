package com.example.chatgpt_task3.service.impl;

import com.example.chatgpt_task3.model.Cart;
import com.example.chatgpt_task3.model.Product;
import com.example.chatgpt_task3.model.User;
import com.example.chatgpt_task3.repository.CartRepository;
import com.example.chatgpt_task3.repository.ProductRepository;
import com.example.chatgpt_task3.repository.UserRepository;
import com.example.chatgpt_task3.service.CartService;
import com.example.chatgpt_task3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }
}



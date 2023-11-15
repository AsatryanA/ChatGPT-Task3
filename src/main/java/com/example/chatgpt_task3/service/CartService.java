package com.example.chatgpt_task3.service;

import com.example.chatgpt_task3.model.Product;
import com.example.chatgpt_task3.model.User;

import java.util.List;

public interface CartService {
    void addToCart(User user, Long productId);

    void removeFromCart(User user, Long productId);

    List<Product> getCartProducts(User user);
}

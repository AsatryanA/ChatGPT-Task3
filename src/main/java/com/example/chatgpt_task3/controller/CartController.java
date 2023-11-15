package com.example.chatgpt_task3.controller;

import com.example.chatgpt_task3.model.Product;
import com.example.chatgpt_task3.model.User;
import com.example.chatgpt_task3.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add/{productId}")
    public void addToCart(@PathVariable Long productId, @RequestBody User user) {
        cartService.addToCart(user, productId);
    }

    @PostMapping("/remove/{productId}")
    public void removeFromCart(@PathVariable Long productId, @RequestBody User user) {
        cartService.removeFromCart(user, productId);
    }

    @GetMapping
    public List<Product> getCartProducts(@RequestBody User user) {
        return cartService.getCartProducts(user);
    }
}

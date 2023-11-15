package com.example.chatgpt_task3.service.impl;

import com.example.chatgpt_task3.model.Cart;
import com.example.chatgpt_task3.model.Product;
import com.example.chatgpt_task3.model.User;
import com.example.chatgpt_task3.repository.CartRepository;
import com.example.chatgpt_task3.repository.ProductRepository;
import com.example.chatgpt_task3.repository.UserRepository;
import com.example.chatgpt_task3.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addToCart(User user, Long productId) {
        Cart cart = user.getCart();
        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
        }

        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            cart.getProducts().add(product);
            cartRepository.save(cart);
        }
    }

    @Override
    public void removeFromCart(User user, Long productId) {
        Cart cart = user.getCart();
        if (cart != null) {
            Product product = productRepository.findById(productId).orElse(null);
            if (product != null) {
                cart.getProducts().remove(product);
                cartRepository.save(cart);
            }
        }
    }

    @Override
    public List<Product> getCartProducts(User user) {
        Cart cart = user.getCart();
        return (cart != null) ? (List<Product>) cart.getProducts() : List.of();
    }
}

package com.example.chatgpt_task3.service.impl;

import com.example.chatgpt_task3.model.Cart;
import com.example.chatgpt_task3.model.Order;
import com.example.chatgpt_task3.model.User;
import com.example.chatgpt_task3.repository.CartRepository;
import com.example.chatgpt_task3.repository.OrderRepository;
import com.example.chatgpt_task3.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, CartRepository cartRepository) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public void placeOrder(User user) {
        Cart cart = user.getCart();
        if (cart != null && !cart.getProducts().isEmpty()) {
            Order order = new Order();
            order.setUser(user);
            order.setProducts(cart.getProducts());

            orderRepository.save(order);

            // Clear the user's cart after placing the order
            cart.getProducts().clear();
            cartRepository.save(cart);
        }
    }
}

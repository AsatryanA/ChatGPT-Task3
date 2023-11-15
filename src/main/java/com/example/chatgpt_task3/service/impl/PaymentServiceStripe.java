package com.example.chatgpt_task3.service.impl;

import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceStripe {

    // Stripe API key obtained from the dashboard
    private static final String STRIPE_SECRET_KEY = "your_stripe_secret_key";

    static {
        Stripe.apiKey = STRIPE_SECRET_KEY;
    }

    public String createPaymentIntent(Double amount, String currency) {
        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                .setAmount((long) (amount * 100)) // Amount in cents
                .setCurrency(currency)
                .build();

        try {
            PaymentIntent paymentIntent = PaymentIntent.create(params);
            return paymentIntent.getClientSecret();
        } catch (Exception e) {
            // Handle exception
            return null;
        }
    }
}

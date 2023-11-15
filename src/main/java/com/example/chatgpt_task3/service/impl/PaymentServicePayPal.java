package com.example.chatgpt_task3.service.impl;


import org.springframework.stereotype.Service;

@Service
public class PaymentServicePayPal{

    // PayPal credentials obtained from the dashboard
    private static final String PAYPAL_CLIENT_ID = "your_paypal_client_id";
    private static final String PAYPAL_CLIENT_SECRET = "your_paypal_client_secret";

    private final PayPalHttpClient client;

    public PaymentService() {
        PayPalEnvironment environment = new PayPalEnvironment.Sandbox(PAYPAL_CLIENT_ID, PAYPAL_CLIENT_SECRET);
        this.client = new PayPalHttpClient(environment);
    }

    public boolean captureOrder(String orderId) {
        try {
            OrdersCaptureRequest request = new OrdersCaptureRequest(orderId);
            Order response = client.execute(request);

            // Check if the payment was successful
            return "COMPLETED".equals(response.result().status());
        } catch (Exception e) {
            // Handle exception
            return false;
        }
    }
}

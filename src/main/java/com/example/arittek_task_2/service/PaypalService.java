package com.example.arittek_task_2.service;

import org.springframework.stereotype.Service;

@Service("paypalService")
public class PaypalService implements PaymentService {

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal");
    }
}

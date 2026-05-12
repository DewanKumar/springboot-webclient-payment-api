package com.example.arittek_task_2.service;

import com.example.arittek_task_2.dto.PaymentDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaymentProcessor {

    private final PaymentService paymentService;

    // if you try for the primary then remove the Qualifier
//
    public PaymentProcessor(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public String process(PaymentDTO dto) {

        paymentService.pay(dto.getAmount());

        return "Payment successful using selected service";
    }
}
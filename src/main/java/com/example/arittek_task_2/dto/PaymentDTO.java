package com.example.arittek_task_2.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


public class PaymentDTO {

    @NotBlank(message = "Payment method is required")
    private String method;

    @Min(value = 1, message = "Amount must be greater than 0")
    private double amount;

    // getters and setters
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
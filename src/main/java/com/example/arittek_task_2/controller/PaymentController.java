package com.example.arittek_task_2.controller;

import com.example.arittek_task_2.dto.PaymentDTO;
import com.example.arittek_task_2.service.PaymentProcessor;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentProcessor processor;

    public PaymentController(PaymentProcessor processor) {
        this.processor = processor;
    }

    @PostMapping
    public String pay(@Valid @RequestBody PaymentDTO dto) {
        return processor.process(dto);
    }
}
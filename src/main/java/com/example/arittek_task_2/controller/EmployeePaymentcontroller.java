package com.example.arittek_task_2.controller;

import com.example.arittek_task_2.dto.EmployeeDTO;
import com.example.arittek_task_2.service.EmployeePaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/client")
public class EmployeePaymentcontroller {
    @Autowired
    private EmployeePaymentService employeePaymentService;
    @GetMapping("/employee")
    public Flux<EmployeeDTO> getEmployees(){
        return employeePaymentService.getEmployeesWithSalaryLessThan80K();
    }
}

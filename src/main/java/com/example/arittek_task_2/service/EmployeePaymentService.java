package com.example.arittek_task_2.service;

import com.example.arittek_task_2.dto.EmployeeDTO;
import com.example.arittek_task_2.exception.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeePaymentService {

    @Autowired
    private WebClient webClient;

    public Flux<EmployeeDTO> getEmployeesWithSalaryLessThan80K() {

        return webClient.get()
                .uri("/employee/salary")

                .retrieve()

                // Handle 4xx and 5xx
                .onStatus(
                        HttpStatusCode::isError,

                        response -> response.bodyToMono(String.class)
                                .flatMap(errorBody -> Mono.error(
                                        new ApiException(
                                                errorBody,
                                                response.statusCode().value()
                                        )
                                ))
                )

                .bodyToFlux(EmployeeDTO.class)

                // Connection / timeout errors
                .onErrorMap(ex -> {

                    if (ex instanceof ApiException) {
                        return ex;
                    }

                    return new ApiException(
                            "External API Failed: " + ex.getMessage(),
                            500
                    );
                });
    }
}

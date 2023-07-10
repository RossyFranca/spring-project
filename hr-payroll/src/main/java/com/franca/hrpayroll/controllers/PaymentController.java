package com.franca.hrpayroll.controllers;

import com.franca.hrpayroll.entities.Payment;
import com.franca.hrpayroll.services.PaymentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @CircuitBreaker(name = "paymentCircuitBreaker", fallbackMethod = "getPaymentAlternative")
    @Retry(name = "paymentRetry")
    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {

        Payment payment = paymentService.getPayment(workerId, days);
        return ResponseEntity.ok(payment);

    }

    public ResponseEntity<String> fallback(Long workerId, Integer days,Exception e){
        System.out.println(e);
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Sem comunicação");
    }

    public ResponseEntity<String> getPaymentAlternative(Long workerId, Integer days, Throwable t) {
        System.out.println("Doesnt work");
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Serviço indisponível no momento");
    }
}

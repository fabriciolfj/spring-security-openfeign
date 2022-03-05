package com.github.fabriciolfj.paymentservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Payment> getAll() {
        return Arrays.asList(
                new Payment(1L, "teste1"),
                new Payment(2L, "teste2")
        );
    }

}

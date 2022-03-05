package com.github.fabriciolfj.clientservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "http://localhost:9090/api/v1/payments", name = "payment-client", configuration = OAuthFeignConfig.class)
public interface PaymentClient {

    @GetMapping
    List<Payment> get();
}

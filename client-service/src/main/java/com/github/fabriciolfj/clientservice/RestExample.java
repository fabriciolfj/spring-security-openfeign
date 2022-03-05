package com.github.fabriciolfj.clientservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/example")
public class RestExample {

    private final PaymentClient paymentClient;

    @GetMapping
    public void get() {
        paymentClient.get()
                .forEach(v -> log.info(v.toString()));
    }
}

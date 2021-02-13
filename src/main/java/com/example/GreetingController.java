package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GreetingController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/services")
    public List<String> services() {
        return this.discoveryClient.getServices();
    }

    @Value("${greeting.message:Hello}")
    private String message;

    @Value("${greeting.secret:Unknown}")
    private String secret;

    @Value("${customer.info}")
    private String info;


    @GetMapping("/message")
    public String hello() {
        return message;
    }

    @GetMapping("/secret")
    public String getSecret() {
        return secret;
    }

    @GetMapping("/info")
    public String info() {
        return info;
    }

}

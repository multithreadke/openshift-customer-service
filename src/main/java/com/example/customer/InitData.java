package com.example.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Profile(value = "local")
public class InitData implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        customerRepository.save(new Customer("John", "Doe"));
        customerRepository.save(new Customer("Jane", "Doe"));
    }
}

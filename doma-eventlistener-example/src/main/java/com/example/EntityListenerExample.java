package com.example;

import java.time.Clock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EntityListenerExample {

    public static void main(final String[] args) {
        SpringApplication.run(EntityListenerExample.class, args);
    }

    @Bean
    public Clock clock() {
        return Clock.systemUTC();
    }
}

package com.example;

import java.time.Clock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EntityListenerSample {

    public static void main(final String[] args) {
        SpringApplication.run(EntityListenerSample.class, args);
    }

    @Bean
    public Clock clock() {
        return Clock.systemUTC();
    }
}

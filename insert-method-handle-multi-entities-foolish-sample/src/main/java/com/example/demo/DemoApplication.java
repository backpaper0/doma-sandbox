package com.example.demo;

import org.seasar.doma.boot.autoconfigure.DomaConfigBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.misc.FoolishQueryImplementors;

@SpringBootApplication
public class DemoApplication {

    public static void main(final String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public DomaConfigBuilder domaConfigBuilder() {
        return new DomaConfigBuilder()
                .queryImplementors(new FoolishQueryImplementors());
    }
}

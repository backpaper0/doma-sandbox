package com.example.jdbc;

import org.seasar.doma.boot.autoconfigure.DomaConfigBuilder;
import org.seasar.doma.jdbc.QueryImplementors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomaAutoConfigurationOverrider {

    @Bean
    public DomaConfigBuilder domaConfigBuilder(final QueryImplementors queryImplementors) {
        return new DomaConfigBuilder().queryImplementors(queryImplementors);
    }
}

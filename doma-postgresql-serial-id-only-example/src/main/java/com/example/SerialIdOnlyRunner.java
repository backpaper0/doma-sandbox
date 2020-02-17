package com.example;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SerialIdOnlyRunner implements ApplicationRunner {

    private final SerialIdOnlyDao dao;

    public SerialIdOnlyRunner(final SerialIdOnlyDao dao) {
        this.dao = dao;
    }

    @Override
    public void run(final ApplicationArguments args) throws Exception {
        final SerialIdOnly entity = dao.insertBySqlFile();
        System.out.println(entity);
    }
}

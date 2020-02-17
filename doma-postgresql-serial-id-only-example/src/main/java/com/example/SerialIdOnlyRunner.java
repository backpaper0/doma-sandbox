package com.example;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class SerialIdOnlyRunner implements ApplicationRunner {

    private final SerialIdOnlyDao dao;

    public SerialIdOnlyRunner(final SerialIdOnlyDao dao) {
        this.dao = dao;
    }

    @Override
    public void run(final ApplicationArguments args) throws Exception {
        final SerialIdOnly entity1 = dao.insertBySqlFile();
        System.out.println(entity1);

        final SerialIdOnly entity2 = dao.insert(new SerialIdOnly(null)).getEntity();
        System.out.println(entity2);

        final SerialIdAndVal entity3 = dao.insert(new SerialIdAndVal(null, 123)).getEntity();
        System.out.println(entity3);
    }
}

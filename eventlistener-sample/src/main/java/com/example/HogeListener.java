package com.example;

import java.time.Clock;
import java.time.LocalDateTime;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HogeListener implements EntityListener<Hoge> {

    @Autowired
    private Clock clock;

    @Override
    public void preInsert(final Hoge entity, final PreInsertContext<Hoge> context) {
        entity.baz = LocalDateTime.now(clock);
    }
}

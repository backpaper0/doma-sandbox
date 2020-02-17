package com.example.jdbc;

import java.lang.reflect.Method;

import org.seasar.doma.jdbc.QueryImplementors;
import org.seasar.doma.jdbc.entity.EntityType;
import org.seasar.doma.jdbc.query.AutoInsertQuery;
import org.springframework.stereotype.Component;

@Component
public class SerialIdOnlyQueryImplementors implements QueryImplementors {

    @Override
    public <ENTITY> AutoInsertQuery<ENTITY> createAutoInsertQuery(final Method method,
            final EntityType<ENTITY> entityType) {
        return new SerialIdOnlyAutoInsertQuery<>(entityType);
    }
}

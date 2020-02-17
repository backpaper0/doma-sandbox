package com.example.demo.misc;

import org.seasar.doma.jdbc.entity.EntityType;

public final class EntityTypes {
    public static EntityType<?> getEntityType(final Object entity) {
        try {
            final Class<?> entityClass = entity.getClass();
            final String className = entityClass.getPackage().getName()
                    + "._"
                    + entityClass.getSimpleName();
            return (EntityType<?>) Class
                    .forName(className)
                    .getMethod("getSingletonInternal")
                    .invoke(null);
        } catch (final ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }
}

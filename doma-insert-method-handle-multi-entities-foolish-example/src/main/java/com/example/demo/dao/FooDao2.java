package com.example.demo.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.builder.InsertBuilder;
import org.seasar.doma.jdbc.entity.EntityType;

import com.example.demo.entity.Foo;
import com.example.demo.misc.EntityTypes;

@Dao
@ConfigAutowireable
public interface FooDao2 {

    default int insertByBuilder(final Foo entity) {
        final EntityType<?> entityType = EntityTypes.getEntityType(entity);
        final Config config = Config.get(this);
        return InsertBuilder.newInstance(config)
                .sql("INSERT INTO ")
                .sql(entityType.getTableName())
                .sql(" (val) VALUES (")
                .param(String.class, entity.val)
                .sql(")")
                .execute();
    }
}

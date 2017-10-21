package com.example.demo.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.entity.EntityType;

import com.example.demo.entity.Foo;
import com.example.demo.misc.EntityTypes;

@Dao
@ConfigAutowireable
public interface FooDao1 {

    @Insert(sqlFile = true)
    int insertBySqlFile(Foo entity, String tableName);

    default int insertBySqlFile(final Foo entity) {
        final EntityType<?> entityType = EntityTypes.getEntityType(entity);
        return insertBySqlFile(entity, entityType.getTableName());
    }
}

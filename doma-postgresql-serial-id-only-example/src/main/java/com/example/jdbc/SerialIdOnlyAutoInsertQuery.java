package com.example.jdbc;

import org.seasar.doma.internal.jdbc.sql.PreparedSqlBuilder;
import org.seasar.doma.jdbc.Naming;
import org.seasar.doma.jdbc.SqlKind;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.entity.EntityType;
import org.seasar.doma.jdbc.query.AutoInsertQuery;

public class SerialIdOnlyAutoInsertQuery<ENTITY> extends AutoInsertQuery<ENTITY> {

    public SerialIdOnlyAutoInsertQuery(final EntityType<ENTITY> entityType) {
        super(entityType);
    }

    @Override
    protected void prepareSql() {

        if (targetPropertyTypes.isEmpty() == false) {
            super.prepareSql();
            return;
        }

        final Naming naming = config.getNaming();
        final Dialect dialect = config.getDialect();
        final PreparedSqlBuilder builder = new PreparedSqlBuilder(config, SqlKind.INSERT,
                sqlLogType);
        builder.appendSql("insert into ");
        builder.appendSql(entityType.getQualifiedTableName(naming::apply, dialect::applyQuote));
        builder.appendSql(" default values");
        sql = builder.build(this::comment);
    }
}

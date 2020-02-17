package com.example;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;

@Dao
@ConfigAutowireable
public interface SerialIdOnlyDao {

    @Select
    SerialIdOnly insertBySqlFile();

    @Insert
    Result<SerialIdOnly> insert(SerialIdOnly entity);

    @Insert
    Result<SerialIdAndVal> insert(SerialIdAndVal entity);
}

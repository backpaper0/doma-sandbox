package com.example.demo.two_in_example;

import java.util.List;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface TwoInExampleDao {

    @Select
    List<TwoInExample> select(Iterable<TwoInExample> condition);
}

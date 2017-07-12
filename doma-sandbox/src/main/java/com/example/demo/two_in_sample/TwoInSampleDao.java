package com.example.demo.two_in_sample;

import java.util.List;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface TwoInSampleDao {

    @Select
    List<TwoInSample> select(Iterable<TwoInSample> condition);
}

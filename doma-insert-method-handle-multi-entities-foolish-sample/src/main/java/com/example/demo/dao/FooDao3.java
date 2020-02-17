package com.example.demo.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.boot.ConfigAutowireable;

import com.example.demo.entity.Foo;
import com.example.demo.misc.Foolish;

@Dao
@ConfigAutowireable
public interface FooDao3 {

    @Insert
    @Foolish
    int insert(Foo entity);
}

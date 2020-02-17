package com.example;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EntityListenerExampleTest {

    @Autowired
    private HogeDao dao;

    @Test
    public void test() throws Exception {
        final Hoge entity = new Hoge();
        entity.bar = "hello world";

        assertThat(entity.foo, is(nullValue()));
        assertThat(entity.bar, is("hello world"));
        assertThat(entity.baz, is(nullValue()));

        dao.insert(entity);

        final List<Hoge> entities = dao.selectAll();

        assertThat(entities.size(), is(1));

        assertThat(entities.get(0).foo, is(notNullValue()));
        assertThat(entities.get(0).bar, is("hello world"));
        assertThat(entities.get(0).baz, is(notNullValue()));
    }
}

package com.example;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntityListenerSampleTest {

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

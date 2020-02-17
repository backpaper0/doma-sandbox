package com.example.demo.two_in_example;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TwoInExampleTest {

    @Autowired
    private TwoInExampleDao dao;

    @Test
    void test() throws Exception {
        final List<TwoInExample> condition = new ArrayList<>();

        final TwoInExample a = new TwoInExample();
        a.foo = "bbb";
        a.bar = "ccc";
        condition.add(a);

        final TwoInExample b = new TwoInExample();
        b.foo = "ccc";
        b.bar = "ddd";
        condition.add(b);

        final List<TwoInExample> entities = dao.select(condition);

        assertThat(entities.size(), is(2));

        assertThat(entities.get(0).foo, is(a.foo));
        assertThat(entities.get(0).bar, is(a.bar));

        assertThat(entities.get(1).foo, is(b.foo));
        assertThat(entities.get(1).bar, is(b.bar));
    }
}

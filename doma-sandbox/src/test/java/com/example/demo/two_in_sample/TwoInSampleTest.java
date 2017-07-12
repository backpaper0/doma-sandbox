package com.example.demo.two_in_sample;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TwoInSampleTest {

    @Autowired
    private TwoInSampleDao dao;

    @Test
    public void test() throws Exception {
        final List<TwoInSample> condition = new ArrayList<>();

        final TwoInSample a = new TwoInSample();
        a.foo = "bbb";
        a.bar = "ccc";
        condition.add(a);

        final TwoInSample b = new TwoInSample();
        b.foo = "ccc";
        b.bar = "ddd";
        condition.add(b);

        final List<TwoInSample> entities = dao.select(condition);

        assertThat(entities.size(), is(2));

        assertThat(entities.get(0).foo, is(a.foo));
        assertThat(entities.get(0).bar, is(a.bar));

        assertThat(entities.get(1).foo, is(b.foo));
        assertThat(entities.get(1).bar, is(b.bar));
    }
}

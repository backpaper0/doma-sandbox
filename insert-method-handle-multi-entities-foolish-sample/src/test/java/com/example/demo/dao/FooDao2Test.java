package com.example.demo.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Bar;
import com.example.demo.entity.Baz;
import com.example.demo.entity.Foo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FooDao2Test {

    @Autowired
    private FooDao2 dao;

    @Test
    public void test() throws Exception {

        final Foo foo = new Foo();
        foo.val = "FOO";
        dao.insertByBuilder(foo);

        final Bar bar = new Bar();
        bar.val = "BAR";
        dao.insertByBuilder(bar);

        final Baz baz = new Baz();
        baz.val = "BAZ";
        baz.num = 123456789; //numを保存出来ない！！！
        dao.insertByBuilder(baz);
    }
}

package com.example.demo.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Bar;
import com.example.demo.entity.Baz;
import com.example.demo.entity.Foo;

@SpringBootTest
class FooDao1Test {

    @Autowired
    private FooDao1 dao;

    @Test
    void test() throws Exception {

        final Foo foo = new Foo();
        foo.val = "FOO";
        dao.insertBySqlFile(foo);

        final Bar bar = new Bar();
        bar.val = "BAR";
        dao.insertBySqlFile(bar);

        final Baz baz = new Baz();
        baz.val = "BAZ";
        baz.num = 123456789; //numを保存出来ない！！！
        dao.insertBySqlFile(baz);
    }
}

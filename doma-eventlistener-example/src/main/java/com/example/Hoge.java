package com.example;

import java.time.LocalDateTime;

import org.seasar.doma.Entity;

@Entity(listener = HogeListener.class)
public class Hoge {
    public Long foo;
    public String bar;
    public LocalDateTime baz;
}

package com.example.demo.two_in_example;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;

@Entity
public class TwoInExample {
    @Id
    public Long id;
    public String foo;
    public String bar;
}

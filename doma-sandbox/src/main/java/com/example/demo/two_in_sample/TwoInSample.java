package com.example.demo.two_in_sample;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;

@Entity
public class TwoInSample {
    @Id
    public Long id;
    public String foo;
    public String bar;
}

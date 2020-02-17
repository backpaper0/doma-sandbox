package com.example;

import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;

@Entity(immutable = true)
public final class SerialIdAndVal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    private final int val;

    public SerialIdAndVal(final Long id, final int val) {
        this.id = id;
        this.val = val;
    }

    @Override
    public String toString() {
        return String.format("%s(id = %s, val = %s)", getClass().getSimpleName(), id, val);
    }
}

package com.example;

import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;

@Entity(immutable = true)
public final class SerialIdOnly {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;

    public SerialIdOnly(final Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%s(id = %s)", getClass().getSimpleName(), id);
    }
}

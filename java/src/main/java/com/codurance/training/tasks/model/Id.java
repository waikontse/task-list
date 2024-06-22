package com.codurance.training.tasks.model;

import java.util.Objects;

public record Id(String value) {
    public  Id {
        Objects.requireNonNull(value);

        if (value.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be empty");
        }

        if (value.contains(" ")) {
            throw new IllegalArgumentException("Value cannot contain spaces");
        }

        if (!value.matches("\\p{ASCII}*")) {
            throw new IllegalArgumentException("Value contains invalid characters");
        }
    }
}

package com.codurance.training.tasks.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdTest {

    @Test
    void containsSpaces() {
        // GIVEN
        // WHEN
        var exception = assertThrows(IllegalArgumentException.class, () -> new Id("abd skjwe lje"));

        // THEN
        assertTrue(exception.getMessage().contains("Value cannot contain spaces"));
    }
}
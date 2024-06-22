package com.codurance.training.tasks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.IOException;

public class CheckCommandTest extends AbstractApplicationTest {

    public CheckCommandTest() throws IOException {
    }

    @Test
    @Timeout(1)
    void checkUnknownTask_returnsErrorMessage() throws IOException {
        // GIVEN
        var unknownIdTask = 45;

        // WHEN
        execute(STR."check \{unknownIdTask}");

        // THEN
        readLines(STR."Could not find a task with an ID of \{unknownIdTask}.");

        execute("quit");
    }
}

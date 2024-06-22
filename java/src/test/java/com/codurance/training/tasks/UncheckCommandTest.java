package com.codurance.training.tasks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.IOException;

class UncheckCommandTest extends AbstractApplicationTest {

    public UncheckCommandTest() throws IOException {
    }

    @Test
    @Timeout(value = 10)
    void uncheckCommand_shouldUncheck_checkedTask() throws IOException {
        // GIVEN
        execute("show");

        execute("add project secrets");
        execute("add task secrets Eat more donuts.");
        execute("add task secrets Destroy all humans.");

        execute("show");
        readLines(
                "secrets",
                "    [ ] 1: Eat more donuts. ",
                "    [ ] 2: Destroy all humans. ",
                ""
        );

        execute("check 1");
        execute("show");
        readLines(
                "secrets",
                "    [x] 1: Eat more donuts. ",
                "    [ ] 2: Destroy all humans. ",
                ""
        );

        // WHEN
        execute("uncheck 1");

        // THEN
        execute("show");
        readLines(
                "secrets",
                "    [ ] 1: Eat more donuts. ",
                "    [ ] 2: Destroy all humans. ",
                ""
        );

        execute("quit");
    }
}

package com.codurance.training.tasks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

final class ApplicationTest extends AbstractApplicationTest {


    public ApplicationTest() throws IOException {
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.SECONDS)
    void it_works() throws IOException {
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

        execute("add project training");
        execute("add task training Four Elements of Simple Design");
        execute("add task training SOLID");
        execute("add task training Coupling and Cohesion");
        execute("add task training Primitive Obsession");
        execute("add task training Outside-In TDD");
        execute("add task training Interaction-Driven Design");

        execute("check 1");
        execute("check 3");
        execute("check 5");
        execute("check 6");

        execute("show");
        readLines(
                "secrets",
                "    [x] 1: Eat more donuts. ",
                "    [ ] 2: Destroy all humans. ",
                "",
                "training",
                "    [x] 3: Four Elements of Simple Design ",
                "    [ ] 4: SOLID ",
                "    [x] 5: Coupling and Cohesion ",
                "    [x] 6: Primitive Obsession ",
                "    [ ] 7: Outside-In TDD ",
                "    [ ] 8: Interaction-Driven Design ",
                ""
        );

        execute("quit");
    }
}

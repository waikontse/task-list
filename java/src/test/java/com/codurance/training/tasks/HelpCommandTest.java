package com.codurance.training.tasks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

class HelpCommandTest extends AbstractApplicationTest {

    public HelpCommandTest() throws IOException {
    }

    @Test
    @Timeout(value = 2)
    void helpCommand() throws IOException {
        execute("help");

        readLines("Commands:",
                  "  show",
                  "  add project <project name>",
                  "  add task <project name> <task description>",
                  "  check <task ID>",
                  "  uncheck <task ID>",
                  ""
                  );

        execute("quit");
    }
}

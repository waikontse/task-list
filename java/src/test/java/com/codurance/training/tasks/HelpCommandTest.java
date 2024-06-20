package com.codurance.training.tasks;

import org.junit.Test;

import java.io.IOException;

public class HelpCommandTest extends AbstractApplicationTest {

    public HelpCommandTest() throws IOException {
    }

    @Test(timeout = 5_000L)
    public void helpCommand() throws IOException {
        execute("help");

        readLines("""
                          Commands:
                            show
                            add project <project name>
                            add task <project name> <task description>
                            check <task ID>
                            uncheck <task ID>
                          """);

        execute("quit");
    }
}

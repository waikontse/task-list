package com.codurance.training.tasks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DefaultCommandTest extends AbstractApplicationTest {

    public DefaultCommandTest() throws IOException {
    }

    @Test
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    void randomUnknownCommand() throws Exception {
        String randomCommand = "random_unknown_command";
        execute(randomCommand);

        readLines(STR."I don't know what the command \"\{randomCommand}\" is.");

        execute("quit");
    }


}

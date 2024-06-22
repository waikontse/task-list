package com.codurance.training.tasks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.File;
import java.io.IOException;

public class AddCommandTest extends AbstractApplicationTest {

    public AddCommandTest() throws IOException {
    }

    @Test
    @Timeout(1)
    void addTaskToUnknownProject_shouldThrowException() throws IOException {
        // GIVEN
        // WHEN
        var projectName = "randomProject";
        execute(STR."add task \{projectName} hellWorld");

        // THEN
        readLines(STR."Could not find a project with the name \"\{projectName}\".".replace(File.separator, ""));


        execute("quit");
    }

    @Test
    @Timeout(1)
    void addRandomSubcommand_shouldThrowException() throws IOException {
        // GIVEN
        // WHEN
        var subCommand = "randomSubcommand";
        execute(STR."add \{subCommand} hellWorld");

        // THEN
        //readLines("");

        execute("quit");
    }
}

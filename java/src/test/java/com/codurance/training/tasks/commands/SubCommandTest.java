package com.codurance.training.tasks.commands;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SubCommandTest {
    @Test
    void parseAddCommand() {
        // GIVEN

        // WHEN
        SubCommand command = SubCommand.parse("add project secrets");

        // THEN
        assertThat(command.subCommand()).isEqualTo("project");
        assertThat(command.subCommandRest()[1]).isEqualTo("secrets");
    }
}
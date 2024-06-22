package com.codurance.training.tasks.commands;

import com.codurance.training.tasks.TaskList;

public record Quit(String lowerCasedCommandString) implements Command {

    @Override
    public void run(TaskList taskList) {
    }
}

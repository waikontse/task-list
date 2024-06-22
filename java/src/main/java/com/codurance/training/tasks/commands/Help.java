package com.codurance.training.tasks.commands;

import com.codurance.training.tasks.TaskList;
import com.codurance.training.tasks.io.InOutIo;

public record Help(String lowerCasedCommandString, InOutIo inOutIo) implements Command {
    @Override
    public void run(TaskList taskList) {
        inOutIo.out().println("Commands:");
        inOutIo.out().println("  show");
        inOutIo.out().println("  add project <project name>");
        inOutIo.out().println("  add task <project name> <task description>");
        inOutIo.out().println("  check <task ID>");
        inOutIo.out().println("  uncheck <task ID>");
        inOutIo.out().println();
    }

}

package com.codurance.training.tasks.commands;

import com.codurance.training.tasks.TaskList;
import com.codurance.training.tasks.io.InOutIo;

public record Unknown(String commandString, InOutIo inOutIo) implements Command {
    @Override
    public void run(TaskList taskList) {
        inOutIo.out().printf("I don't know what the command \"%s\" is.", commandString);
        inOutIo.out().println();
    }
}

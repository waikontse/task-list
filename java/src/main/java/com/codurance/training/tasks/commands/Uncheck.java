package com.codurance.training.tasks.commands;

import com.codurance.training.tasks.TaskList;
import com.codurance.training.tasks.model.Id;

public record Uncheck(String lowerCasedCommandString) implements Command {

    @Override
    public void run(TaskList taskList) {
        SubCommand subCommand = SubCommand.parse(lowerCasedCommandString);

        taskList.setDone(new Id(subCommand.subCommand()), false);
    }
}

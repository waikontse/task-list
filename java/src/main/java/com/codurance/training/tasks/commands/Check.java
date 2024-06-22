package com.codurance.training.tasks.commands;

import com.codurance.training.tasks.TaskList;
import com.codurance.training.tasks.model.Id;

public record Check(String lowerCommandStirng) implements Command {
    @Override
    public void run(TaskList taskList) {
        SubCommand subCommand = SubCommand.parse(lowerCommandStirng);

        taskList.setDone(new Id(subCommand.subCommand()), true);
    }
}

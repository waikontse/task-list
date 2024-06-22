package com.codurance.training.tasks.commands;

import com.codurance.training.tasks.TaskList;

public record Check(String lowerCommandStirng) implements Command {
    @Override
    public void run(TaskList taskList) {
        SubCommand subCommand = SubCommand.parse(lowerCommandStirng);

        taskList.setDone(subCommand.subCommand(), true);
    }
}

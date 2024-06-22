package com.codurance.training.tasks.commands;

import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.TaskList;
import com.codurance.training.tasks.model.Id;

import java.util.List;
import java.util.Map;

public record Delete(String command) implements Command {

    @Override
    public void run(TaskList taskList) {
        SubCommand command = SubCommand.parse(command());

        var foundTask = taskList.getTask(new Id(command.subCommand()));

        if (foundTask.isPresent()) {
            for(Map.Entry<String, List<Task>> entry : taskList.tasks().entrySet()) {
                entry.getValue().remove(foundTask.get());
            }
        }
    }
}

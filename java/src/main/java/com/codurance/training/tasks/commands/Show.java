package com.codurance.training.tasks.commands;

import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.TaskList;
import com.codurance.training.tasks.io.InOutIo;

import java.util.List;
import java.util.Map;

public record Show(String lowerCasedCommandString, InOutIo inOutIo) implements Command {
    @Override
    public void run(TaskList taskList) {
        for (Map.Entry<String, List<Task>> project : taskList.tasks().entrySet()) {
            inOutIo.out().println(project.getKey());
            for (Task task : project.getValue()) {
                inOutIo.out().printf("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
            }
            inOutIo.out().println();
        }
    }
}

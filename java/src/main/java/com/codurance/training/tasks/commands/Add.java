package com.codurance.training.tasks.commands;

import com.codurance.training.tasks.io.InOutIo;
import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.TaskList;

import java.util.ArrayList;
import java.util.List;

public record Add(String lowercasedCommandString, InOutIo inOutIo) implements Command {

    @Override
    public void run(TaskList taskList) {
        SubCommand subCommand = SubCommand.parse(lowercasedCommandString);

        if (subCommand.subCommand().equals("project")) {
            addProject(taskList, subCommand.subCommandRest()[1]);
        } else if (subCommand.subCommand().equals("task")) {
            String[] projectTask = subCommand.subCommandRest()[1].split(" ", 2);
            addTask(taskList, projectTask[0], projectTask[1]);
        }
    }

    private void addProject(TaskList tasks, String name) {
        tasks.tasks().put(name, new ArrayList<>());
    }

    private void addTask(TaskList tasks, String project, String description) {
        List<Task> projectTasks = tasks.tasks().get(project);
        if (projectTasks == null) {
            inOutIo.out().printf("Could not find a project with the name \"%s\".", project);
            inOutIo.out().println();
            return;
        }
        projectTasks.add(new Task(tasks.nextId(), description, false));
    }
}

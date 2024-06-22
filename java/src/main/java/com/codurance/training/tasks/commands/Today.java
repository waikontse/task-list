package com.codurance.training.tasks.commands;

import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.TaskList;
import com.codurance.training.tasks.io.InOutIo;

import java.time.LocalDate;
import java.util.Collection;

public record Today(String command, InOutIo inOutIo) implements Command {

    @Override
    public void run(TaskList taskList) {
        LocalDate today = LocalDate.now();

        taskList.tasks().values().stream().flatMap(Collection::stream)
                .filter(task -> task.getDeadline().equals(today))
                .toList()
                .forEach(task -> inOutIo.out().println(taskList));
    }
}

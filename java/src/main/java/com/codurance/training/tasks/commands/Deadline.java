package com.codurance.training.tasks.commands;

import com.codurance.training.tasks.TaskList;
import com.codurance.training.tasks.io.InOutIo;
import com.codurance.training.tasks.model.Id;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public record Deadline(String commandString, InOutIo inOutIo) implements Command {

    @Override
    public void run(TaskList taskList) {
        SubCommand command = SubCommand.parse(commandString);

        // Parse the date
        var rawDateString = command.subCommandRest()[1];
        try {
            LocalDate parsedLocalDate = LocalDate.parse(rawDateString);

            var foundTask = taskList.getTask(new Id(command.subCommand()));
            foundTask.ifPresent(task -> task.setDeadline(parsedLocalDate));
        } catch (DateTimeParseException e) {
            inOutIo.out().println(STR."Could not add deadline: \{rawDateString} to task \{command.subCommand()}.");
        }
    }
}

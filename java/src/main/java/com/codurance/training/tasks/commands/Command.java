package com.codurance.training.tasks.commands;

import com.codurance.training.tasks.TaskList;
import com.codurance.training.tasks.io.InOutIo;

public sealed interface Command permits Add, Check, Deadline, Delete, Help, Quit, Show, Today, Uncheck, Unknown {
    static Command getCommand(String commandString, InOutIo inOutIo) {
        if(commandString.startsWith("add")) {
            return new Add(commandString, inOutIo);
        } else if (commandString.startsWith("check")) {
            return new Check(commandString);
        } else if (commandString.startsWith("uncheck")) {
            return new Uncheck(commandString);
        } else if (commandString.startsWith("help")) {
            return new Help(commandString, inOutIo);
        } else if (commandString.startsWith("show")) {
            return new Show(commandString, inOutIo);
        } else if (commandString.startsWith("quit")) {
            return new Quit(commandString);
        } else if (commandString.startsWith("deadline")) {
            return new Deadline(commandString, inOutIo);
        } else if (commandString.startsWith("delete")) {
            return new Delete(commandString);
        }

        return new Unknown(commandString, inOutIo);
    }

    void run(TaskList taskList);
}

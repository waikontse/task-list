package com.codurance.training.tasks.commands;

import com.codurance.training.tasks.TaskList;
import com.codurance.training.tasks.io.InOutIo;

public sealed interface Command permits Add, Check, Uncheck, Help, Show, Quit, Unknown {
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
        } else {
            return new Unknown(commandString, inOutIo);
        }
    }

    void run(TaskList taskList);
}

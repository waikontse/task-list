package com.codurance.training.tasks;

import com.codurance.training.tasks.commands.Command;
import com.codurance.training.tasks.commands.Quit;
import com.codurance.training.tasks.io.InOutIo;

import java.io.IOException;

public class TaskListApplication {
    private TaskListApplication() {

    }

    private static HashMapTaskList taskList;

    public static void run(InOutIo inOutIo) {
        taskList = new HashMapTaskList(inOutIo);

        while (true) {
            inOutIo.out().print("> ");
            inOutIo.out().flush();
            Command command;
            try {
                command = Command.getCommand(inOutIo.in().readLine(), inOutIo);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if (command instanceof Quit) {
                command.run(taskList);
                break;
            }

            execute(command);
        }
    }

    private static void execute(Command command) {
        command.run(taskList);
    }
}

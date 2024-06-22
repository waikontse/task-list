package com.codurance.training.tasks.commands;

public record SubCommand(String subCommand, String[] subCommandRest) {
    public static SubCommand parse(String commandString) {
        String[] commandRest = commandString.substring(commandString.indexOf(" ")+1)
                                            .split(" ", 2);
        String command = commandRest[0];

        return new SubCommand(command, commandRest);
    }
}

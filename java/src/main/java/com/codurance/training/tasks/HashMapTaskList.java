package com.codurance.training.tasks;

import com.codurance.training.tasks.io.InOutIo;
import com.codurance.training.tasks.model.Id;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public final class HashMapTaskList implements TaskList {
    private final Map<String, List<Task>> tasks = new LinkedHashMap<>();
    private final InOutIo inOutIo;

    public HashMapTaskList(InOutIo inOutIo) {
        this.inOutIo = inOutIo;
    }

    @Override
    public void setDone(Id idString, boolean done) {
        var taskFound = getTask(idString);

        taskFound.ifPresent(task -> task.setDone(done));
    }

    public Id nextId() {
        return new Id(UUID.randomUUID().toString());
    }

    @Override
    public Map<String, List<Task>> tasks() {
        return tasks;
    }

    @Override
    public Optional<Task> getTask(Id id) {

        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId().equals(id)) {
                    return Optional.of(task);
                }
            }
        }

        inOutIo.out().printf("Could not find a task with an ID of %s.", id.value());
        inOutIo.out().println();

        return Optional.empty();
    }
}

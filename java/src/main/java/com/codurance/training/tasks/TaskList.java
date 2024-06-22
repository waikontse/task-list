package com.codurance.training.tasks;

import com.codurance.training.tasks.model.Id;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface TaskList {
    void setDone(Id id, boolean done);

    Id nextId();

    Map<String, List<Task>> tasks();

    Optional<Task> getTask(Id id);
}

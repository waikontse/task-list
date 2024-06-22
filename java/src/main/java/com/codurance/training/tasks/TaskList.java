package com.codurance.training.tasks;

import java.util.List;
import java.util.Map;

public interface TaskList {
    void setDone(String idString, boolean done);
    long nextId();

    Map<String, List<Task>> tasks();
}

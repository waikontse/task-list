package com.codurance.training.tasks;

import com.codurance.training.tasks.io.InOutIo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class HashMapTaskList implements TaskList {
    private final Map<String, List<Task>> tasks = new LinkedHashMap<>();

    private long lastId = 0;
    private final InOutIo inOutIo;

    public HashMapTaskList(InOutIo inOutIo) {
        this.inOutIo = inOutIo;
    }

    public void setDone(String idString, boolean done) {
        int id = Integer.parseInt(idString);
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId() == id) {
                    task.setDone(done);
                    return;
                }
            }
        }

        inOutIo.out().printf("Could not find a task with an ID of %d.", id);
        inOutIo.out().println();
    }

    public long nextId() {
        return ++lastId;
    }

    @Override
    public Map<String, List<Task>> tasks() {
        return tasks;
    }
}

package com.codurance.training.tasks;

import com.codurance.training.tasks.model.Id;

import java.time.LocalDate;

public final class Task {

    private final Id id;

    private final String description;

    private boolean done;

    private LocalDate deadline;

    public Task(Id id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }

    public Id getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        return String.format("[%c] %s: %s %s%n", (isDone() ? 'x' : ' '), getId().value(), getDescription(),
                             (getDeadline() == null ? "" : getDeadline()));
    }
}

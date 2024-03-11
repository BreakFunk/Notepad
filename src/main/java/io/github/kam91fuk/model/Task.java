package io.github.kam91fuk.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task implements Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Task's description must not be empty")
    private String description;
    private boolean done;
    private LocalDateTime deadline;
    private LocalDateTime deadLines;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    public Task() {
    }
    public int getId() {
        return id;
    }
    void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isDone() {
        return done;
    }
    public void setDone(boolean done) {
        this.done = done;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public LocalDateTime getDeadLines() {
        return deadLines;
    }
    void setDeadLines(LocalDateTime deadLines) {
        this.deadLines = deadLines;
    }

    public void updateFrom(final Task source) {
        description = source.description;
        done = source.done;
        deadline = source.deadline;
    }

    @Override
    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    @Override
    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }
}
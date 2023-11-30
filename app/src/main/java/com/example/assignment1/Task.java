package com.example.assignment1;

import androidx.annotation.NonNull;

public class Task {
    private String status;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    private String taskName;
    public static final Task[] tasks = {
            new Task("All Tasks"),
            new Task("Due Tasks"),
            new Task("Done Tasks")};
    public Task(String taskName,String status ) {
        this.status = status;
        this.taskName = taskName;
    }



    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @NonNull


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTaskName() {
        return taskName;
    }
    @Override
    public String toString() {
        return taskName;
    }
}

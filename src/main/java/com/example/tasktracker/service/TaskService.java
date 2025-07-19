
package com.example.tasktracker.service;

import com.example.tasktracker.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    private List<Task> tasks = new ArrayList<>();

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task createTask(Task task) {
        tasks.add(task);
        return task;
    }

    public Task updateTask(int id, Task updatedTask) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setName(updatedTask.getName());
                task.setDescription(updatedTask.getDescription());
                task.setStatus(updatedTask.getStatus());
                return task;
            }
        }
        return null;
    }

    public boolean deleteTask(int id) {
        return tasks.removeIf(task -> task.getId() == id);
    }
}
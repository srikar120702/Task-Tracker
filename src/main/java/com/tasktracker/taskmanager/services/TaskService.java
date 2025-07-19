package com.tasktracker.taskmanager.services;

import com.tasktracker.taskmanager.model.Task;
import com.tasktracker.taskmanager.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public Optional<Task> findById(String id) {
        return taskRepository.findById(id);
    }

    public boolean deleteTask(String id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true; // deletion successful
        }
        return false; // entity not found
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task updateTask(String id, Task updatedTask) {
        Optional<Task> optionalTask = taskRepository.findById(id);

        if (optionalTask.isPresent()) {
            Task existingTask = optionalTask.get();
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setStatus(updatedTask.getStatus());
            return taskRepository.save(existingTask);
        }
        return null; // or throw a custom exception
    }


    public Task  save(Task task) {
        return taskRepository.save(task);
    }
}

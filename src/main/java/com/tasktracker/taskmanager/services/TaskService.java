package com.tasktracker.taskmanager.services;

import com.tasktracker.taskmanager.model.Task;
import com.tasktracker.taskmanager.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final SequenceGeneratorService sequenceGenerator;

    public TaskService(TaskRepository taskRepository, SequenceGeneratorService sequenceGenerator) {
        this.taskRepository = taskRepository;
        this.sequenceGenerator = sequenceGenerator;
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
            existingTask.setDeadline(updatedTask.getDeadline());
            return taskRepository.save(existingTask);
        }
        return null; // or throw a custom exception
    }


    public Task  save(Task task) {
        if (task.getId() == null) {
            long sequence = sequenceGenerator.generateSequence(Task.SEQUENCE_NAME);
            task.setId("trk" + String.format("%06d", sequence));
            task.setAssignedDate(LocalDateTime.now());
        }
        return taskRepository.save(task);
    }
}

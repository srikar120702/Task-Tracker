package com.tasktracker.taskmanager.repositories;

import com.tasktracker.taskmanager.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
}

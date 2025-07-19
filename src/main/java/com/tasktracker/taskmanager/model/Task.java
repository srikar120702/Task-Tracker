package com.tasktracker.taskmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

import java.security.SecureRandom;
import java.util.Random;

@Entity
public class Task {

    @Id
    private String id;

    private String title;
    private String description;
    private String status;

    // ID generation logic
    private static final String PREFIX = "trk";
    private static final String CHAR_POOL = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static final int LENGTH = 6;

    private String generateRandomAlphaNumeric() {
        StringBuilder sb = new StringBuilder();
        Random random = new SecureRandom();
        for (int i = 0; i < LENGTH; i++) {
            int index = random.nextInt(CHAR_POOL.length());
            sb.append(CHAR_POOL.charAt(index));
        }
        return sb.toString();
    }

    @PrePersist
    public void assignId() {
        if (this.id == null) {
            this.id = PREFIX + generateRandomAlphaNumeric();
        }
    }

    // Getters and setters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
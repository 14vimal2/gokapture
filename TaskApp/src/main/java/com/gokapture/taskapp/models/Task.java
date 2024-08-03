package com.gokapture.taskapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Task extends BaseModel {
    private String title;
    private String description;

    private TaskPriority priority;
    private TaskStatus status;

    private Date dueDate;

    @ManyToOne
    private User user;
}

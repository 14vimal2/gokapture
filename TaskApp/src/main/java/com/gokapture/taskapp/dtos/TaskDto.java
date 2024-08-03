package com.gokapture.taskapp.dtos;
import com.gokapture.taskapp.models.TaskPriority;
import com.gokapture.taskapp.models.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TaskDto {
    private String title;
    private String description;

    private TaskPriority priority;
    private TaskStatus status;

    private Date dueDate;
}

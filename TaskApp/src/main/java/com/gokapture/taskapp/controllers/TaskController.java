package com.gokapture.taskapp.controllers;


import com.gokapture.taskapp.dtos.TaskDto;
import com.gokapture.taskapp.models.Task;
import com.gokapture.taskapp.models.TaskPriority;
import com.gokapture.taskapp.models.TaskStatus;
import com.gokapture.taskapp.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskDto taskDto) {
        if (taskDto == null) {
            throw new IllegalArgumentException("taskDto cannot be null");
        }
        if(taskDto.getTitle() == null || taskDto.getTitle().isEmpty()) {
            throw new IllegalArgumentException("taskDto.title cannot be null or empty");
        }
        return taskService.create(taskDto);
    }

    @GetMapping
    public List<Task> getAllTasks(@RequestParam(required = false) TaskStatus status, @RequestParam(required = false) TaskPriority priority) {


        String currUsername = SecurityContextHolder.getContext().getAuthentication().getName();


        List<Task> tasks = taskService.findAllByUsername(currUsername);
        if (status != null) {
            tasks = tasks.stream()
                    .filter(task -> task.getStatus().equals(status)).toList();
        }
        if (priority != null) {
            tasks = tasks.stream()
                    .filter(task -> task.getPriority().equals(priority)).toList();
        }
        return tasks;
    }

    @PutMapping("/{taskId}")
    public Task updateTask(@PathVariable Long taskId, @RequestBody TaskDto taskDto) {
        if (taskDto == null) {
            throw new IllegalArgumentException("taskDto cannot be null");
        }
        if(taskDto.getTitle() == null || taskDto.getTitle().isEmpty()) {
            throw new IllegalArgumentException("taskDto.title cannot be null or empty");
        }
        return taskService.update(taskId, taskDto);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.delete(taskId);
    }


}

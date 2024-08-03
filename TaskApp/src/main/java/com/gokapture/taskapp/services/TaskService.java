package com.gokapture.taskapp.services;

import com.gokapture.taskapp.dtos.TaskDto;
import com.gokapture.taskapp.models.Task;
import com.gokapture.taskapp.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TaskService {

    Task create(TaskDto taskDto);

    Task findById(Long id);

    List<Task> findAllByUsername(String username);

    Task save(Task task);

    Task update(Long id, TaskDto taskDto);

    void delete(Long id);


}

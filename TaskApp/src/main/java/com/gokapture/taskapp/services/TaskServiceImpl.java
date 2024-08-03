package com.gokapture.taskapp.services;

import com.gokapture.taskapp.dtos.TaskDto;
import com.gokapture.taskapp.exceptions.UserNotFoundException;
import com.gokapture.taskapp.models.Task;
import com.gokapture.taskapp.models.User;
import com.gokapture.taskapp.repositories.TaskRepository;
import com.gokapture.taskapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;
    private UserRepository userRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Task create(TaskDto taskDto) {
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setDueDate(taskDto.getDueDate());
        task.setPriority(taskDto.getPriority());
        task.setStatus(taskDto.getStatus());

        String currUsername = SecurityContextHolder.getContext().getAuthentication().getName();

        Optional<User> user = userRepository.findByUsername(currUsername);

        if (user.isPresent()) {
            task.setUser(user.get());
        } else {
            throw new UserNotFoundException("User not found");
        }

        return taskRepository.save(task);
    }

    @Override
    public Task findById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            return task.get();
        }
        throw new IllegalArgumentException("Task not found");
    }

    @Override
    public List<Task> findAllByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isPresent()) {
            List<Task> tasks = taskRepository.findAllByUser(user.get());
        }
        throw new UserNotFoundException("User not found");
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task update(Long id, TaskDto taskDto) {
        Optional<Task> taskOptional = taskRepository.findById(id);

        if (taskOptional.isEmpty()) {
            throw new IllegalArgumentException("Task not found");
        }
        String currUsername = SecurityContextHolder.getContext().getAuthentication().getName();

        Optional<User> user = userRepository.findByUsername(currUsername);

        if(user.isEmpty() || !user.get().getUsername().equals(currUsername)) {
            throw new UserNotFoundException("User not found");
        }

        Task task = taskOptional.get();

        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setDueDate(taskDto.getDueDate());
        task.setPriority(taskDto.getPriority());
        task.setStatus(taskDto.getStatus());
        return taskRepository.save(task);
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}

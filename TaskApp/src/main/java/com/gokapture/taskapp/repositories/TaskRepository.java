package com.gokapture.taskapp.repositories;

import com.gokapture.taskapp.models.Task;
import com.gokapture.taskapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByUser(User user);

}

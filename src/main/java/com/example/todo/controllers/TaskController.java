package com.example.todo.controllers;

import com.example.todo.entities.Task;
import com.example.todo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/posts")
    public List<Task> tasks(){
        return taskService.getAllTasks();
    }

    @PostMapping("/post")
    public void publishTask(@RequestBody Task task){
        taskService.insert(task);
    }
}

package com.example.controller;

import com.example.dto.TaskDto;
import com.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/")
    public ResponseEntity<String>createTask( @RequestBody TaskDto taskDto)
    {
        String task = taskService.createTask(taskDto);
        return  ResponseEntity.status(HttpStatus.CREATED).body("Task Created");
    }


    @GetMapping("/all")
    public ResponseEntity<List<TaskDto>>getAllTask(TaskDto taskDto)
    {
        List<TaskDto> allTask = taskService.getAllTask();
        return  new ResponseEntity<>(allTask,HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TaskDto>getTaskById(@PathVariable Integer id)
    {
        TaskDto taskById = taskService.getTaskById(id);
        return new ResponseEntity<>(taskById,HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<TaskDto>updateTask(@PathVariable Integer id,
                                             @RequestBody TaskDto taskDto)
    {
        TaskDto taskDto1 = taskService.updateTask(id, taskDto);
        return new ResponseEntity<>(taskDto1,HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteTask(@PathVariable Integer id)
    {
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

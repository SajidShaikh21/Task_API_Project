package com.example.service;

import com.example.dto.TaskDto;

import java.util.List;

public interface TaskService {


    public String createTask (TaskDto taskDto);

    public List<TaskDto>getAllTask();

    public TaskDto getTaskById( Integer id);

    public TaskDto updateTask(Integer id,TaskDto taskDto);

    public void deleteTask(Integer id);

}

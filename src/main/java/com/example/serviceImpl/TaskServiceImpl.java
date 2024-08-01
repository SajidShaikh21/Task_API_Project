package com.example.serviceImpl;

import com.example.dto.TaskDto;
import com.example.entity.Task;
import com.example.exception.TaskNoFoundException;
import com.example.repository.TaskRepo;
import com.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepo taskRepo;


    @Override
    public String createTask(TaskDto taskDto) {
        Task task=new Task(taskDto.getId(), taskDto.getTitle(),taskDto.getDescription(),taskDto.getCompleted());
        Task saved = taskRepo.save(task);
        return "Task Added";
    }

    @Override
    public List<TaskDto> getAllTask() {
      return   taskRepo.findAll().stream().map(task -> new TaskDto(task.getId(), task.getTitle(),task.getDescription(),task.getCompleted()))
                .collect(Collectors.toUnmodifiableList());

    }

    @Override
    public TaskDto getTaskById(Integer id) {
        Task task = taskRepo.findById(id).orElseThrow(() -> new TaskNoFoundException("Task Not found Wit given Id"));
        return new TaskDto(task.getId(), task.getTitle(),task.getDescription(),task.getCompleted());
    }

    @Override
    public TaskDto updateTask(Integer id, TaskDto taskDto) {
        Task task = taskRepo.findById(id).orElseThrow(() -> new TaskNoFoundException("Task Not Found with Given Id"));
       task.setId(taskDto.getId());
       task.setTitle(taskDto.getTitle());
       task.setDescription(taskDto.getDescription());
       task.setCompleted(taskDto.getCompleted());
        Task saved = taskRepo.save(task);
        return new TaskDto(saved.getId(),saved.getTitle(),saved.getDescription(),saved.getCompleted());
    }

    @Override
    public void deleteTask(Integer id) {
       if (!taskRepo.existsById(id))
       {
           throw new RuntimeException("Task Not Found By Id");
       }else {
              taskRepo.deleteById(id);
       }
    }


}

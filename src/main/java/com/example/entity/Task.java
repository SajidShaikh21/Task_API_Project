package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "task")
public class Task {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "task_id")
     private int id;

     @Column(name = "task_title")
    private String title;

    private String description;

    private Boolean completed;


}

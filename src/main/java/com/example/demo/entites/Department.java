package com.example.demo.entites;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "departments")
@Data
public class Department{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "department")
    private List<User> employees;



}

package com.university.academic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String code;

    // 1-1: the department owns this FK (head_id), UNIQUE as on slide 7
    @OneToOne
    @JoinColumn(name = "head_id", unique = true)
    private Lecturer head;

    // 1-N inverse sides: the FK lives in Course and Lecturer
    @OneToMany(mappedBy = "department")
    private List<Course> courses = new ArrayList<>();

    @OneToMany(mappedBy = "department")
    private List<Lecturer> lecturers = new ArrayList<>();
}
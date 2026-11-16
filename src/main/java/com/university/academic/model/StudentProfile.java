package com.university.academic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateOfBirth;
    private String gender;
    private String phone;
    private String address;

    // inverse side of the one-to-one (the FK lives in Student)
    @OneToOne(mappedBy = "profile")
    private Student student;
}
# Entity Relationship Diagram

```mermaid
erDiagram
    DEPARTMENT ||--o{ COURSE : offers
    DEPARTMENT ||--o{ LECTURER : employs
    LECTURER |o--o| DEPARTMENT : heads
    DEPARTMENT ||--o{ STUDENT : admits
    STUDENT ||--|| STUDENT_PROFILE : has
    LECTURER }o--o{ COURSE : teaches
    STUDENT ||--o{ REGISTRATION : makes
    COURSE ||--o{ REGISTRATION : receives

    DEPARTMENT {
        Long id PK
        String name
        String code
        Long head_id FK
    }
    LECTURER {
        Long id PK
        String fullName
        String email
        Long department_id FK
    }
    STUDENT {
        Long id PK
        String fullName
        String email
        String regNumber
        Long department_id FK
        Long profile_id FK
    }
    STUDENT_PROFILE {
        Long id PK
        Date dateOfBirth
        String gender
        String phone
        String address
    }
    COURSE {
        Long id PK
        String code
        String title
        Int credits
        Long department_id FK
    }
    REGISTRATION {
        Long id PK
        Date registrationDate
        String academicYear
        String semester
        String status
        Double grade
        Long student_id FK
        Long course_id FK
    }
```

## Notes
- Lecturer to Course is Many-to-Many, implemented with the join table `lecturer_course` (no box, because it has no entity).
- Registration is the join entity between Student and Course (it carries its own data).
- `head_id` in Department and `profile_id` in Student are UNIQUE foreign keys (one-to-one).
# Entity Relationship Diagram

```mermaid
erDiagram
    DEPARTMENT ||--o{ COURSE : offers
    DEPARTMENT ||--o{ LECTURER : employs
    LECTURER |o--o| DEPARTMENT : "heads"
    DEPARTMENT ||--o{ STUDENT : admits
    STUDENT ||--|| STUDENT_PROFILE : has
    LECTURER }o--o{ COURSE : "teaches (join table)"
    STUDENT ||--o{ REGISTRATION : makes
    COURSE ||--o{ REGISTRATION : receives

    DEPARTMENT {
        Long id PK
        String name
        String code
        Long head_id FK "unique"
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
        Long profile_id FK "unique"
    }
    STUDENT_PROFILE {
        Long id PK
        LocalDate dateOfBirth
        String gender
        String phone
        String address
    }
    COURSE {
        Long id PK
        String code
        String title
        int credits
        Long department_id FK
    }
    REGISTRATION {
        Long id PK
        LocalDate registrationDate
        String academicYear
        String semester
        String status
        Double grade
        Long student_id FK
        Long course_id FK
    }
```

## How to read it
- `||` means exactly one, `o{` means zero or many, `|o` means zero or one.
- Lecturer to Course is Many-to-Many and is implemented with the join table `lecturer_course`. It does not appear as a box because it has no entity.
- Registration is the join entity between Student and Course. It appears as a box because it carries its own data.
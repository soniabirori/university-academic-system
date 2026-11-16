# Problem Analysis

## Entities
| Entity | Why it is an entity |
|---|---|
| Department | Has its own data and owns courses, lecturers and students |
| Lecturer | A person employed by a department who teaches courses |
| Student | A person admitted into a department |
| StudentProfile | Personal details, each belonging to exactly one student |
| Course | Offered by a department, taught by lecturers |
| Registration | Join entity: a student's registration for a course, with its own data |

## Attributes
- Department: id, name, code
- Lecturer: id, fullName, email
- Student: id, fullName, email, regNumber
- StudentProfile: id, dateOfBirth, gender, phone, address
- Course: id, code, title, credits
- Registration: id, registrationDate, academicYear, semester, status, grade

## Relationships and Cardinality
| Relationship | Cardinality | Implementation |
|---|---|---|
| Department - Course | One-to-Many | FK department_id in course |
| Department - Lecturer (employs) | One-to-Many | FK department_id in lecturer |
| Department - Lecturer (head) | One-to-One | FK head_id (unique) in department |
| Department - Student | One-to-Many | FK department_id in student |
| Student - StudentProfile | One-to-One | FK profile_id (unique) in student |
| Lecturer - Course | Many-to-Many | Join table lecturer_course |
| Student - Course | Many-to-Many | Join entity Registration |
| Student - Registration | One-to-Many | FK student_id in registration |
| Course - Registration | One-to-Many | FK course_id in registration |

## Design Decisions
- **Foreign keys:** Department-Course, Department-Lecturer, Department-Student, Student-Registration, Course-Registration, plus the two one-to-one links (head, profile).
- **Join table:** Lecturer-Course, because it only links the two entities and carries no data of its own.
- **Join entity:** Registration, because the link needs date, academic year, semester, status and grade.
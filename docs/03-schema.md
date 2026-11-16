# Relational Database Schema

PK = primary key, FK = foreign key

| Table | Columns |
|---|---|
| **department** | **id (PK)**, name, code, head_id (FK -> lecturer.id, UNIQUE) |
| **lecturer** | **id (PK)**, full_name, email, department_id (FK -> department.id) |
| **student_profile** | **id (PK)**, date_of_birth, gender, phone, address |
| **student** | **id (PK)**, full_name, email, reg_number, department_id (FK -> department.id), profile_id (FK -> student_profile.id, UNIQUE) |
| **course** | **id (PK)**, code, title, credits, department_id (FK -> department.id) |
| **registration** | **id (PK)**, registration_date, academic_year, semester, status, grade, student_id (FK -> student.id), course_id (FK -> course.id) |
| **lecturer_course** (join table) | **lecturer_id (PK, FK -> lecturer.id)**, **course_id (PK, FK -> course.id)** |

## Notes
- `lecturer_course` is the join table for the Lecturer-Course many-to-many. It has two FKs forming a composite primary key.
- `registration` is the join entity for Student-Course, with its own primary key and extra data columns.
- `head_id` and `profile_id` are UNIQUE to enforce the one-to-one relationships.
- `status` holds PENDING, APPROVED or REJECTED.
package ru.example.hogwarts_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.hogwarts_school.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

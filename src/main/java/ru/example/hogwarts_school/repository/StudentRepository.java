package ru.example.hogwarts_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.hogwarts_school.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByAge(int age);
}

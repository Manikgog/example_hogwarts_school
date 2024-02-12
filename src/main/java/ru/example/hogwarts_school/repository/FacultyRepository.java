package ru.example.hogwarts_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.hogwarts_school.model.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}

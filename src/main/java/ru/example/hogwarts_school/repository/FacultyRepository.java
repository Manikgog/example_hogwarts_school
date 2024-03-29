package ru.example.hogwarts_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.hogwarts_school.model.Faculty;
import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    List<Faculty> findByColorIgnoreCase(String color);
    List<Faculty> findByNameIgnoreCase(String name);
}

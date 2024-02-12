package ru.example.hogwarts_school.service;

import org.springframework.stereotype.Service;
import ru.example.hogwarts_school.exception.NotFoundException;
import ru.example.hogwarts_school.model.Faculty;
import ru.example.hogwarts_school.repository.FacultyRepository;
import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;
    public FacultyService(FacultyRepository facultyRepository){
        this.facultyRepository = facultyRepository;
    }
    public Faculty create(Faculty faculty){
        return facultyRepository.save(faculty);
    }
    public Faculty update(long id, Faculty faculty){
        Optional<Faculty> op = facultyRepository.findById(id);
        if (op.isEmpty()) {
            throw new NotFoundException(id);
        }
        faculty.setId(id);
        return facultyRepository.save(faculty);
    }

    public void delete(long id){
        Optional<Faculty> op = facultyRepository.findById(id);
        if (op.isEmpty()) {
            throw new NotFoundException(id);
        }
        facultyRepository.deleteById(id);
    }
    public Faculty get(long id){
        Optional<Faculty> op = facultyRepository.findById(id);
        if (op.isEmpty()) {
            throw new NotFoundException(id);
        }
        return facultyRepository.findById(id).get();
    }

    public List<Faculty> getAll() {
        return facultyRepository.findAll();
    }
    public List<Faculty> findByColor(String color){
        return facultyRepository.findByColor(color);
    }
}

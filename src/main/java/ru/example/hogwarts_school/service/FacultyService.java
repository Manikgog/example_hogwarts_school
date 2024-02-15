package ru.example.hogwarts_school.service;

import org.springframework.stereotype.Service;
import ru.example.hogwarts_school.exception.NotFoundException;
import ru.example.hogwarts_school.model.Faculty;
import ru.example.hogwarts_school.model.Student;
import ru.example.hogwarts_school.repository.FacultyRepository;

import java.util.ArrayList;
import java.util.List;

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
        get(id);
        faculty.setId(id);
        return facultyRepository.save(faculty);
    }

    public Faculty delete(long id){
        Faculty deleted = get(id);
        facultyRepository.deleteById(id);
        return deleted;
    }
    public Faculty get(long id){
        return facultyRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
    public List<Faculty> getAll() {
        return facultyRepository.findAll();
    }
    public List<Faculty> findByColor(String color){
        return facultyRepository.findByColorIgnoreCase(color);
    }
    public List<Faculty> findByName(String name){
        return facultyRepository.findByNameIgnoreCase(name);
    }
    public List<Student> getStudentsOnFaculty(long faculty_id, StudentService studentService){
        List<Student> studentsList = studentService.getAll();
        List<Student> result = new ArrayList<>();
        for(Student item : studentsList){
            if(item.getFaculty().getId() == faculty_id){
                result.add(item);
            }
        }
        return result;
    }
}

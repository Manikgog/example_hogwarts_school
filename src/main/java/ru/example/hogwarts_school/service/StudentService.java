package ru.example.hogwarts_school.service;

import org.springframework.stereotype.Service;
import ru.example.hogwarts_school.exception.NotFoundException;
import ru.example.hogwarts_school.model.Student;
import ru.example.hogwarts_school.repository.StudentRepository;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    public Student create(Student student){
        return studentRepository.save(student);
    }
    public Student update(long id, Student student){
        Optional<Student> op = studentRepository.findById(id);
        if (op.isEmpty()) {
            throw new NotFoundException(id);
        }
        student.setId(id);
        return studentRepository.save(student);
    }

    public void delete(long id){
        Optional<Student> op = studentRepository.findById(id);
        if (op.isEmpty()) {
            throw new NotFoundException(id);
        }
        studentRepository.deleteById(id);
    }
    public Student get(long id){
        Optional<Student> op = studentRepository.findById(id);
        if (op.isEmpty()) {
            throw new NotFoundException(id);
        }
        return studentRepository.findById(id).get();
    }
    public List<Student> getAll(){
        return studentRepository.findAll();
    }

}

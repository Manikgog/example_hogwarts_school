package ru.example.hogwarts_school.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.example.hogwarts_school.exception.NotFoundException;
import ru.example.hogwarts_school.model.Student;
import ru.example.hogwarts_school.repository.StudentRepository;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceMockTest {
    @Mock
    public StudentRepository studentRepository;
    @InjectMocks
    public StudentService studentService;
    @Test
    public void create_Test(){
        Student potter = new Student(0L, "Гарри Поттер", 12);
        Student chang = new Student(0L, "Чжоу Чанг", 13);
        when(studentRepository.save(potter)).thenReturn(potter);

        Student actualResult = studentService.create(potter);
        Assertions.assertEquals(potter, actualResult);

        when(studentRepository.save(chang)).thenReturn(chang);

        actualResult = studentService.create(chang);
        Assertions.assertEquals(chang, actualResult);
    }
    @Test
    public void positive_update_Test(){
        Student potter = new Student(2L, "Гарри Поттер", 12);
        Student chang = new Student(3L, "Чжоу Чанг", 13);
        Optional<Student> op = Optional.of(potter);
        when(studentRepository.save(potter)).thenReturn(potter);
        when(studentRepository.findById(2L)).thenReturn(op);

        Student actual = studentService.update(2, potter);
        Assertions.assertEquals(potter, actual);

        op = Optional.of(chang);
        when(studentRepository.save(chang)).thenReturn(chang);
        when(studentRepository.findById(3L)).thenReturn(op);

        actual = studentService.update(3, chang);
        Assertions.assertEquals(chang, actual);
    }

    @Test
    public void negative_update_Test(){
        Student potter = new Student(2L, "Гарри Поттер", 12);
        Student chang = new Student(3L, "Чжоу Чанг", 13);
        Optional<Student> empty = Optional.empty();
        when(studentRepository.findById(0L)).thenReturn(empty);

        Assertions.assertThrows(NotFoundException.class, ()->studentService.update(0, potter));
        Assertions.assertThrows(NotFoundException.class, ()->studentService.update(-1, chang));
    }

}

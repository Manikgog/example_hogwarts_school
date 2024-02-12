package ru.example.hogwarts_school.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.example.hogwarts_school.model.Student;
import ru.example.hogwarts_school.service.StudentService;

import java.util.List;

@Tag(name = "Студенты", description = "Эндпоинты для работы со студентами")
@RequestMapping("/students")
@RestController
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    @Operation(summary = "Добавление студента")
    public Student create(@RequestBody Student student){
        return studentService.create(student);
    }
    @PutMapping("{id}")
    @Operation(summary = "Изменение студента")
    public Student update(@PathVariable long id, @RequestBody Student student){
        return studentService.update(id, student);
    }
    @DeleteMapping("{id}")  //http://localhost:8080/students/1
    @Operation(summary = "Удаление студента")
    public ResponseEntity<Student> delete(@PathVariable long id){
        studentService.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("{id}") //http://localhost:8080/students/1
    @Operation(summary = "Получение студента по идентификатору")
    public Student get(@PathVariable long id){
        return studentService.get(id);
    }

    @GetMapping("/all")
    @Operation(summary = "Получение массива всех студентов")
    public List<Student> getAll(){
        return studentService.getAll();
    }
    @GetMapping
    @Operation(summary = "Получение массива студентов с указанным возрастом")
    public List<Student> findByAge(@RequestParam int age){
        return studentService.findByAge(age);
    }

}

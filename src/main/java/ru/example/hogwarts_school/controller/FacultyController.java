package ru.example.hogwarts_school.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.example.hogwarts_school.model.Faculty;
import ru.example.hogwarts_school.service.FacultyService;
import java.util.List;

@Tag(name = "Факультеты", description = "Эндпоинты для работы с факультетами")
@RequestMapping("/faculties")
@RestController
public class FacultyController {
    private final FacultyService facultyService;
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    @PostMapping
    @Operation(summary = "Создание факультета")
    public Faculty create(@RequestBody Faculty faculty){
        return facultyService.create(faculty);
    }
    @PutMapping("{id}")
    @Operation(summary = "Изменение факультета по идентификатору")
    public Faculty update(@PathVariable long id, @RequestBody Faculty faculty){
        return facultyService.update(id, faculty);
    }
    @DeleteMapping("{id}")
    @Operation(summary = "Удаление факультета по идентификатору")
    public ResponseEntity<Faculty> delete(@PathVariable long id){
        Faculty deleted = facultyService.delete(id);
        return ResponseEntity.ok(deleted);
    }
    @GetMapping("{id}")
    @Operation(summary = "Получение факультета по идентификатору")
    public Faculty get(@PathVariable long id){
        return facultyService.get(id);
    }

    @GetMapping("/all")
    @Operation(summary = "Получение массива всех факультетов")
    public List<Faculty> getAll(){
        return facultyService.getAll();
    }
    @GetMapping
    @Operation(summary = "Получение массива факультетов с указанным цветом")
    public List<Faculty> findByColor(@RequestParam String color){
        return facultyService.findByColor(color);
    }
}

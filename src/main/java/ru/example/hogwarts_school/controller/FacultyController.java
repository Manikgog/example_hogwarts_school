package ru.example.hogwarts_school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.example.hogwarts_school.model.Faculty;
import ru.example.hogwarts_school.service.FacultyService;

import java.util.List;

@RequestMapping("/faculties")
@RestController
public class FacultyController {
    private final FacultyService facultyService;
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    @PostMapping
    public Faculty create(@RequestBody Faculty faculty){
        return facultyService.create(faculty);
    }
    @PutMapping("{id}")
    public Faculty update(@PathVariable long id, @RequestBody Faculty faculty){
        return facultyService.update(id, faculty);
    }
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable long id){
        facultyService.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("{id}")
    public Faculty get(@PathVariable long id){
        return facultyService.get(id);
    }

    @GetMapping
    public List<Faculty> getAll(){
        return facultyService.getAll();
    }
}

package ru.example.hogwarts_school.model;
import jakarta.persistence.*;

import java.lang.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Faculty {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String color;
    @OneToMany(mappedBy = "faculty")
    private Collection<Student> students;
    public Faculty() {
    }
    public Faculty(Long id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }
//    public Collection<Student> getStudents(){
//        return students;
//    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public void setColor(java.lang.String color) {
        this.color = color;
    }
    public void setStudents(List<Student> students){
        this.students = students;
    }
}

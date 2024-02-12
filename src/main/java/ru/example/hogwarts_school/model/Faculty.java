package ru.example.hogwarts_school.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.lang.*;
@Entity
public class Faculty {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String color;
    public Faculty() {
    }
    public Faculty(Long id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public java.lang.Long getId() {
        return id;
    }

    public java.lang.String getName() {
        return name;
    }

    public java.lang.String getColor() {
        return color;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public void setColor(java.lang.String color) {
        this.color = color;
    }
}

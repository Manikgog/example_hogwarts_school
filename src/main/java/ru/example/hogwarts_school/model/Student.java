package ru.example.hogwarts_school.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.lang.*;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;
    public Student(){
    }
    public Student(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public java.lang.Long getId() {
        return id;
    }

    public java.lang.String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

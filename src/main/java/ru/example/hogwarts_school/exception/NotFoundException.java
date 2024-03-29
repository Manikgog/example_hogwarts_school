package ru.example.hogwarts_school.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    private final Long id;

    public NotFoundException(Long id) {
        this.id = id;
    }
    @Override
    public String getMessage(){
        return "Ресурс с id = " + id + " не найден";
    }
}

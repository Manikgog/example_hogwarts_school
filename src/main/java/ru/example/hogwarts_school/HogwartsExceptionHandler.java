package ru.example.hogwarts_school;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.example.hogwarts_school.exception.NotAllParametersException;
import ru.example.hogwarts_school.exception.NotFoundException;

@RestControllerAdvice
public class HogwartsExceptionHandler{
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    @ExceptionHandler(NotAllParametersException.class)
    public ResponseEntity<String> handlerNotAllParametersException(NotAllParametersException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}

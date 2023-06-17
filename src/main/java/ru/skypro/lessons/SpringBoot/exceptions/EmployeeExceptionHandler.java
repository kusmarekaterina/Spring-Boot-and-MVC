package ru.skypro.lessons.SpringBoot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity <?> handleIdNotFound(IdNotFoundException e){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Сотрудник с id = %d не найден".formatted(e.getId()));
    }

    @ExceptionHandler
    public ResponseEntity <?> handleException (Exception e){
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}

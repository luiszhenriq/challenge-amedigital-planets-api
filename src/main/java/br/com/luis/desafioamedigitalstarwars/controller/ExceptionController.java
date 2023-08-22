package br.com.luis.desafioamedigitalstarwars.controller;


import br.com.luis.desafioamedigitalstarwars.domain.ExceptionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity threatNullParam(DataIntegrityViolationException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO("No empty fields are accepted", "400");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity threatNotFoundId(NoSuchElementException exception){
        ExceptionDTO exceptionDTO = new ExceptionDTO("Planet not found", "404");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDTO);
    }



}

package org.example.handler;

import org.example.dto.ExceptionDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionDto> notFoundException(EntityNotFoundException e) {
        log.error("Entity not Found", e);
        var errorDto = new ExceptionDto(
                "Entity not Found",
                e.getMessage(),
                LocalDate.now()
        );
        return ResponseEntity.
                status(HttpStatus.NOT_FOUND)
                .body(errorDto);
    }

    @ExceptionHandler(exception = {
            IllegalArgumentException.class,
            IllegalStateException.class
    })
    public ResponseEntity<ExceptionDto> handlerBadRequest(Exception e) {
        log.error("Bad request", e);
        var errorDto = new ExceptionDto(
                "Bad request",
                e.getMessage(),
                LocalDate.now()
        );
        return ResponseEntity.
                status(HttpStatus.BAD_REQUEST)
                .body(errorDto);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handlerGenericException(Exception e) {
        log.error("Handler exception", e);
        var errorDto = new ExceptionDto(
                "Handler exception",
                e.getMessage(),
                LocalDate.now()
        );
        return ResponseEntity.
                status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorDto);
    }

}

package com.ProjectSpringboot.Point_of_sale.advisor;

import com.ProjectSpringboot.Point_of_sale.exception.AlreadyExistsException;
import com.ProjectSpringboot.Point_of_sale.exception.NotFoundException;
import com.ProjectSpringboot.Point_of_sale.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException(NotFoundException ex) {
        return new ResponseEntity<>(
                new StandardResponse(404, "Not Found", ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<StandardResponse> handleAlreadyExistsException(AlreadyExistsException ex) {
        return new ResponseEntity<>(
                new StandardResponse(409, "Conflict", ex.getMessage()),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandardResponse> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        return new ResponseEntity<>(
                new StandardResponse(400, "Bad Request", "Invalid request body or unrecognized value: " + ex.getMostSpecificCause().getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<StandardResponse> handleRuntimeException(RuntimeException ex) {
        return new ResponseEntity<>(
                new StandardResponse(500, "Internal Server Error", ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}

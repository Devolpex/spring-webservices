package org.devolpex.backend.handler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OwnException.class)
    public ResponseEntity<OwnErrorRES> handleOwnException(OwnException ex) {
        return new ResponseEntity<>(ex.getRes(), ex.getRes().getStatus());
    }

    // Handle validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<OwnErrorRES> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<OwnFieldError> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(this::mapFieldError)
                .collect(Collectors.toList());

        OwnErrorRES errorResponse = OwnErrorRES.builder()
                .fieldErrors(errors)
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Helper method to map field errors
    private OwnFieldError mapFieldError(FieldError fieldError) {
        return OwnFieldError.builder()
                .field(fieldError.getField())
                .message(fieldError.getDefaultMessage())
                .build();
    }

}
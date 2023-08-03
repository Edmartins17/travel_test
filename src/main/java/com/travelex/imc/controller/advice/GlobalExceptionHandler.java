package com.travelex.imc.controller.advice;

import java.util.*;

import com.travelex.imc.dto.ErrorDto;
import com.travelex.imc.dto.IMCResponse;
import com.travelex.imc.dto.enums.ErrorCategory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<IMCResponse>> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<IMCResponse> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) ->{
            IMCResponse imcResponse = IMCResponse.builder().build();
            imcResponse.setError(ErrorDto.builder()
                    .typeError(ErrorCategory.HTTP)
                    .code(HttpStatus.BAD_REQUEST.value())
                    .description("Campo:"+  ((FieldError) error).getField())
                    .message(error.getDefaultMessage())
                    .build());

            errors.add(imcResponse);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

    }

}
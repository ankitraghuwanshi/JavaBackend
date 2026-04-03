package com.example.productservices.controllerAdvices;

import com.example.productservices.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException e){
        return new ResponseEntity<>(
                e.getMessage(),
                HttpStatus.BAD_GATEWAY
        );
    }

//    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
//    public void handleArrayIndexOutOfBound(){
//
//    }
//
//    @ExceptionHandler(Exception.class)
//    public void handleException(){
//
//    }
}

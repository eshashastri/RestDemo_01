package com.hsbc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.hsbc.exception.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(InvalidIdException.class)
    public ResponseEntity<ErrorResponse> meth1(InvalidIdException e){
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, e.getMessage());
        ResponseEntity<ErrorResponse> responseEntity = new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
        return responseEntity;
    }
}

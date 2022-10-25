package com.learning.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value =HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException{
    public static final long serialVersionUID = 1L;

    public EmployeeNotFoundException(String message){
        super(message);
    }
}

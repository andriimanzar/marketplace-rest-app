package com.projects.marketplace.exception_handling;

import com.projects.marketplace.exception.EntityNotFoundException;
import com.projects.marketplace.exception.NotEnoughMoneyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionInfo> handleEntityNotFoundException(EntityNotFoundException exception){
        return new ResponseEntity<>(fillExceptionInfo(exception), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionInfo> handleNotEnoughMoneyException(NotEnoughMoneyException exception){
        return new ResponseEntity<>(fillExceptionInfo(exception),HttpStatus.BAD_REQUEST);
    }

    private ExceptionInfo fillExceptionInfo(Exception exception){
        ExceptionInfo exceptionInfo = new ExceptionInfo();
        exceptionInfo.setInfo(exception.getMessage());
        return exceptionInfo;
    }
}

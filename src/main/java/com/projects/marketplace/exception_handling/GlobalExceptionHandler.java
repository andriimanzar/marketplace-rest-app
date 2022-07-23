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
    public ResponseEntity<IncorrectData> handleEntityNotFoundException(EntityNotFoundException exception){

        return new ResponseEntity<>(fillIncorrectData(exception), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectData> handleNotEnoughMoneyException(NotEnoughMoneyException exception){
        return new ResponseEntity<>(fillIncorrectData(exception),HttpStatus.BAD_REQUEST);
    }

    private IncorrectData fillIncorrectData(Exception e){
        IncorrectData incorrectData = new IncorrectData();
        incorrectData.setInfo(e.getMessage());
        return incorrectData;
    }
}

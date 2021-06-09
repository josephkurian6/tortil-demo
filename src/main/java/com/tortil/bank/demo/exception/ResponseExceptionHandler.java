package com.tortil.bank.demo.exception;

import com.tortil.bank.demo.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

/**
 * Exception handler for resources runtime exceptions,
 * that includes RecordNotFoundException, BadInputRequest and Server Errors
 * @Date 6/9/2021
 */
@ControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> handleAnyException(Exception exception) {

        ResponseEntity<ErrorResponse> responseResponseEntity;
        if(exception instanceof RecordNotFoundException) {
            responseResponseEntity = new ResponseEntity<>(((RecordNotFoundException) exception)
                   .getErrorResponse(), HttpStatus.NOT_FOUND);
        } else if(exception instanceof BadInputRequest) {
            responseResponseEntity = new ResponseEntity<>(((BadInputRequest) exception)
                    .getErrorResponse(), HttpStatus.BAD_REQUEST);
        } else {
            ErrorResponse errorResponse = ErrorResponse.builder().error("Server Error")
                    .message(exception.getMessage()).timestamp(new Date())
                    .status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            responseResponseEntity = new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseResponseEntity;
    }
}

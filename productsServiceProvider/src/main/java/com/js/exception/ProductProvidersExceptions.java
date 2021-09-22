package com.js.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductProvidersExceptions {

    @ExceptionHandler(NoDataFound.class)
    public ResponseEntity<NoDataFound> noDataFoundException(NoDataFound ex)
    {

        return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}

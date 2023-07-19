package com.mycompany.propertymanagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> handleFieldValidation(MethodArgumentNotValidException manv){
        List<ErrorModel> errorModelList= new ArrayList<>();
        List<FieldError> fieldErrorList=manv.getBindingResult().getFieldErrors();
        for(FieldError fe : fieldErrorList){
            logger.info("Inside Field Validation: info : {} - {}",fe.getField(),fe.getDefaultMessage());
            logger.debug("Inside Field Validation: debug : {} - {}",fe.getField(),fe.getDefaultMessage());
            errorModelList.add(new ErrorModel(fe.getField(),fe.getDefaultMessage()));
        }
        return new ResponseEntity<List<ErrorModel>>(errorModelList, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException businessException){
        for (ErrorModel er : businessException.getErrors()){
            logger.warn("BusinessException is thrown: Warn : {} - {}",er.getCode(),er.getMessage());
            logger.error("BusinessException is thrown: Error : {} - {}",er.getCode(),er.getMessage());
        }
        return new ResponseEntity<List<ErrorModel>>(businessException.getErrors(), HttpStatus.BAD_REQUEST);
    }
}

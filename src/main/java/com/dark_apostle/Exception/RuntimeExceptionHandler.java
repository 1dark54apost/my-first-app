package com.dark_apostle.Exception;

import com.dark_apostle.Response.Unity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RuntimeExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public Unity<Object> RunTimeExceptionHandler(RuntimeException e){
        return Unity.fail(e.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Unity<Object> BusinessExceptionHandler(BusinessException e){
        return Unity.fail(e.getMessage());
    }

}

package com.dark_apostle.Exception;

import com.dark_apostle.Response.Result;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class BusinessException extends Exception{

    private Integer code;

    private String message;

    public BusinessException(){
        code = Result.FAIL.getCode();
        message = Result.FAIL.getMessage();
    }
}

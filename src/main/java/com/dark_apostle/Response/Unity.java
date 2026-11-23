package com.dark_apostle.Response;

import lombok.Getter;

@Getter
public class Unity<T> {

    private Integer code;

    private String message;

    private T data;

    private Unity(Integer code){
        this.code = code;
    }

    private Unity(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    private Unity(Integer code,String message,T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Unity<T> success(){
        return new Unity<>(Result.SUCCESS.getCode(),Result.SUCCESS.getMessage());
    }

    public static <T> Unity<T> success(String message){
        return new Unity<>(Result.SUCCESS.getCode(),message);
    }

    public static <T> Unity<T> success(String message,T data){
        return new Unity<>(Result.SUCCESS.getCode(),message,data);
    }

    public static <T> Unity<T> success(T data){
        return new Unity<>(Result.SUCCESS.getCode(),Result.SUCCESS.getMessage(),data);
    }

    public static <T> Unity<T> fail(){
        return new Unity<>(Result.FAIL.getCode(),Result.FAIL.getMessage());
    }

    public static <T> Unity<T> fail(String message){
        return new Unity<>(Result.FAIL.getCode(),message);
    }

    public static <T> Unity<T> fail(Integer code,String message){
        return new Unity<>(code,message);
    }

}

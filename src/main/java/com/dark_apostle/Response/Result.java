package com.dark_apostle.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Result {

    SUCCESS(200,"成功"),
    FAIL(500,"失败");

    private final Integer code;
    private final String message;

}

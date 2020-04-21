package com.artisan.exception;

import lombok.Getter;

/**
 * 统一返回的异常信息的格式
 *
 * @author yangshangwei
 *
 */

public class ExceptionResponseEntity {
    @Getter
    private int code;
    @Getter
    private String message;

    public ExceptionResponseEntity() {

    }

    public ExceptionResponseEntity(int code, String message) {
        this.code = code;
        this.message = message;
    }

}

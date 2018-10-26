package com.yuro.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一错误信息
 * @param <T>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInfo<T> {

    public static final Integer ERROR = -1;

    private Integer code;

    private String message;

    private String url;

    private T data;
}

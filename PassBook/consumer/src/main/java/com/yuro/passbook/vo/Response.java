package com.yuro.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Controller 统一响应对象
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    private Integer errorCode = 0;

    private String errorMsg = "";

    private Object data;

    /** 正确的响应构造函数 */
    public Response(Object data){
        this.data  = data;
    }

    /** 空响应 */
    public static Response success(){
        return new Response();
    }

    /**
     * 错误响应
     * @param errorMsg
     * @return
     */
    public static Response failure(String errorMsg){
        return new Response(-1, errorMsg,null);
    }
}

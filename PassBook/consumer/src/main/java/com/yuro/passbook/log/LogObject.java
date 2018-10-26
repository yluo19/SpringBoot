package com.yuro.passbook.log;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 日志对象
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogObject {

    /** 日志动作类型 */
    private String action;

    /** 用户 id */
    private Long userId;

    private Long timestamp;
    /** 客户端ip 地址*/
    private String remoteIp;

    private Object info = null;
}

package com.yuro.passbook.log;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class LogGenerator {

    /**
     * 生成 Log
     * @param request
     * @param userId
     * @param action
     * @param info
     */
    public static void generateLog(HttpServletRequest request,
                                   Long userId,
                                   String action,
                                   Object info) {

        log.info(JSON.toJSONString(
                new LogObject(action, userId,
                        System.currentTimeMillis(),
                        request.getRemoteAddr(),
                        info)
        ));

    }

}

package com.yuro.passbook.utils;


import com.yuro.passbook.vo.Feedback;
import com.yuro.passbook.vo.GainPassTemplateRequest;
import com.yuro.passbook.vo.PassTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * RowKey生成器工具类
 *
 * RowKey 要分散 为了负载均衡
 */
@Slf4j
public class RowKeyGenerateUntils {

    public static String genPassTemplateRowKey(PassTemplate passTemplate) {
        String passInfo = String.valueOf(passTemplate.getId()+ "_" + passTemplate.getTitle());
        String rowKey = DigestUtils.md5Hex(passInfo);

        log.info("GenPassTemplateRowKey : {}, {}", passInfo, rowKey);

        return rowKey;
    }

    /** 根据提供的领取优惠券请求生成RowKey
     * Pass RowKey = reverse(userId) + inverse(timestamp) + PassTemplate RowKey
     * @param request
     * @return
     */
    public static String genPassRowKey(GainPassTemplateRequest request) {

        return new StringBuilder(String.valueOf(request.getUserId())).reverse().toString()
                + (Long.MAX_VALUE - System.currentTimeMillis())
                + genPassTemplateRowKey(request.getPassTemplate());
    }

    public static String getFeedbackRowKey(Feedback feedback) {

        return new StringBuilder(String.valueOf(feedback.getUserId())).reverse().toString()+
                (Long.MAX_VALUE - System.currentTimeMillis());
    }


}

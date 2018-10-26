package com.yuro.passbook.service;

import com.yuro.passbook.vo.Feedback;
import com.yuro.passbook.vo.Response;

/**
 * 评论服务接口
 *
 */
public interface IFeedbackService  {

    /** 创建评论 */
    Response createFeedback(Feedback feedback);

    /** 获取用户评论 */
    Response getFeedback(Long userId);

}

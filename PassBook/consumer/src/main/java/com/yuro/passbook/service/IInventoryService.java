package com.yuro.passbook.service;

import com.yuro.passbook.vo.Response;

/**
 * 获取库存信息 ：
 *  只返回用户没有领取的优惠券
 *
 */
public interface IInventoryService {

    /** 获取库存信息 */
    Response getInventoryInfo(Long userId) throws Exception;
}

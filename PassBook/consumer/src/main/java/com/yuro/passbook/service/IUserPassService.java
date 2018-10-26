package com.yuro.passbook.service;

import com.yuro.passbook.vo.Pass;
import com.yuro.passbook.vo.Response;

/**
 * 获取用户个人优惠券信息
 *
 */
public interface IUserPassService {

    /** 获取用户个人优惠券信息 即 我的优惠券 实现
     *
     * @param userId
     * @return
     * @throws Exception
     */
    Response getUserPassInfo(Long userId) throws Exception;


    /** 获取用户已使用的优惠券信息
     *
     * @param userId
     * @return
     * @throws Exception
     */
    Response getUserUsedPassInfo(Long userId) throws Exception;


    /** 获取用户所有的优惠券
     *
     * @param userId
     * @return
     * @throws Exception
     */
    Response getUserAllPassInfo(Long userId) throws Exception;

    /** 用户使用优惠券
     *
     * @param pass
     * @return
     */
    Response userUsePassInfo(Pass pass);


}

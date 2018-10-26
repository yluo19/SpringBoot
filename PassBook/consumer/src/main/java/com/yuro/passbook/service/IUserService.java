package com.yuro.passbook.service;

import com.yuro.passbook.vo.Response;
import com.yuro.passbook.vo.User;

/**
 * 用户服务： 创建用户
 */
public interface IUserService {

    /**
     * 创建用户
     * @param user
     * @return
     * @throws Exception
     */
    Response createUse(User user) throws Exception;


}

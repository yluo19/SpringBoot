package com.yuro.passbook.merchants.service;

import com.yuro.passbook.merchants.vo.CreateMerchantsRequest;
import com.yuro.passbook.merchants.vo.PassTemplate;
import com.yuro.passbook.merchants.vo.Response;

import java.io.InputStream;

/**
 * 对商户服务接口定于
 */
public interface ImerchantsService {

    /**
     * 创建商户服务
     * @param request {@link CreateMerchantsRequest}创建商户请求
     * @return {@link Response}
     */
    Response createMerchants(CreateMerchantsRequest request);

    /**
     * 根据 id 构造商户信息， 通过id 查询商户信息
     * @param id 商户 id
     * @return {@link Response}
     */
    Response buildMerchantsInfoById(Integer id);

    /**
     *  投放优惠券
     * @param template {@link PassTemplate}
     * @return {@link Response}
     */
    Response dropPassTemplate(PassTemplate template);


}

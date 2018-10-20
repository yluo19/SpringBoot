package com.yuro.passbook.merchants.serviceTest;


import com.alibaba.fastjson.JSON;
import com.yuro.passbook.merchants.service.ImerchantsService;
import com.yuro.passbook.merchants.vo.CreateMerchantsRequest;
import com.yuro.passbook.merchants.vo.PassTemplate;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 *  商户服务测试
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MerchantsServiceTest {

    @Autowired
    private ImerchantsService imerchantsService;

    @Test
    @Transactional
    public void testCreateMerchantsServ() {

        CreateMerchantsRequest request = new CreateMerchantsRequest();
        request.setName("慕课网");
        request.setLogoUrl("www.imooc.com");
        request.setBusinessLicenseUrl("www.imooc.com");
        request.setPhone("12345678");
        request.setAddress("Beijing");

        System.out.println(JSON.toJSONString(imerchantsService.createMerchants(request)));
    }

    /**
     *  {"data":{"address":"Beijing",
     *             "businessLicenseUrl":"www.imooc.com",
     *             "id":7,
     *             "isAudit":false,
     *             "logoUrl":"www.imooc.com",
     *             "name":"慕课网",
     *             "phone":"12345678"}}
     */

    @Test
    public void testBuildMerchantsInfoById() {

        System.out.println(JSON.toJSONString(imerchantsService.buildMerchantsInfoById(7)));
    }

    @Test
    public void testDropPassTemplate() {
        PassTemplate passTemplate = new PassTemplate();
        passTemplate.setId(7);
        passTemplate.setTitle("title: 慕课网");
        passTemplate.setSummary("简介： 慕课");
        passTemplate.setDesc("详情： 慕课网");
        passTemplate.setLimit(10000L);
        passTemplate.setHasToken(false);
        passTemplate.setBackground(2);
        passTemplate.setStartDate(new Date());
        passTemplate.setEndDate(DateUtils.addDays(new Date(), 10));

        System.out.println(JSON.toJSONString(imerchantsService.dropPassTemplate(passTemplate)));

    }

}

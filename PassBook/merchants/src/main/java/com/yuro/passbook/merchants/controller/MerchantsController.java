package com.yuro.passbook.merchants.controller;


import com.alibaba.fastjson.JSON;
import com.yuro.passbook.merchants.service.ImerchantsService;
import com.yuro.passbook.merchants.vo.CreateMerchantsRequest;
import com.yuro.passbook.merchants.vo.PassTemplate;
import com.yuro.passbook.merchants.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商户服务Controller
 *
 */

@Slf4j
@RestController
@RequestMapping("/merchants")
public class MerchantsController {

    /** 商户服务接口 */
    @Autowired
    private ImerchantsService imerchantsService;

    @ResponseBody
    @PostMapping("/create")
    public Response createMerchants(@RequestBody CreateMerchantsRequest request) {

        log.info("CreateMerchants: {}", JSON.toJSONString(request));
        return imerchantsService.createMerchants(request);
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Response buildMerchantsInfo(@PathVariable Integer id) {
        log.info("BuildMerchantsInfo: {}", id);

        return imerchantsService.buildMerchantsInfoById(id);
    }

    @ResponseBody
    @PostMapping("/drop")
    public Response dropPassTemplate(@RequestBody PassTemplate passTemplate) {
        log.info("DropPassTemplate: {}", passTemplate);

        return imerchantsService.dropPassTemplate(passTemplate);
    }

}

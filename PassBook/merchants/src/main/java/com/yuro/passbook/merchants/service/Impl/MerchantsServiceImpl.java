package com.yuro.passbook.merchants.service.Impl;


import com.alibaba.fastjson.JSON;
import com.yuro.passbook.merchants.DAO.MerchantsDao;
import com.yuro.passbook.merchants.constant.Constants;
import com.yuro.passbook.merchants.constant.ErrorCode;
import com.yuro.passbook.merchants.entity.Merchants;
import com.yuro.passbook.merchants.service.ImerchantsService;
import com.yuro.passbook.merchants.vo.CreateMerchantsRequest;
import com.yuro.passbook.merchants.vo.CreateMerchantsResponse;
import com.yuro.passbook.merchants.vo.PassTemplate;
import com.yuro.passbook.merchants.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *  商户服务接口实现
 */
@Slf4j
@Service
public class MerchantsServiceImpl implements ImerchantsService {

    /** Merchants 数据库接口 */
    private final MerchantsDao merchantsDao;

    /** kafka 客户端 */
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public MerchantsServiceImpl(MerchantsDao merchantsDao, KafkaTemplate<String, String> kafkaTemplate) {
        this.merchantsDao = merchantsDao;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    @Transactional
    public Response createMerchants(CreateMerchantsRequest request) {

        Response response = new Response();
        CreateMerchantsResponse merchantsResponse = new CreateMerchantsResponse();

        ErrorCode errorCode = request.validate(merchantsDao);
        if (errorCode != ErrorCode.SUCCESS) {
            merchantsResponse.setId(-1);
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDescription());
        } else {
            merchantsResponse.setId(merchantsDao.save(request.toMerchants()).getId());
        }
        response.setData(merchantsResponse);

        return response;
    }

    @Override
    public Response buildMerchantsInfoById(Integer id) {

        Response response = new Response();

        Merchants merchants = merchantsDao.findById(id);

        if(merchants == null){
            response.setErrorCode(ErrorCode.MERCHANTS_NOT_EXIST.getCode());
            response.setErrorMsg(ErrorCode.MERCHANTS_NOT_EXIST.getDescription());
        }

        response.setData(merchants);

        return response;
    }

    @Override
    public Response dropPassTemplate(PassTemplate template) {

        Response response = new Response();

        ErrorCode errorCode = template.validate(merchantsDao);
        if (errorCode != ErrorCode.SUCCESS) {
            response.setErrorCode(errorCode.getCode());
            response.setErrorMsg(errorCode.getDescription());
        } else {
            String passTemplate = JSON.toJSONString(template);
            kafkaTemplate.send(
                    Constants.TEMPLATE_TOPIC,
                    Constants.TEMPLATE_TOPIC,
                    passTemplate
            );

            log.info("DropPassTemplate : {}", passTemplate);
        }

        return null;
    }
}

package com.yuro.passbook.vo;

import com.yuro.passbook.entity.Merchants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 优惠券模版信息
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassTemplateInfo extends PassTemplate {

    /** 优惠券模版 */
    private PassTemplate passTemplate;

    /** 优惠券对应商户 */
    private Merchants merchants;


}

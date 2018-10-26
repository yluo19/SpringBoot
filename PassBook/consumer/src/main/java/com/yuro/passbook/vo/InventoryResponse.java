package com.yuro.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 库存请求响应
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryResponse {

    /** 用户 id
     *
     * 标示 不同用户 看到不同库存
     * */
    private Long userId;

    /** 优惠券模版信息 */
    private List<PassTemplateInfo> passTemplateInfos;


}

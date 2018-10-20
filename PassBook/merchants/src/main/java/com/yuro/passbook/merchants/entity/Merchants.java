package com.yuro.passbook.merchants.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * <h1>商户对象模型</h1>
 */

@Data                   // @Data 实现setter和getter方法
@NoArgsConstructor      // 实现无参的构造器
@AllArgsConstructor     // 实现全参的构造器
@Entity                 // 表明实体对象
@Table(name = "merchants") // 定义表
public class Merchants {

    /** 商户id，主键*/
    @Id  //主键
    @GeneratedValue // 自动生成值
    @Column(name = "id", nullable = false) //此列的属性
    private Integer id;

    /** 商户名称， 需要全局唯一 */
    @Basic //表明是 merchants 表中的基本列 （默认定义） @Transient 是相对的注解
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    /** 商户logo */
    @Basic
    @Column(name = "logo_url", nullable = false)
    private String logoUrl;

    /** 商户营业执照 */
    @Basic
    @Column(name = "business_license_url", nullable = false)
    private String businessLicenseUrl;

    /** 商户联系方式 */
    @Basic
    @Column(name = "phone", nullable = false)
    private String phone;

    /** 商户地址 */
    @Basic
    @Column(name = "address", nullable = false)
    private String address;

    /** 商户是否通过审核 */
    @Basic
    @Column(name = "is_audit", nullable = false)
    private Boolean isAudit = false;
}

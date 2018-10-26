package com.yuro.passbook.vo;


import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 投放优惠券对象定义
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassTemplate {

    private Integer id;

    private String title;

    private String summary;

    private String desc;

    private Long limit;

    private Boolean hasToken;

    private Integer background;

    private Date start;

    private Date end;
}

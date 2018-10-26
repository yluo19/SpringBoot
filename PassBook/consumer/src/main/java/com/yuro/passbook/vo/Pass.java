package com.yuro.passbook.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pass {

    private Long userId;

    /** pass 在 Hbase 中的 RowKey */
    private String rowKey;

    private String templateId;

    private String token;

    /** 领取日期 */
    private Date assignedDate;

    /** 消费日期 */
    private Date conDate;


}

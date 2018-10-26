package com.yuro.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.DocFlavor;

/**
 * User Object <----> Hbase User
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /** 用户 ID */
    private Long id;

    /** 用户基本信息 */
    private BaseInfo baseInfo; // b 列族

    /** 用户额外信息 */
    private OtherInfo otherInfo; // o 列族

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BaseInfo {

        private String name;
        private Integer age;
        private String sex;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OtherInfo {

        private String phone;
        private String address;
    }

}

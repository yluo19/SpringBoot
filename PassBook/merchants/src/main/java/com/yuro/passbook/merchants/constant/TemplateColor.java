package com.yuro.passbook.merchants.constant;



public enum TemplateColor {

    RED(1, "red"),
    GREEN(2, "green"),
    BLUE(3, "blue");

    /** 颜色代码 */
    private Integer code;

    /** 颜色描述 */
    private String color;

    TemplateColor (Integer code, String color) {
        this.code = code;
        this.color = color;
    }

    public Integer getCode() {
        return  code;
    }

    public String getColor() {
        return color;
    }

}

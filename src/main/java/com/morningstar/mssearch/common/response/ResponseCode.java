package com.morningstar.mssearch.common.response;

/**
 * Created by 邓锦辉
 *
 * @author hdeng
 */
public enum ResponseCode {

    SUCCESS(200, "SUCCESS"),
    ERROR(500, "ERROR"),

    //自定义异常
    LOGIN_ERROR(401, "log in error");


    private final int code;
    private final String desc;


    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}

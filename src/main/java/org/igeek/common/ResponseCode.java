package org.igeek.common;

/**
 * Created by Gyges on 2017/5/29.
 */
public enum  ResponseCode {

    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT"),
    NEED_LOGIN(10,"NEED_LOGIN"),
    ERROR(1,"ERROR"),
    SUCCESS(0,"SUCCESS");

    private final int code;
    private final String codeDesc;


    ResponseCode(int code, String codeDesc) {
        this.code = code;
        this.codeDesc = codeDesc;
    }

    public int getCode() {
        return code;
    }

    public String getCodeDesc() {
        return codeDesc;
    }
}

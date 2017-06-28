package org.igeek.util;

import com.google.common.base.MoreObjects;

/**
 * Created by zhangfan on 16/8/16.
 */
public class OkHttpResponse {
    private int Code;
    private String body;

    public OkHttpResponse(int code, String body) {
        Code = code;
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("Code", Code)
                .add("body", body)
                .toString();
    }
}

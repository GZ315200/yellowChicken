package org.igeek.common;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * Created by Gyges on 2017/5/29.
 * 服务器响应json
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//序列化json时，如果为null对象，key就会消失
public class ServerResponse<T> implements Serializable {

    private T data;
    private int status;
    private String msg;


    private ServerResponse(int status) {
        this.status = status;
    }

    private ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private ServerResponse(T data, int status) {
        this.data = data;
        this.status = status;
    }


    private ServerResponse(T data, int status, String msg) {
        this.data = data;
        this.status = status;
        this.msg = msg;
    }


    /**
     * 是否返回成功
     * @return
     */
    @JsonIgnore
//    不在序列化结果当中
    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public int getStatus(){
        return status;
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    /**
     * 返回状态码
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    /**
     * 返回状态信息、状态码
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> createBySuccess(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }

    /**
     * 返回data
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(data,ResponseCode.SUCCESS.getCode());
    }

    /**
     * 返回data 、 code 、msg
     * @param data
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> createBySuccess(String msg,T data){
        return new ServerResponse<T>(data,ResponseCode.SUCCESS.getCode(),msg);
    }

    /**
     * 创建错误code
     * @param <T>
     * @return
     */
    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getCodeDesc());
    }

    public static <T> ServerResponse<T> createByErrorMsg(String errorMsg){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),errorMsg);
    }

    public static <T> ServerResponse<T> createByErrorCodeAndMsg(int errorCode,String errorMsg){
        return new ServerResponse<T>(errorCode,errorMsg);
    }

}

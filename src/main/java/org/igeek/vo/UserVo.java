package org.igeek.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Gyges on 2017/7/1.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserVo {

    private Integer userId;
    private String name;
    private String userNameCode;


    public UserVo() {
    }


    public String getUserNameCode() {
        return userNameCode;
    }

    public void setUserNameCode(String userNameCode) {
        this.userNameCode = userNameCode;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

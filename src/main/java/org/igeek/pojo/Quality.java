package org.igeek.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Quality {
    private Integer id;

    private Integer userId;

    private String username;

    private String title;

    private String remark;

    private Integer status;

    private BigDecimal money;

    private Integer questionType;

    private Date created;

    private Date modified;

    public Quality(Integer id, Integer userId, String title, String remark, Integer status, BigDecimal money, Integer questionType, Date created, Date modified) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.remark = remark;
        this.status = status;
        this.money = money;
        this.questionType = questionType;
        this.created = created;
        this.modified = modified;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Quality() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
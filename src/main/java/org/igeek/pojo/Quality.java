package org.igeek.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Quality {
    private Integer id;

    private Integer userId;

    private String title;

    private String desc;

    private String status;

    private BigDecimal money;

    private Integer type;

    private Date created;

    private Date modified;

    public Quality(Integer id, Integer userId, String title, String desc, String status, BigDecimal money, Integer type, Date created, Date modified) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.desc = desc;
        this.status = status;
        this.money = money;
        this.type = type;
        this.created = created;
        this.modified = modified;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
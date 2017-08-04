package org.igeek.pojo;

import java.util.Date;

public class PCollect {
    private Integer id;

    private Integer orgId;

    private Integer userId;

    private String userCode;

    private String userName;

    private Integer proId;

    private String proCode;

    private String proTitle;

    private Float countOk;

    private Float countError;

    private String beizhu;

    private Integer status;

    private Date created;

    private Date modified;

    public PCollect(Integer id, Integer orgId, Integer userId, String userCode, String userName, Integer proId, String proCode, String proTitle, Float countOk, Float countError, String beizhu, Integer status, Date created, Date modified) {
        this.id = id;
        this.orgId = orgId;
        this.userId = userId;
        this.userCode = userCode;
        this.userName = userName;
        this.proId = proId;
        this.proCode = proCode;
        this.proTitle = proTitle;
        this.countOk = countOk;
        this.countError = countError;
        this.beizhu = beizhu;
        this.status = status;
        this.created = created;
        this.modified = modified;
    }

    public PCollect() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProCode() {
        return proCode;
    }

    public void setProCode(String proCode) {
        this.proCode = proCode == null ? null : proCode.trim();
    }

    public String getProTitle() {
        return proTitle;
    }

    public void setProTitle(String proTitle) {
        this.proTitle = proTitle == null ? null : proTitle.trim();
    }

    public Float getCountOk() {
        return countOk;
    }

    public void setCountOk(Float countOk) {
        this.countOk = countOk;
    }

    public Float getCountError() {
        return countError;
    }

    public void setCountError(Float countError) {
        this.countError = countError;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu == null ? null : beizhu.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
package org.igeek.pojo;

import java.util.Date;

public class SpCollect {
    private Integer id;

    private Integer orgId;

    private Integer userId;

    private String userCode;

    private String userName;

    private String owerId;

    private String owerCode;

    private String owerName;

    private Integer proId;

    private String proCode;

    private String proTitle;

    private Integer proCateId;

    private String proCateTitle;

    private Integer count;

    private String beizhu;

    private Integer status;

    private Date created;

    private Date modified;

    public SpCollect(Integer id, Integer orgId, Integer userId, String userCode, String userName, String owerId, String owerCode, String owerName, Integer proId, String proCode, String proTitle, Integer proCateId, String proCateTitle, Integer count, String beizhu, Integer status, Date created, Date modified) {
        this.id = id;
        this.orgId = orgId;
        this.userId = userId;
        this.userCode = userCode;
        this.userName = userName;
        this.owerId = owerId;
        this.owerCode = owerCode;
        this.owerName = owerName;
        this.proId = proId;
        this.proCode = proCode;
        this.proTitle = proTitle;
        this.proCateId = proCateId;
        this.proCateTitle = proCateTitle;
        this.count = count;
        this.beizhu = beizhu;
        this.status = status;
        this.created = created;
        this.modified = modified;
    }

    public SpCollect() {
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

    public String getOwerId() {
        return owerId;
    }

    public void setOwerId(String owerId) {
        this.owerId = owerId == null ? null : owerId.trim();
    }

    public String getOwerCode() {
        return owerCode;
    }

    public void setOwerCode(String owerCode) {
        this.owerCode = owerCode == null ? null : owerCode.trim();
    }

    public String getOwerName() {
        return owerName;
    }

    public void setOwerName(String owerName) {
        this.owerName = owerName == null ? null : owerName.trim();
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

    public Integer getProCateId() {
        return proCateId;
    }

    public void setProCateId(Integer proCateId) {
        this.proCateId = proCateId;
    }

    public String getProCateTitle() {
        return proCateTitle;
    }

    public void setProCateTitle(String proCateTitle) {
        this.proCateTitle = proCateTitle == null ? null : proCateTitle.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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
package org.igeek.pojo;

import java.util.Date;

public class QualityCollection {
    private Integer id;

    private Integer orgId;

    private Integer userId;

    private String userCode;

    private String userName;

    private Integer productId;

    private String typeId;

    private Integer rankId;

    private Integer quantity;

    private Integer yaoluId;

    private Integer status;

    private Long count;

    private String remark;

    private Date created;

    private Date modified;

    public QualityCollection(Integer id, Integer orgId, Integer userId, String userCode, String userName, Integer productId, String typeId, Integer rankId, Integer quantity, Integer yaoluId, Integer status, Long count, String remark, Date created, Date modified) {
        this.id = id;
        this.orgId = orgId;
        this.userId = userId;
        this.userCode = userCode;
        this.userName = userName;
        this.productId = productId;
        this.typeId = typeId;
        this.rankId = rankId;
        this.quantity = quantity;
        this.yaoluId = yaoluId;
        this.status = status;
        this.count = count;
        this.remark = remark;
        this.created = created;
        this.modified = modified;
    }

    public QualityCollection() {
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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public Integer getRankId() {
        return rankId;
    }

    public void setRankId(Integer rankId) {
        this.rankId = rankId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getYaoluId() {
        return yaoluId;
    }

    public void setYaoluId(Integer yaoluId) {
        this.yaoluId = yaoluId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
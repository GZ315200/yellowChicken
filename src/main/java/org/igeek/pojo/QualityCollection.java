package org.igeek.pojo;

import java.util.Date;

public class QualityCollection {
    private Integer id;

    private String userCode;

    private Integer userId;

    private Integer productId;

    private Integer typeId;

    private Integer rankId;

    private Integer quantity;

    private Integer yaoluId;

    private Integer status;

    private Long count;

    private String remark;

    private Date created;

    private Date modified;

    public QualityCollection(Integer id, String userCode, Integer userId, Integer productId, Integer typeId, Integer rankId, Integer quantity, Integer yaoluId, Integer status, Long count, String remark, Date created, Date modified) {
        this.id = id;
        this.userCode = userCode;
        this.userId = userId;
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

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
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
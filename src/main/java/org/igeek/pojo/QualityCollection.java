package org.igeek.pojo;

import java.util.Date;

public class QualityCollection {

    private Integer id; //采集id

    private Integer userId; //员工id

    private String userCode; //员工编码

    private String userName; //员工姓名

    private Integer productId; //产品id

    private String typeId; //采集问题类型(1:成型问题2:修坯/上水3:喷釉4:登窑5:烧窑)

    private Integer rankId; //等级id

    private Integer quantity; //数量

    private Integer yaoluId; //窑炉id

    private Integer status; //状态 默认为1

    private Long count; //统计次数 默认为0

    private String remark; //备注

    private Date created; //创建时间

    private Date modified; //修改时间

    public QualityCollection(Integer id, Integer userId, String userCode, String userName, Integer productId, String typeId, Integer rankId, Integer quantity, Integer yaoluId, Integer status, Long count, String remark, Date created, Date modified) {
        this.id = id;
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
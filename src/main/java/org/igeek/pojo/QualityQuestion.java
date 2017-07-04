package org.igeek.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class QualityQuestion {
    private Integer id;

    private Integer collectId;//采集次数id

    private Integer collectType;//采集问题类型id

    private Integer questionId; //问题id

    private String questionName; //问题名称

    private Double coefficient; // 系数

    private Integer userId;//员工类别

    private Integer quantity;//数量

    private Integer status;//状态

    private String remark;//备注

    private Date created; //创建时间

    private Date modified;//修改时间

    public QualityQuestion(Integer id, Integer collectId, Integer collectType, Integer questionId, String questionName, Double coefficient, Integer userId, Integer quantity, Integer status, String remark, Date created, Date modified) {
        this.id = id;
        this.collectId = collectId;
        this.collectType = collectType;
        this.questionId = questionId;
        this.questionName = questionName;
        this.coefficient = coefficient;
        this.userId = userId;
        this.quantity = quantity;
        this.status = status;
        this.remark = remark;
        this.created = created;
        this.modified = modified;
    }

    public QualityQuestion() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
    }

    public Integer getCollectType() {
        return collectType;
    }

    public void setCollectType(Integer collectType) {
        this.collectType = collectType;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName == null ? null : questionName.trim();
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    public Integer getquantity() {
        return quantity;
    }

    public void setquantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
package org.igeek.pojo;

import java.util.Date;

public class QualityQuestion {

    private Integer id;

    private Integer collectId;

    private String questionType;

    private Integer collectType;

    private Integer questionId;

    private String questionName;

    private Integer userId;

    private Double coefficient;

    private Integer quantity;

    private Integer status;

    private String remark;

    private Date created;

    private Date modified;

    public QualityQuestion(Integer id, Integer collectId, String questionType, Integer collectType, Integer questionId, String questionName, Integer userId, Double coefficient, Integer quantity, Integer status, String remark, Date created, Date modified) {
        this.id = id;
        this.collectId = collectId;
        this.questionType = questionType;
        this.collectType = collectType;
        this.questionId = questionId;
        this.questionName = questionName;
        this.userId = userId;
        this.coefficient = coefficient;
        this.quantity = quantity;
        this.status = status;
        this.remark = remark;
        this.created = created;
        this.modified = modified;
    }

    public QualityQuestion() {
        super();
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

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType == null ? null : questionType.trim();
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
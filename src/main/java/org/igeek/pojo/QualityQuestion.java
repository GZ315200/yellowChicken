package org.igeek.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class QualityQuestion {
    private Integer id;

    private Integer questionId;

    private String questionName;

    private Float coefficient;

    private String quality;

    private Integer status;

    private String remark;

    private Date created;

    private Date modified;

    public QualityQuestion(Integer id, Integer questionId, String questionName, Float coefficient, String quality, Integer status, String remark, Date created, Date modified) {
        this.id = id;
        this.questionId = questionId;
        this.questionName = questionName;
        this.coefficient = coefficient;
        this.quality = quality;
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

    public Float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Float coefficient) {
        this.coefficient = coefficient;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality == null ? null : quality.trim();
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
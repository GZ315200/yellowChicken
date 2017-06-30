package org.igeek.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

/**
 * Created by Gyges on 2017/6/29.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class QualityVo {

    private Integer qualityId;
    private String qualityName;
    private Integer questionType;
    private BigDecimal amount;
    private Integer workerType;
    private String description;
    private String qualityIdName;


    public QualityVo() {
    }



    public Integer getQualityId() {
        return qualityId;
    }

    public void setQualityId(Integer qualityId) {
        this.qualityId = qualityId;
    }

    public String getQualityName() {
        return qualityName;
    }

    public void setQualityName(String qualityName) {
        this.qualityName = qualityName;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getWorkerType() {
        return workerType;
    }

    public void setWorkerType(Integer workerType) {
        this.workerType = workerType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQualityIdName() {
        return qualityIdName;
    }

    public void setQualityIdName(String qualityIdName) {
        this.qualityIdName = qualityIdName;
    }
}

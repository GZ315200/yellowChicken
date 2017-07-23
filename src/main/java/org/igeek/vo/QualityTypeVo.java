package org.igeek.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Gyges on 2017/7/2.
 * 用于采集不同类型的质量问题
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QualityTypeVo {

    private Integer id;
    private Integer questionId;
    private String questionName;
    private Integer questionQuantity;
    private Double coefficient;
    private String questionWorkerName;
    private String collectId;
    private Integer workerId;
    private Integer collectType;
    private String questionType;




    public QualityTypeVo() {
    }


    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
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
        this.questionName = questionName;
    }

    public Integer getQuestionQuantity() {
        return questionQuantity;
    }

    public void setQuestionQuantity(Integer questionQuantity) {
        this.questionQuantity = questionQuantity;
    }

    public String getQuestionWorkerName() {
        return questionWorkerName;
    }

    public void setQuestionWorkerName(String questionWorkerName) {
        this.questionWorkerName = questionWorkerName;
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    public String getCollectId() {
        return collectId;
    }

    public void setCollectId(String collectId) {
        this.collectId = collectId;
    }

    public Integer getCollectType() {
        return collectType;
    }

    public void setCollectType(Integer collectType) {
        this.collectType = collectType;
    }

    //    private Double

}

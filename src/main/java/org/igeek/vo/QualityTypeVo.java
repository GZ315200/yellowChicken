package org.igeek.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Gyges on 2017/7/2.
 */

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class QualityTypeVo {


    private Integer questionType;//问题类别（1：成型问题，2,喷釉问题）
    private Integer questionId;//问题id
    private Integer quantity;//数量
    private Double coefficient;//系数


    public QualityTypeVo() {
    }

    public QualityTypeVo(Integer questionType, Integer questionId, Integer quantity, Double coefficient) {
        this.questionType = questionType;
        this.questionId = questionId;
        this.quantity = quantity;
        this.coefficient = coefficient;
    }

    public Integer getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Integer questionType) {
        this.questionType = questionType;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }


//    private Double

}

package org.igeek.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by Gyges on 2017/7/9.
 * 用于添加修改的采集信息
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CollectDetail {
    /**
     * collectType
     * workerId
     */


    private String workerName;
    private Integer workerId;
    private String kilnName;
    private String productCode;
    private String rankName;
    private Integer quantity;
    private List<QualityTypeVo> qualityTypeVoList;


    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getKilnName() {
        return kilnName;
    }

    public void setKilnName(String kilnName) {
        this.kilnName = kilnName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<QualityTypeVo> getQualityTypeVoList() {
        return qualityTypeVoList;
    }

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    public void setQualityTypeVoList(List<QualityTypeVo> qualityTypeVoList) {
        this.qualityTypeVoList = qualityTypeVoList;
    }
}

package org.igeek.vo;

import java.util.Date;
import java.util.Set;

/**
 * Created by Gyges on 2017/7/23.
 */
public class CollectEditVo {

    private Integer id;
    private String collectId;
    private Set<Integer> productId;
    private Set<String> productName;
    private Integer rankId;
    private String rankName;
    private Integer yaoluId;
    private String yaoluName;
    private String workerCode;
    private Integer workerId;
    private String workerName;
    private Integer quantity;
    private Date createTime;
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCollectId() {
        return collectId;
    }

    public void setCollectId(String collectId) {
        this.collectId = collectId;
    }

    public Set<Integer> getProductId() {
        return productId;
    }

    public void setProductId(Set<Integer> productId) {
        this.productId = productId;
    }

    public Set<String> getProductName() {
        return productName;
    }

    public void setProductName(Set<String> productName) {
        this.productName = productName;
    }

    public Integer getRankId() {
        return rankId;
    }

    public void setRankId(Integer rankId) {
        this.rankId = rankId;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public Integer getYaoluId() {
        return yaoluId;
    }

    public void setYaoluId(Integer yaoluId) {
        this.yaoluId = yaoluId;
    }

    public String getYaoluName() {
        return yaoluName;
    }

    public void setYaoluName(String yaoluName) {
        this.yaoluName = yaoluName;
    }

    public String getWorkerCode() {
        return workerCode;
    }

    public void setWorkerCode(String workerCode) {
        this.workerCode = workerCode;
    }

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

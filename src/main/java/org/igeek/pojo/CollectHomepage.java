package org.igeek.pojo;

import java.util.Date;

public class CollectHomepage {
    private Integer id;

    private Integer orgId;

    private Integer workerId;

    private String workerCode;

    private String workerName;

    private Integer collectCount;

    private Date updateTime;

    private Date createTime;

    public CollectHomepage(Integer id, Integer orgId, Integer workerId, String workerCode, String workerName, Integer collectCount, Date updateTime, Date createTime) {
        this.id = id;
        this.orgId = orgId;
        this.workerId = workerId;
        this.workerCode = workerCode;
        this.workerName = workerName;
        this.collectCount = collectCount;
        this.updateTime = updateTime;
        this.createTime = createTime;
    }

    public CollectHomepage() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    public String getWorkerCode() {
        return workerCode;
    }

    public void setWorkerCode(String workerCode) {
        this.workerCode = workerCode == null ? null : workerCode.trim();
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName == null ? null : workerName.trim();
    }

    public Integer getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(Integer collectCount) {
        this.collectCount = collectCount;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
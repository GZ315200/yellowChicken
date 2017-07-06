package org.igeek.pojo;

import java.util.Date;

public class Kiln {
    private Integer id;

    private Integer orgId;

    private String title;

    private String remark;

    private Integer status;

    private Date created;

    private Date modified;

    public Kiln(Integer id, Integer orgId, String title, String remark, Integer status, Date created, Date modified) {
        this.id = id;
        this.orgId = orgId;
        this.title = title;
        this.remark = remark;
        this.status = status;
        this.created = created;
        this.modified = modified;
    }

    public Kiln() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
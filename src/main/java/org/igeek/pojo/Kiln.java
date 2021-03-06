package org.igeek.pojo;

import java.util.Date;

/**
 * 窑炉信息
 */
public class Kiln {

    private Integer id;

    private String title;

    private String remark;

    private String status;
    
    private Date created;

    private Date modified;

    public Kiln(Integer id, String title, String remark, String status, Date created, Date modified) {
        this.id = id;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getremark() {
        return remark;
    }

    public void setremark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
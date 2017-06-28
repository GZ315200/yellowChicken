package org.igeek.pojo;

import java.util.Date;

/**
 * 产品类别
 */
public class ProCategory {
    private Integer id;

    private String title;

    private String desc;

    private Float xishu;

    private Integer status;

    private Date created;

    private Date modified;

    public ProCategory(Integer id, String title, String desc, Float xishu, Integer status, Date created, Date modified) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.xishu = xishu;
        this.status = status;
        this.created = created;
        this.modified = modified;
    }

    public ProCategory() {
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public Float getXishu() {
        return xishu;
    }

    public void setXishu(Float xishu) {
        this.xishu = xishu;
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
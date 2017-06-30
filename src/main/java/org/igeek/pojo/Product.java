package org.igeek.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;


/**
 * 产品信息
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {
    private Integer id;

    private String codestr;

    private String title;

    private Integer proCategory;

    private Float zjjj;

    private Float xpjj;

    private Float syjj;

    private Float dyjj;

    private Float bzjj;

    private String beizhu;

    private Integer status;

    private Date created;

    private Date modified;

    public Product(Integer id, String codestr, String title, Integer proCategory, Float zjjj, Float xpjj, Float syjj, Float dyjj, Float bzjj, String beizhu, Integer status, Date created, Date modified) {
        this.id = id;
        this.codestr = codestr;
        this.title = title;
        this.proCategory = proCategory;
        this.zjjj = zjjj;
        this.xpjj = xpjj;
        this.syjj = syjj;
        this.dyjj = dyjj;
        this.bzjj = bzjj;
        this.beizhu = beizhu;
        this.status = status;
        this.created = created;
        this.modified = modified;
    }

    public Product() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodestr() {
        return codestr;
    }

    public void setCodestr(String codestr) {
        this.codestr = codestr == null ? null : codestr.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getProCategory() {
        return proCategory;
    }

    public void setProCategory(Integer proCategory) {
        this.proCategory = proCategory;
    }

    public Float getZjjj() {
        return zjjj;
    }

    public void setZjjj(Float zjjj) {
        this.zjjj = zjjj;
    }

    public Float getXpjj() {
        return xpjj;
    }

    public void setXpjj(Float xpjj) {
        this.xpjj = xpjj;
    }

    public Float getSyjj() {
        return syjj;
    }

    public void setSyjj(Float syjj) {
        this.syjj = syjj;
    }

    public Float getDyjj() {
        return dyjj;
    }

    public void setDyjj(Float dyjj) {
        this.dyjj = dyjj;
    }

    public Float getBzjj() {
        return bzjj;
    }

    public void setBzjj(Float bzjj) {
        this.bzjj = bzjj;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu == null ? null : beizhu.trim();
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
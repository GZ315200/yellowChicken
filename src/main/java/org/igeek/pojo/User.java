package org.igeek.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;


@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class User {
    private Integer id;

    private String username;

    @JsonIgnore
    private String password;

    private String name;

    private Integer category;

    private String numstr;

    private String codestr;

    private String otherinfo;

    private String beizhu;

    private Integer status;

    private Date created;

    private Date modified;

    public User(Integer id, String username, String password, String name, Integer category, String numstr, String codestr, String otherinfo, String beizhu, Integer status, Date created, Date modified) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.category = category;
        this.numstr = numstr;
        this.codestr = codestr;
        this.otherinfo = otherinfo;
        this.beizhu = beizhu;
        this.status = status;
        this.created = created;
        this.modified = modified;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getNumstr() {
        return numstr;
    }

    public void setNumstr(String numstr) {
        this.numstr = numstr == null ? null : numstr.trim();
    }

    public String getCodestr() {
        return codestr;
    }

    public void setCodestr(String codestr) {
        this.codestr = codestr == null ? null : codestr.trim();
    }

    public String getOtherinfo() {
        return otherinfo;
    }

    public void setOtherinfo(String otherinfo) {
        this.otherinfo = otherinfo == null ? null : otherinfo.trim();
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
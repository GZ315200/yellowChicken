package org.igeek.pojo;

import java.util.Date;

public class Organization {
    private Integer id;

    private Integer orgId;

    private String username;

    private String password;

    private String orgName;

    private String contact;

    private String email;

    private Integer status;

    private Date updatetime;

    private Date createtime;

    public Organization(Integer id, Integer orgId, String username, String password, String orgName, String contact, String email, Integer status, Date updatetime, Date createtime) {
        this.id = id;
        this.orgId = orgId;
        this.username = username;
        this.password = password;
        this.orgName = orgName;
        this.contact = contact;
        this.email = email;
        this.status = status;
        this.updatetime = updatetime;
        this.createtime = createtime;
    }

    public Organization() {
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

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
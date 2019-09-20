package com.daxie.daxie_api.model;

import javax.persistence.*;
import java.util.Date;

public class Message {
    @Id
    @Column(name = "` messageid`")
    private Integer messageid;

    private String username;

    private String mobile;

    private String categoryname;

    private Integer messagestatus;

    private Integer  kind;

    public Integer getKind() {
        return kind;
    }

    private Date  time;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setKind(Integer kind) {
        this.kind = kind;
    }

    /**
     * @return  messageid
     */
    public Integer getMessageid() {
        return messageid;
    }

    /**
     * @param messageid
     */
    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return categoryname
     */
    public String getCategoryname() {
        return categoryname;
    }

    /**
     * @param categoryname
     */
    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    /**
     * @return messagestatus
     */
    public Integer getMessagestatus() {
        return messagestatus;
    }

    /**
     * @param messagestatus
     */
    public Integer setMessagestatus(Integer messagestatus) {
        this.messagestatus = messagestatus;
        return messagestatus;
    }
}
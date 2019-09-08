package com.daxie.daxie_api.model;

import javax.persistence.*;

public class Relation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private String userid;

    private Integer operating;//操作  1关注  0取消关注

    @Column(name = "forUserId")
    private String foruserid;

    /**
     * @return userId
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * @return operating
     */
    public Integer getOperating() {
        return operating;
    }

    /**
     * @param operating
     */
    public void setOperating(Integer operating) {
        this.operating = operating;
    }

    /**
     * @return forUserId
     */
    public String getForuserid() {
        return foruserid;
    }

    /**
     * @param foruserid
     */
    public void setForuserid(String foruserid) {
        this.foruserid = foruserid;
    }
}

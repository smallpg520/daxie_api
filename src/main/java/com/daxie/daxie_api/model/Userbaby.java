package com.daxie.daxie_api.model;

import java.util.Date;
import javax.persistence.*;

public class Userbaby {
    /**
     * 区别于每一个用户
     */
    @Id
    private Integer userid;

    /**
     * 名字
     */
    private String username;

    private String mobile;

    private String kind;

    private Date createtime;

    private String token;

    private   Integer   status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取区别于每一个用户
     *
     * @return userid - 区别于每一个用户
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 设置区别于每一个用户
     *
     * @param userid 区别于每一个用户
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * 获取名字
     *
     * @return username - 名字
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置名字
     *
     * @param username 名字
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
     * @return kind
     */
    public String getKind() {
        return kind;
    }

    /**
     * @param kind
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * @return createtime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * @return token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }
}
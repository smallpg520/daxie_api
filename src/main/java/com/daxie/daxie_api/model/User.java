package com.daxie.daxie_api.model;

import javax.persistence.*;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "userId")
    private String userid;

    @Column(name = "userName")
    private String username;

    @Column(name = "passWord")
    private String password;

    private String email;

    private String sex;

    private String introduction;

    @Column(name = "weChat")
    private String wechat;

    private String qq;

    private String address;

    @Column(name = "createDate")
    private String createdate;

    @Column(name = "lastDate")
    private String lastdate;

    @Column(name = "isStat")
    private Integer isstat;

    @Column(name = "userSignature")
    private String usersignature;

    @Column(name = "userImage")
    private String userimage;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

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
     * @return userName
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
     * @return passWord
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return introduction
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * @param introduction
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * @return weChat
     */
    public String getWechat() {
        return wechat;
    }

    /**
     * @param wechat
     */
    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    /**
     * @return qq
     */
    public String getQq() {
        return qq;
    }

    /**
     * @param qq
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return createDate
     */
    public String getCreatedate() {
        return createdate;
    }

    /**
     * @param createdate
     */
    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    /**
     * @return lastDate
     */
    public String getLastdate() {
        return lastdate;
    }

    /**
     * @param lastdate
     */
    public void setLastdate(String lastdate) {
        this.lastdate = lastdate;
    }

    /**
     * @return isStat
     */
    public Integer getIsstat() {
        return isstat;
    }

    /**
     * @param isstat
     */
    public void setIsstat(Integer isstat) {
        this.isstat = isstat;
    }

    /**
     * @return userSignature
     */
    public String getUsersignature() {
        return usersignature;
    }

    /**
     * @param usersignature
     */
    public void setUsersignature(String usersignature) {
        this.usersignature = usersignature;
    }

    /**
     * @return userImage
     */
    public String getUserimage() {
        return userimage;
    }

    /**
     * @param userimage
     */
    public void setUserimage(String userimage) {
        this.userimage = userimage;
    }
}
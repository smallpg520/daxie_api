package com.daxie.daxie_api.model;

import javax.persistence.*;

public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "replyId")
    private String replyid;

    @Column(name = "createTime")
    private String createtime;

    @Column(name = "likeCount")
    private Integer likecount;

    private Integer incognito;

    @Column(name = "problemId")
    private String problemid;

    @Column(name = "userId")
    private String userid;

    @Column(name = "userName")
    private String username;

    @Column(name = "userImage")
    private String userimage;

    @Column(name = "userSignature")
    private String usersignature;

    private String content;


    @Column(name = "likeId")
    private String likeid;


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
     * @return replyId
     */
    public String getReplyid() {
        return replyid;
    }

    /**
     * @param replyid
     */
    public void setReplyid(String replyid) {
        this.replyid = replyid;
    }

    /**
     * @return createTime
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    /**
     * @return likeCount
     */
    public Integer getLikecount() {
        return likecount;
    }

    /**
     * @param likecount
     */
    public void setLikecount(Integer likecount) {
        this.likecount = likecount;
    }

    /**
     * @return incognito
     */
    public Integer getIncognito() {
        return incognito;
    }

    /**
     * @param incognito
     */
    public void setIncognito(Integer incognito) {
        this.incognito = incognito;
    }

    /**
     * @return problemId
     */
    public String getProblemid() {
        return problemid;
    }

    /**
     * @param problemid
     */
    public void setProblemid(String problemid) {
        this.problemid = problemid;
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
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    public String getLikeid() {
        return likeid;
    }

    public void setLikeid(String likeid) {
        this.likeid = likeid;
    }
}

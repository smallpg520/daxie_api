package com.daxie.daxie_api.model;

import javax.persistence.*;

public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "problemId")
    private String problemid;

    private String title;

    private String tag;

    private Integer incognito;

    @Column(name = "sortId")
    private Integer sortid;

    @Column(name = "replyCount")
    private Integer replycount;

    @Column(name = "followCount")
    private Integer followcount;

    @Column(name = "createTime")
    private String createtime;

    @Column(name = "userId")
    private String userid;

    @Column(name = "userName")
    private String username;

    @Column(name = "userImage")
    private String userimage;

    @Column(name = "userSignature")
    private String usersignature;

    private String content;

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
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * @param tag
     */
    public void setTag(String tag) {
        this.tag = tag;
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
     * @return sortId
     */
    public Integer getSortid() {
        return sortid;
    }

    /**
     * @param sortid
     */
    public void setSortid(Integer sortid) {
        this.sortid = sortid;
    }

    /**
     * @return replyCount
     */
    public Integer getReplycount() {
        return replycount;
    }

    /**
     * @param replycount
     */
    public void setReplycount(Integer replycount) {
        this.replycount = replycount;
    }

    /**
     * @return followCount
     */
    public Integer getFollowcount() {
        return followcount;
    }

    /**
     * @param followcount
     */
    public void setFollowcount(Integer followcount) {
        this.followcount = followcount;
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
}
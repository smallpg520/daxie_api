package com.daxie.daxie_api.model;

import javax.persistence.*;

public class Comments {
    @Id
    @Column(name = "commentId")
    private Integer commentid;

    private String comment;

    @Column(name = "userId")
    private String userid;

    @Column(name = "forId")
    private String forid;

    @Column(name = "createTime")
    private String createtime;

    @Column(name = "userName")
    private String username;

    @Column(name = "userImage")
    private String userimage;

    @Column(name = "userSignature")
    private String usersignature;

    @Column(name = "likeCount")
    private Integer likecount;

    @Column(name = "likeId")
    private String likeid;

    /**
     * @return commentId
     */
    public Integer getCommentid() {
        return commentid;
    }

    /**
     * @param commentid
     */
    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    /**
     * @return comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
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
     * @return forId
     */
    public String getForid() {
        return forid;
    }

    /**
     * @param forid
     */
    public void setForid(String forid) {
        this.forid = forid;
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
     * @return likeId
     */
    public String getLikeid() {
        return likeid;
    }

    /**
     * @param likeid
     */
    public void setLikeid(String likeid) {
        this.likeid = likeid;
    }
}
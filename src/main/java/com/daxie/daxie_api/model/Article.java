package com.daxie.daxie_api.model;

import javax.persistence.*;

public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "articleId")
    private String articleid;

    private String title;

    @Column(name = "userId")
    private String userid;

    @Column(name = "readCount")
    private Integer readcount;

    private Integer incognito;

    private String tag;

    @Column(name = "sortId")
    private String sortid;

    @Column(name = "createTime")
    private String createtime;

    @Column(name = "updateTime")
    private String updatetime;

    @Column(name = "likeCount")
    private Integer likecount;

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
     * @return articleId
     */
    public String getArticleid() {
        return articleid;
    }

    /**
     * @param articleid
     */
    public void setArticleid(String articleid) {
        this.articleid = articleid;
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
     * @return readCount
     */
    public Integer getReadcount() {
        return readcount;
    }

    /**
     * @param readcount
     */
    public void setReadcount(Integer readcount) {
        this.readcount = readcount;
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
     * @return sortId
     */
    public String getSortid() {
        return sortid;
    }

    /**
     * @param sortid
     */
    public void setSortid(String sortid) {
        this.sortid = sortid;
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
     * @return updateTime
     */
    public String getUpdatetime() {
        return updatetime;
    }

    /**
     * @param updatetime
     */
    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
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
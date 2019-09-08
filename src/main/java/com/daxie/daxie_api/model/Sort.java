package com.daxie.daxie_api.model;

import javax.persistence.*;

public class Sort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sortId")
    private Integer sortid;

    @Column(name = "sortName")
    private String sortname;

    @Column(name = "createDate")
    private String createdate;

    @Column(name = "createForUser")
    private String createforuser;

    @Column(name = "boardUserId")
    private String boarduserid;

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
     * @return sortName
     */
    public String getSortname() {
        return sortname;
    }

    /**
     * @param sortname
     */
    public void setSortname(String sortname) {
        this.sortname = sortname;
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
     * @return createForUser
     */
    public String getCreateforuser() {
        return createforuser;
    }

    /**
     * @param createforuser
     */
    public void setCreateforuser(String createforuser) {
        this.createforuser = createforuser;
    }

    /**
     * @return boardUserId
     */
    public String getBoarduserid() {
        return boarduserid;
    }

    /**
     * @param boarduserid
     */
    public void setBoarduserid(String boarduserid) {
        this.boarduserid = boarduserid;
    }
}
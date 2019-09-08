package com.daxie.daxie_api.model;

import javax.persistence.*;
import java.util.List;

public class Category {
    /**
     * 商品id，确定唯一的商品
     */
    @Id
    private Integer categoryid;

    /**
     * 确定商品的种类：1.女装，2.男装，3.美妆护肤，4.家居百货，5.食品，6.箱包
     */
    private String categorykind;

    /**
     * 是否热门：1是热门，0平常的商品
     */
    private Integer categoryhot;

    /**
     * 商品价格
     */
    private Integer categoryprice;

    /**
     * 商品的名字
     */
    private String categoryname;

    /**
     * 商品的图片
     */
    private String categorypicture;

    private Integer categorysatus;

    private Integer categoryliren;

    private Integer categorysales;

    /**
     * 商品的详情
     */
    private String categorydetails;

    /**
     * 获取商品id，确定唯一的商品
     *
     * @return categoryid - 商品id，确定唯一的商品
     */
    public Integer getCategoryid() {
        return categoryid;
    }

    /**
     * 设置商品id，确定唯一的商品
     *
     * @param categoryid 商品id，确定唯一的商品
     */
    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    /**
     * 获取确定商品的种类：1.女装，2.男装，3.美妆护肤，4.家居百货，5.食品，6.箱包
     *
     * @return categorykind - 确定商品的种类：1.女装，2.男装，3.美妆护肤，4.家居百货，5.食品，6.箱包
     */
    public String getCategorykind() {
        return categorykind;
    }

    /**
     * 设置确定商品的种类：1.女装，2.男装，3.美妆护肤，4.家居百货，5.食品，6.箱包
     *
     * @param categorykind 确定商品的种类：1.女装，2.男装，3.美妆护肤，4.家居百货，5.食品，6.箱包
     */
    public void setCategorykind(String categorykind) {
        this.categorykind = categorykind;
    }

    /**
     * 获取是否热门：1是热门，0平常的商品
     *
     * @return categoryhot - 是否热门：1是热门，0平常的商品
     */
    public Integer getCategoryhot() {
        return categoryhot;
    }

    /**
     * 设置是否热门：1是热门，0平常的商品
     *
     * @param categoryhot 是否热门：1是热门，0平常的商品
     */
    public void setCategoryhot(Integer categoryhot) {
        this.categoryhot = categoryhot;
    }

    /**
     * 获取商品价格
     *
     * @return categoryprice - 商品价格
     */
    public Integer getCategoryprice() {
        return categoryprice;
    }

    /**
     * 设置商品价格
     *
     * @param categoryprice 商品价格
     */
    public void setCategoryprice(Integer categoryprice) {
        this.categoryprice = categoryprice;
    }

    /**
     * 获取商品的名字
     *
     * @return categoryname - 商品的名字
     */
    public String getCategoryname() {
        return categoryname;
    }

    /**
     * 设置商品的名字
     *
     * @param categoryname 商品的名字
     */
    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    /**
     * 获取商品的图片
     *
     * @return categorypicture - 商品的图片
     */
    public String getCategorypicture() {
        return categorypicture;
    }

    /**
     * 设置商品的图片
     *
     * @param categorypicture 商品的图片
     */
    public void setCategorypicture(String categorypicture) {
        this.categorypicture = categorypicture;
    }

    /**
     * @return categorysatus
     */
    public Integer getCategorysatus() {
        return categorysatus;
    }

    /**
     * @param categorysatus
     */
    public void setCategorysatus(Integer categorysatus) {
        this.categorysatus = categorysatus;
    }

    /**
     * @return categoryliren
     */
    public Integer getCategoryliren() {
        return categoryliren;
    }

    /**
     * @param categoryliren
     */
    public void setCategoryliren(Integer categoryliren) {
        this.categoryliren = categoryliren;
    }

    /**
     * @return categorysales
     */
    public Integer getCategorysales() {
        return categorysales;
    }

    /**
     * @param categorysales
     */
    public void setCategorysales(Integer categorysales) {
        this.categorysales = categorysales;
    }

    /**
     * 获取商品的详情
     *
     * @return categorydetails - 商品的详情
     */
    public String getCategorydetails() {
        return categorydetails;
    }

    /**
     * 设置商品的详情
     *
     * @param categorydetails 商品的详情
     */
    public void setCategorydetails(String categorydetails) {
        this.categorydetails = categorydetails;
    }
}
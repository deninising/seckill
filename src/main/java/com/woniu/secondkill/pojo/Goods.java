package com.woniu.secondkill.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Goods implements Serializable {
    private Integer goodsId;

    private String title;

    private String subTitle;

    private Float originalCost;

    private Float currentPrice;

    private Float discount;

    private Integer isFreeDelivery;

    private Integer categoryId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdateTime;

    private String picUrl;

    private List<Evaluate> evaluates;

    private List<GoodsCover> covers;

    private List<GoodsDetail> details;

    private List<GoodsParam> params;

    public List<Evaluate> getEvaluates() {
        return evaluates;
    }

    public void setEvaluates(List<Evaluate> evaluates) {
        this.evaluates = evaluates;
    }

    public List<GoodsCover> getCovers() {
        return covers;
    }

    public void setCovers(List<GoodsCover> covers) {
        this.covers = covers;
    }

    public List<GoodsDetail> getDetails() {
        return details;
    }

    public void setDetails(List<GoodsDetail> details) {
        this.details = details;
    }

    public List<GoodsParam> getParams() {
        return params;
    }

    public void setParams(List<GoodsParam> params) {
        this.params = params;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Float getOriginalCost() {
        return originalCost;
    }

    public void setOriginalCost(Float originalCost) {
        this.originalCost = originalCost;
    }

    public Float getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Float currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Integer getIsFreeDelivery() {
        return isFreeDelivery;
    }

    public void setIsFreeDelivery(Integer isFreeDelivery) {
        this.isFreeDelivery = isFreeDelivery;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", originalCost=" + originalCost +
                ", currentPrice=" + currentPrice +
                ", discount=" + discount +
                ", isFreeDelivery=" + isFreeDelivery +
                ", categoryId=" + categoryId +
                ", lastUpdateTime=" + lastUpdateTime +
                ", picUrl='" + picUrl + '\'' +
                ", evaluates=" + evaluates +
                ", covers=" + covers +
                ", details=" + details +
                ", params=" + params +
                '}';
    }
}
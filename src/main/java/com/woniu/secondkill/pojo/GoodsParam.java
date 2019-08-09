package com.woniu.secondkill.pojo;

public class GoodsParam {
    private Integer gpId;

    private String gpParamName;

    private String gpParamValue;

    private Integer goodsId;

    private Integer gpOrder;

    public Integer getGpId() {
        return gpId;
    }

    public void setGpId(Integer gpId) {
        this.gpId = gpId;
    }

    public String getGpParamName() {
        return gpParamName;
    }

    public void setGpParamName(String gpParamName) {
        this.gpParamName = gpParamName;
    }

    public String getGpParamValue() {
        return gpParamValue;
    }

    public void setGpParamValue(String gpParamValue) {
        this.gpParamValue = gpParamValue;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGpOrder() {
        return gpOrder;
    }

    public void setGpOrder(Integer gpOrder) {
        this.gpOrder = gpOrder;
    }

    @Override
    public String toString() {
        return "GoodsParam{" +
                "gpId=" + gpId +
                ", gpParamName='" + gpParamName + '\'' +
                ", gpParamValue='" + gpParamValue + '\'' +
                ", goodsId=" + goodsId +
                ", gpOrder=" + gpOrder +
                '}';
    }
}
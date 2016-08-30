package com.qtz.ht.order.spi.rpt.trade.page;

import java.io.Serializable;

import com.qtz.base.common.Pager;
import com.qtz.ht.order.spi.rpt.trade.vo.RptUwPersonalrunsubflow;

/**
 * Title:RptUwPersonalrunsubflowPage<br/>
 * Description:(报表专用个人分润表Page分页类)<br/>
 * Copyright: Copyright © 2016<br/>
 * Company: 深圳市擎天柱信息技术有限公司<br/>
 * @author 甘佳-jackgrays@matrix.com
 * @version v1.0 2016-04-28
 */
public class RptUwPersonalrunsubflowPage extends Pager<RptUwPersonalrunsubflow,Long> implements Serializable {

    /**(序列化UID)*/
    private static final long serialVersionUID = -5621835812776165106L;
    /**(主键ID)*/
    private Long dmId;
    /**(用户ID)*/
    private Long userId;
    /**(订单ID)*/
    private String saleOrdersId;
    /**(分润金额)*/
    private Double amount;
    /**(状态(0：表示对账中，1：表示已入账))*/
    private Integer status;
    /**(创建时间)*/
    private Long createOn;
    /**()*/
    private java.util.Date statisticsDate;

    public Long getDmId(){
        return this.dmId;
    }
    public void setDmId(Long dmId){
        this.dmId = dmId;
    }
    public Long getUserId(){
        return this.userId;
    }
    public void setUserId(Long userId){
        this.userId = userId;
    }
    public String getSaleOrdersId(){
        return this.saleOrdersId;
    }
    public void setSaleOrdersId(String saleOrdersId){
        this.saleOrdersId = saleOrdersId;
    }
    public Double getAmount(){
        return this.amount;
    }
    public void setAmount(Double amount){
        this.amount = amount;
    }
    public Integer getStatus(){
        return this.status;
    }
    public void setStatus(Integer status){
        this.status = status;
    }
    public Long getCreateOn(){
        return this.createOn;
    }
    public void setCreateOn(Long createOn){
        this.createOn = createOn;
    }
    public java.util.Date getStatisticsDate(){
        return this.statisticsDate;
    }
    public void setStatisticsDate(java.util.Date statisticsDate){
        this.statisticsDate = statisticsDate;
    }

    @Override
    public String toString() {
        return "RptUwPersonalrunsubflowPage[" +
        "dmId=" + dmId +
        ",userId=" + userId +
        ",saleOrdersId=" + saleOrdersId +
        ",amount=" + amount +
        ",status=" + status +
        ",createOn=" + createOn +
        ",statisticsDate=" + statisticsDate +
        ']';
    }

}

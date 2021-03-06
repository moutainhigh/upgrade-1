package com.qtz.ht.order.spi.rpt.trade.page;

import java.io.Serializable;

import com.qtz.base.common.Pager;
import com.qtz.ht.order.spi.rpt.trade.vo.RptUwPaymentflow;

/**
 * Title:RptUwPaymentflowPage<br/>
 * Description:(报表专用商家货款表Page分页类)<br/>
 * Copyright: Copyright © 2016<br/>
 * Company: 深圳市擎天柱信息技术有限公司<br/>
 * @author 甘佳-jackgrays@matrix.com
 * @version v1.0 2016-04-28
 */
public class RptUwPaymentflowPage extends Pager<RptUwPaymentflow,Long> implements Serializable {

    /**(序列化UID)*/
    private static final long serialVersionUID = -7455727247872603328L;
    /**(主键ID)*/
    private Long dmId;
    /**(订单ID)*/
    private Long saleOrdersId;
    /**(用户ID(商家))*/
    private Long userId;
    /**(货款金额)*/
    private Double amount;
    /**(状态(0：表示对账中，1：表示已入账))*/
    private Integer status;
    /**(创建时间)*/
    private Long createOn;
    /**(创建时间(日期类型))*/
    private java.util.Date statisticsDate;

    public Long getDmId(){
        return this.dmId;
    }
    public void setDmId(Long dmId){
        this.dmId = dmId;
    }
    public Long getSaleOrdersId(){
        return this.saleOrdersId;
    }
    public void setSaleOrdersId(Long saleOrdersId){
        this.saleOrdersId = saleOrdersId;
    }
    public Long getUserId(){
        return this.userId;
    }
    public void setUserId(Long userId){
        this.userId = userId;
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
        return "RptUwPaymentflowPage[" +
        "dmId=" + dmId +
        ",saleOrdersId=" + saleOrdersId +
        ",userId=" + userId +
        ",amount=" + amount +
        ",status=" + status +
        ",createOn=" + createOn +
        ",statisticsDate=" + statisticsDate +
        ']';
    }

}

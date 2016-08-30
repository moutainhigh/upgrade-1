package com.qtz.ht.order.spi.rpt.user.vo;

import java.io.Serializable;

import com.qtz.base.dto.VO;

/**
 * Title:RptUserMore<br/>
 * Description:(用户分润统计表(多)VO实体类)<br/>
 * Copyright: Copyright (c) 2016<br/>
 * Company: 深圳市擎天柱信息科技有限公司<br/>
 * @author  甘佳 jackgrays@matrix.com
 * @version v1.0 2016-03-11
 */
public class RptUserMore extends VO<Long> implements Serializable {

	/**(序列化UID)*/
	private static final long serialVersionUID = 7035301379447539648L;
    /**()*/
	private Long dmId;
    /**(统计类型0天,1周,2月,3年)*/
	private Integer statType;
    /**(统计时间，当期开始时间)*/
	private Long statTime;
    /**(用户ID)*/
	private Long userId;
    /**(订单数量)*/
	private Integer orderNum;
    /**(订单总额)*/
	private Double orderTotalAmount;
    /**(用户总分润)*/
	private Double userTotalProfit;

	public Long getDmId(){
		return this.dmId;
	}
	public void setDmId(Long dmId){
		this.dmId = dmId;
	}
	public Integer getStatType(){
		return this.statType;
	}
	public void setStatType(Integer statType){
		this.statType = statType;
	}
	public Long getStatTime(){
		return this.statTime;
	}
	public void setStatTime(Long statTime){
		this.statTime = statTime;
	}
	public Long getUserId(){
		return this.userId;
	}
	public void setUserId(Long userId){
		this.userId = userId;
	}
	public Integer getOrderNum(){
		return this.orderNum;
	}
	public void setOrderNum(Integer orderNum){
		this.orderNum = orderNum;
	}
	public Double getOrderTotalAmount(){
		return this.orderTotalAmount;
	}
	public void setOrderTotalAmount(Double orderTotalAmount){
		this.orderTotalAmount = orderTotalAmount;
	}
	public Double getUserTotalProfit(){
		return this.userTotalProfit;
	}
	public void setUserTotalProfit(Double userTotalProfit){
		this.userTotalProfit = userTotalProfit;
	}

	@Override
	public String toString() {
		return "RptUserMore[" +
		"dmId=" + dmId +
		",statType=" + statType +
		",statTime=" + statTime +
		",userId=" + userId +
		",orderNum=" + orderNum +
		",orderTotalAmount=" + orderTotalAmount +
		",userTotalProfit=" + userTotalProfit +
		']';
	}

}

package com.qtz.ht.order.spi.rpt.agent.vo;

import java.io.Serializable;

import com.qtz.base.dto.VO;

/**
 * Title:RptAgentMore<br/>
 * Description:(代理商分润统计表(多)VO实体类)<br/>
 * Copyright: Copyright (c) 2016<br/>
 * Company: 深圳市擎天柱信息科技有限公司<br/>
 * @author  甘佳 jackgrays@matrix.com
 * @version v1.0 2016-03-11
 */
public class RptAgentMore extends VO<Long> implements Serializable {

	/**(序列化UID)*/
	private static final long serialVersionUID = 4397597552662563114L;
    /**()*/
	private Long dmId;
    /**(统计类型0天,1周,2月,3年)*/
	private Integer statType;
    /**(统计时间，当期开始时间)*/
	private Long statTime;
	/**(县级区域ID)*/
	private Long countyId;
    /**(代理ID)*/
	private Long agentId;
    /**(订单数量)*/
	private Integer orderNum;
    /**(订单总额)*/
	private Double orderTotalAmount;
    /**(支付宝总付款额)*/
	private Double alipayTotalAmount;
    /**(微信总付款额)*/
	private Double wechatTotalAmount;
    /**(钱包总付款额)*/
	private Double walletTotalAmount;
    /**(代理总分润)*/
	private Double agentTotalProfit;

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
	public Long getCountyId() {
		return countyId;
	}
	public void setCountyId(Long countyId) {
		this.countyId = countyId;
	}
	public Long getAgentId(){
		return this.agentId;
	}
	public void setAgentId(Long agentId){
		this.agentId = agentId;
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
	public Double getAlipayTotalAmount(){
		return this.alipayTotalAmount;
	}
	public void setAlipayTotalAmount(Double alipayTotalAmount){
		this.alipayTotalAmount = alipayTotalAmount;
	}
	public Double getWechatTotalAmount(){
		return this.wechatTotalAmount;
	}
	public void setWechatTotalAmount(Double wechatTotalAmount){
		this.wechatTotalAmount = wechatTotalAmount;
	}
	public Double getWalletTotalAmount(){
		return this.walletTotalAmount;
	}
	public void setWalletTotalAmount(Double walletTotalAmount){
		this.walletTotalAmount = walletTotalAmount;
	}
	public Double getAgentTotalProfit(){
		return this.agentTotalProfit;
	}
	public void setAgentTotalProfit(Double agentTotalProfit){
		this.agentTotalProfit = agentTotalProfit;
	}

	@Override
	public String toString() {
		return "RptAgentMore[" +
		"dmId=" + dmId +
		",statType=" + statType +
		",statTime=" + statTime +
		",agentId=" + agentId +
		",agentId=" + agentId +
		",orderNum=" + orderNum +
		",orderTotalAmount=" + orderTotalAmount +
		",alipayTotalAmount=" + alipayTotalAmount +
		",wechatTotalAmount=" + wechatTotalAmount +
		",walletTotalAmount=" + walletTotalAmount +
		",agentTotalProfit=" + agentTotalProfit +
		']';
	}

}

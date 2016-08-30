package com.qtz.ht.order.spi.rpt.order.page;

import java.io.Serializable;

import com.qtz.base.common.Pager;
import com.qtz.ht.order.spi.rpt.order.vo.RptOrderMore;

/**
 * Title:RptOrderMorePage<br/>
 * Description:(订单统计表(多)Page分页类)<br/>
 * Copyright: Copyright (c) 2016<br/>
 * Company: 深圳市擎天柱信息科技有限公司<br/>
 * @author  甘佳 jackgrays@matrix.com
 * @version v1.0 2016-03-11
 */
public class RptOrderMorePage extends Pager<RptOrderMore,Long> implements Serializable {

	/**(序列化UID)*/
	private static final long serialVersionUID = 3113620466650595628L;
    /**()*/
	private Long dmId;
    /**(统计类型0天,1周,2月,3年)*/
	private Integer statType;
    /**(统计时间，当期开始时间)*/
	private Long statTime;
    /**(订单数量)*/
	private Integer orderNum;
    /**(订单总额)*/
	private Double orderTotalAmount;
    /**(商家总净收入额)*/
	private Double sellerTotalAmount;
    /**(支付宝总付款额)*/
	private Double alipayTotalAmount;
    /**(微信总付款额)*/
	private Double wechatTotalAmount;
    /**(钱包总付款额)*/
	private Double walletTotalAmount;
    /**(当期扣点总额)*/
	private Double deductTotalAmount;
    /**(代理总分润)*/
	private Double agentTotalProfit;
    /**(一级用户总分润)*/
	private Double firstUserTotalProfit;
    /**(二级用户总分润)*/
	private Double secondUserTotalProfit;
    /**(三级用户总分润)*/
	private Double thirdUserTotalProfit;
    /**(平台总收入额)*/
	private Double platformTotalAmount;
    /**(总赠送金币)*/
	private Integer goldTotalGive;
    /**(总返现金币)*/
	private Integer goldTotalBack;

	private java.lang.Long startTime;
	private java.lang.Long endTime;

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
	public Double getSellerTotalAmount(){
		return this.sellerTotalAmount;
	}
	public void setSellerTotalAmount(Double sellerTotalAmount){
		this.sellerTotalAmount = sellerTotalAmount;
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
	public Double getDeductTotalAmount(){
		return this.deductTotalAmount;
	}
	public void setDeductTotalAmount(Double deductTotalAmount){
		this.deductTotalAmount = deductTotalAmount;
	}
	public Double getAgentTotalProfit(){
		return this.agentTotalProfit;
	}
	public void setAgentTotalProfit(Double agentTotalProfit){
		this.agentTotalProfit = agentTotalProfit;
	}
	public Double getFirstUserTotalProfit(){
		return this.firstUserTotalProfit;
	}
	public void setFirstUserTotalProfit(Double firstUserTotalProfit){
		this.firstUserTotalProfit = firstUserTotalProfit;
	}
	public Double getSecondUserTotalProfit(){
		return this.secondUserTotalProfit;
	}
	public void setSecondUserTotalProfit(Double secondUserTotalProfit){
		this.secondUserTotalProfit = secondUserTotalProfit;
	}
	public Double getThirdUserTotalProfit(){
		return this.thirdUserTotalProfit;
	}
	public void setThirdUserTotalProfit(Double thirdUserTotalProfit){
		this.thirdUserTotalProfit = thirdUserTotalProfit;
	}
	public Double getPlatformTotalAmount(){
		return this.platformTotalAmount;
	}
	public void setPlatformTotalAmount(Double platformTotalAmount){
		this.platformTotalAmount = platformTotalAmount;
	}
	public Integer getGoldTotalGive(){
		return this.goldTotalGive;
	}
	public void setGoldTotalGive(Integer goldTotalGive){
		this.goldTotalGive = goldTotalGive;
	}
	public Integer getGoldTotalBack(){
		return this.goldTotalBack;
	}
	public void setGoldTotalBack(Integer goldTotalBack){
		this.goldTotalBack = goldTotalBack;
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Long getEndTime() {
		return endTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "RptOrderMorePage[" +
		"dmId=" + dmId +
		",statType=" + statType +
		",statTime=" + statTime +
		",orderNum=" + orderNum +
		",orderTotalAmount=" + orderTotalAmount +
		",sellerTotalAmount=" + sellerTotalAmount +
		",alipayTotalAmount=" + alipayTotalAmount +
		",wechatTotalAmount=" + wechatTotalAmount +
		",walletTotalAmount=" + walletTotalAmount +
		",deductTotalAmount=" + deductTotalAmount +
		",agentTotalProfit=" + agentTotalProfit +
		",firstUserTotalProfit=" + firstUserTotalProfit +
		",secondUserTotalProfit=" + secondUserTotalProfit +
		",thirdUserTotalProfit=" + thirdUserTotalProfit +
		",platformTotalAmount=" + platformTotalAmount +
		",goldTotalGive=" + goldTotalGive +
		",goldTotalBack=" + goldTotalBack +
		']';
	}

}

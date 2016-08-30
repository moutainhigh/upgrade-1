package com.qtz.ht.order.spi.rpt.trade.vo;

import java.io.Serializable;

import com.qtz.base.dto.VO;

/**
 * Title:RptTradeFlow<br/>
 * Description:(订单交易明细表VO实体类)<br/>
 * Copyright: Copyright (c) 2016<br/>
 * Company: 深圳市擎天柱信息科技有限公司<br/>
 * @author  甘佳 jackgrays@matrix.com
 * @version v1.0 2016-03-14
 */
public class RptTradeFlow extends VO<Long> implements Serializable {

	/**(序列化UID)*/
	private static final long serialVersionUID = 1215466807057991244L;
    /**()*/
	private Long dmId;
    /**(购买用户ID)*/
	private Long userId;
    /**(支付时间)*/
	private Long payTime;
    /**(1 支付宝 2微信 3钱包支付)*/
	private Integer payType;
    /**(商家ID)*/
	private Long sellerId;
    /**(商家净收入额)*/
	private Double sellerAmount;
    /**(完结时间)*/
	private Long finishTime;
    /**(订单ID)*/
	private Long orderId;
    /**(订单总额)*/
	private Double orderAmount;
    /**(扣点总额)*/
	private Double deductAmount;
	/**(县级区域ID)*/
	private Long countyId;
    /**(分润时间)*/
	private Long profitTime;
    /**(代理ID)*/
	private Long agentId;
    /**(代理分润)*/
	private Double agentProfit;
    /**(一级用户ID)*/
	private Long firstUserId;
    /**(一级用户分润)*/
	private Double firstUserProfit;
    /**(二级用户ID)*/
	private Long secondUserId;
    /**(二级用户分润)*/
	private Double secondUserProfit;
    /**(三级用户ID)*/
	private Long thirdUserId;
    /**(三级用户分润)*/
	private Double thirdUserProfit;
    /**(平台收入)*/
	private Double platformAmount;
    /**(赠送金币)*/
	private Integer goldGive;
    /**(返现金币)*/
	private Integer goldBack;
    /**(完结状态:0交易成功;1,交易失败;2,待处理)*/
	private Integer okStatus;

	public enum OkStatus{
		SUCCESS(0),
		FAILURE(1),
		PENDING(2);
		private int id;
		OkStatus(int id){
			this.id = id;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return "OkStatus{" +
					"id=" + id +
					'}';
		}
	}

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
	public Long getPayTime(){
		return this.payTime;
	}
	public void setPayTime(Long payTime){
		this.payTime = payTime;
	}
	public Integer getPayType(){
		return this.payType;
	}
	public void setPayType(Integer payType){
		this.payType = payType;
	}
	public Long getSellerId(){
		return this.sellerId;
	}
	public void setSellerId(Long sellerId){
		this.sellerId = sellerId;
	}
	public Double getSellerAmount(){
		return this.sellerAmount;
	}
	public void setSellerAmount(Double sellerAmount){
		this.sellerAmount = sellerAmount;
	}
	public Long getFinishTime(){
		return this.finishTime;
	}
	public void setFinishTime(Long finishTime){
		this.finishTime = finishTime;
	}
	public Long getOrderId(){
		return this.orderId;
	}
	public void setOrderId(Long orderId){
		this.orderId = orderId;
	}
	public Double getOrderAmount(){
		return this.orderAmount;
	}
	public void setOrderAmount(Double orderAmount){
		this.orderAmount = orderAmount;
	}
	public Double getDeductAmount(){
		return this.deductAmount;
	}
	public void setDeductAmount(Double deductAmount){
		this.deductAmount = deductAmount;
	}
	public Long getProfitTime(){
		return this.profitTime;
	}
	public void setProfitTime(Long profitTime){
		this.profitTime = profitTime;
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
	public Double getAgentProfit(){
		return this.agentProfit;
	}
	public void setAgentProfit(Double agentProfit){
		this.agentProfit = agentProfit;
	}
	public Long getFirstUserId(){
		return this.firstUserId;
	}
	public void setFirstUserId(Long firstUserId){
		this.firstUserId = firstUserId;
	}
	public Double getFirstUserProfit(){
		return this.firstUserProfit;
	}
	public void setFirstUserProfit(Double firstUserProfit){
		this.firstUserProfit = firstUserProfit;
	}
	public Long getSecondUserId(){
		return this.secondUserId;
	}
	public void setSecondUserId(Long secondUserId){
		this.secondUserId = secondUserId;
	}
	public Double getSecondUserProfit(){
		return this.secondUserProfit;
	}
	public void setSecondUserProfit(Double secondUserProfit){
		this.secondUserProfit = secondUserProfit;
	}
	public Long getThirdUserId(){
		return this.thirdUserId;
	}
	public void setThirdUserId(Long thirdUserId){
		this.thirdUserId = thirdUserId;
	}
	public Double getThirdUserProfit(){
		return this.thirdUserProfit;
	}
	public void setThirdUserProfit(Double thirdUserProfit){
		this.thirdUserProfit = thirdUserProfit;
	}
	public Double getPlatformAmount(){
		return this.platformAmount;
	}
	public void setPlatformAmount(Double platformAmount){
		this.platformAmount = platformAmount;
	}
	public Integer getGoldGive(){
		return this.goldGive;
	}
	public void setGoldGive(Integer goldGive){
		this.goldGive = goldGive;
	}
	public Integer getGoldBack(){
		return this.goldBack;
	}
	public void setGoldBack(Integer goldBack){
		this.goldBack = goldBack;
	}
	public Integer getOkStatus(){
		return this.okStatus;
	}
	public void setOkStatus(Integer okStatus){
		this.okStatus = okStatus;
	}

	@Override
	public String toString() {
		return "RptTradeFlow[" +
		"dmId=" + dmId +
		",userId=" + userId +
		",payTime=" + payTime +
		",payType=" + payType +
		",sellerId=" + sellerId +
		",sellerAmount=" + sellerAmount +
		",finishTime=" + finishTime +
		",orderId=" + orderId +
		",orderAmount=" + orderAmount +
		",deductAmount=" + deductAmount +
		",profitTime=" + profitTime +
		",countyId=" + countyId +
		",agentId=" + agentId +
		",agentProfit=" + agentProfit +
		",firstUserId=" + firstUserId +
		",firstUserProfit=" + firstUserProfit +
		",secondUserId=" + secondUserId +
		",secondUserProfit=" + secondUserProfit +
		",thirdUserId=" + thirdUserId +
		",thirdUserProfit=" + thirdUserProfit +
		",platformAmount=" + platformAmount +
		",goldGive=" + goldGive +
		",goldBack=" + goldBack +
		",okStatus=" + okStatus +
		']';
	}

}

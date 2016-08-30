package com.qtz.ht.order.spi.order.count.page;

import com.alibaba.fastjson.JSON;
import com.qtz.base.common.Pager;

/**
 * <p>
 * Title:OrderCountPage
 * </p>
 * <p>
 * Description:订单统计分页类
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: 深圳市擎天柱信息科技有限公司
 * </p>
 * 
 * @author 涂鑫 -xin.tu
 * @version v1.0 2015-12-10
 */
public class OrderCountPage extends
		Pager<com.qtz.ht.order.spi.order.count.vo.OrderCount, java.lang.Long> implements
		java.io.Serializable {

	/** 类的版本号 */
	private static final long serialVersionUID = 1441510664128513L;

	/**  */
	private java.lang.Long dmId;
	/** 订单id */
	private java.lang.Long orderId;
	/** 商家id */
	private java.lang.Long sellerId;
	/** 购买用户 */
	private java.lang.Long userId;
	/** 订单价格 */
	private java.lang.Double orderPrice;
	/** 扣点比例 */
	private java.lang.Double scale;
	/** 一级用户id */
	private java.lang.Long oneUserId;
	/** 二级用户id */
	private java.lang.Long twoUserId;
	/** 三级用户id */
	private java.lang.Long threeUserId;
	/** 一级用户分润 */
	private java.lang.Double oneUserProfit;
	/** 二级用户分润 */
	private java.lang.Double twoUserProfit;
	/** 三级用户分润 */
	private java.lang.Double threeUserProfit;
	/** 省区域分润 */
	private java.lang.Double provinceProfit;
	/** 市区域分润 */
	private java.lang.Double marketProfit;
	/** 省区域代理id */
	private java.lang.Long proviceRegionId;
	/** 市区域代理id */
	private java.lang.Long marketRegionId;
	/** 余额 */
	private java.lang.Double balance;
	/** 金币赠送 */
	private java.lang.Integer goldGiving;
	/** 金币返现 */
	private java.lang.Integer goldBack;
	/** 支付方式 */
	private java.lang.Integer payType;
	/**
	 * 付款成功时间
	 */
	private java.lang.Long chargeTime;
	/**
	 * 代理商id
	 */
	private java.lang.Long agentId;

	private java.lang.Long startTime;

	private java.lang.Long endTime;
	
	/**
	 * 扣点金额
	 */
	private java.lang.Double scalePrice;

	/**
	 * 起始金币数
	 */
	private java.lang.Integer originGold;
	
	public java.lang.Long getChargeTime() {
		return chargeTime;
	}

	public void setChargeTime(java.lang.Long chargeTime) {
		this.chargeTime = chargeTime;
	}

	/**
	 * 时间
	 */
	private java.lang.Long crtime;

	public java.lang.Long getDmId() {
		return this.dmId;
	}

	public void setDmId(java.lang.Long dmId) {
		this.dmId = dmId;
	}

	public java.lang.Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(java.lang.Long orderId) {
		this.orderId = orderId;
	}

	public java.lang.Long getSellerId() {
		return this.sellerId;
	}

	public void setSellerId(java.lang.Long sellerId) {
		this.sellerId = sellerId;
	}

	public java.lang.Long getUserId() {
		return this.userId;
	}

	public void setUserId(java.lang.Long userId) {
		this.userId = userId;
	}

	public java.lang.Double getOrderPrice() {
		return this.orderPrice;
	}

	public void setOrderPrice(java.lang.Double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public java.lang.Long getOneUserId() {
		return this.oneUserId;
	}

	public void setOneUserId(java.lang.Long oneUserId) {
		this.oneUserId = oneUserId;
	}

	public java.lang.Long getTwoUserId() {
		return this.twoUserId;
	}

	public void setTwoUserId(java.lang.Long twoUserId) {
		this.twoUserId = twoUserId;
	}

	public java.lang.Long getThreeUserId() {
		return this.threeUserId;
	}

	public void setThreeUserId(java.lang.Long threeUserId) {
		this.threeUserId = threeUserId;
	}

	public java.lang.Double getOneUserProfit() {
		return this.oneUserProfit;
	}

	public void setOneUserProfit(java.lang.Double oneUserProfit) {
		this.oneUserProfit = oneUserProfit;
	}

	public java.lang.Double getTwoUserProfit() {
		return this.twoUserProfit;
	}

	public void setTwoUserProfit(java.lang.Double twoUserProfit) {
		this.twoUserProfit = twoUserProfit;
	}

	public java.lang.Double getThreeUserProfit() {
		return this.threeUserProfit;
	}

	public void setThreeUserProfit(java.lang.Double threeUserProfit) {
		this.threeUserProfit = threeUserProfit;
	}

	public java.lang.Double getProvinceProfit() {
		return this.provinceProfit;
	}

	public void setProvinceProfit(java.lang.Double provinceProfit) {
		this.provinceProfit = provinceProfit;
	}

	public java.lang.Double getMarketProfit() {
		return this.marketProfit;
	}

	public void setMarketProfit(java.lang.Double marketProfit) {
		this.marketProfit = marketProfit;
	}

	public java.lang.Long getProviceRegionId() {
		return this.proviceRegionId;
	}

	public void setProviceRegionId(java.lang.Long proviceRegionId) {
		this.proviceRegionId = proviceRegionId;
	}

	public java.lang.Long getMarketRegionId() {
		return this.marketRegionId;
	}

	public void setMarketRegionId(java.lang.Long marketRegionId) {
		this.marketRegionId = marketRegionId;
	}

	public java.lang.Double getBalance() {
		return this.balance;
	}

	public void setBalance(java.lang.Double balance) {
		this.balance = balance;
	}

	public java.lang.Integer getGoldBack() {
		return this.goldBack;
	}

	public void setGoldBack(java.lang.Integer goldBack) {
		this.goldBack = goldBack;
	}

	public java.lang.Integer getPayType() {
		return this.payType;
	}

	public void setPayType(java.lang.Integer payType) {
		this.payType = payType;
	}

	public java.lang.Double getScale() {
		return scale;
	}

	public void setScale(java.lang.Double scale) {
		this.scale = scale;
	}

	public java.lang.Integer getGoldGiving() {
		return goldGiving;
	}

	public void setGoldGiving(java.lang.Integer goldGiving) {
		this.goldGiving = goldGiving;
	}

	public java.lang.Long getAgentId() {
		return agentId;
	}

	public void setAgentId(java.lang.Long agentId) {
		this.agentId = agentId;
	}

	public java.lang.Long getCrtime() {
		return crtime;
	}

	public void setCrtime(java.lang.Long crtime) {
		this.crtime = crtime;
	}

	public java.lang.Long getStartTime() {
		return startTime;
	}

	public void setStartTime(java.lang.Long startTime) {
		this.startTime = startTime;
	}

	public java.lang.Long getEndTime() {
		return endTime;
	}

	public void setEndTime(java.lang.Long endTime) {
		this.endTime = endTime;
	}
	
	public java.lang.Double getScalePrice() {
		return scalePrice;
	}

	public void setScalePrice(java.lang.Double scalePrice) {
		this.scalePrice = scalePrice;
	}

	public java.lang.Integer getOriginGold() {
		return originGold;
	}

	public void setOriginGold(java.lang.Integer originGold) {
		this.originGold = originGold;
	}

	public String toString() {
		return JSON.toJSONString(this);
	}
}
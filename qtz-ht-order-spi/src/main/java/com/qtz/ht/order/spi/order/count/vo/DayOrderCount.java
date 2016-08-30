package com.qtz.ht.order.spi.order.count.vo;

import com.alibaba.fastjson.JSON;

public class DayOrderCount implements java.io.Serializable{
	
	/**()*/
	private static final long serialVersionUID = 1L;

	private Double totalOrderPrice;
	
	private Integer orderNum;
	
	private Double aliPayPrice;
	
	private Double wechatPayPrice;
	
	private Double walletPayPrice;
	
	private Double totalScale;
	
	private Double totalOneUserProfit;
	
	private Double totalTwoUserProfit;
	
	private Double totalThreeUserProfit;
	
	private Double totalProvinceProfit;
	
	private Double totalMarketProfit;
	
	private Double totalBalance;
	
	private Double totalGoldBack;
	
	private Double totalGoldGiving;
	
	private Long crtime;

	public Double getTotalOrderPrice() {
		return totalOrderPrice;
	}

	public void setTotalOrderPrice(Double totalOrderPrice) {
		this.totalOrderPrice = totalOrderPrice;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Double getAliPayPrice() {
		return aliPayPrice;
	}

	public void setAliPayPrice(Double aliPayPrice) {
		this.aliPayPrice = aliPayPrice;
	}

	public Double getWechatPayPrice() {
		return wechatPayPrice;
	}

	public void setWechatPayPrice(Double wechatPayPrice) {
		this.wechatPayPrice = wechatPayPrice;
	}

	public Double getWalletPayPrice() {
		return walletPayPrice;
	}

	public void setWalletPayPrice(Double walletPayPrice) {
		this.walletPayPrice = walletPayPrice;
	}

	public Double getTotalScale() {
		return totalScale;
	}

	public void setTotalScale(Double totalScale) {
		this.totalScale = totalScale;
	}

	public Double getTotalOneUserProfit() {
		return totalOneUserProfit;
	}

	public void setTotalOneUserProfit(Double totalOneUserProfit) {
		this.totalOneUserProfit = totalOneUserProfit;
	}

	public Double getTotalTwoUserProfit() {
		return totalTwoUserProfit;
	}

	public void setTotalTwoUserProfit(Double totalTwoUserProfit) {
		this.totalTwoUserProfit = totalTwoUserProfit;
	}

	public Double getTotalThreeUserProfit() {
		return totalThreeUserProfit;
	}

	public void setTotalThreeUserProfit(Double totalThreeUserProfit) {
		this.totalThreeUserProfit = totalThreeUserProfit;
	}

	public Double getTotalProvinceProfit() {
		return totalProvinceProfit;
	}

	public void setTotalProvinceProfit(Double totalProvinceProfit) {
		this.totalProvinceProfit = totalProvinceProfit;
	}

	public Double getTotalMarketProfit() {
		return totalMarketProfit;
	}

	public void setTotalMarketProfit(Double totalMarketProfit) {
		this.totalMarketProfit = totalMarketProfit;
	}

	public Double getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(Double totalBalance) {
		this.totalBalance = totalBalance;
	}

	public Double getTotalGoldBack() {
		return totalGoldBack;
	}

	public void setTotalGoldBack(Double totalGoldBack) {
		this.totalGoldBack = totalGoldBack;
	}

	public Double getTotalGoldGiving() {
		return totalGoldGiving;
	}

	public void setTotalGoldGiving(Double totalGoldGiving) {
		this.totalGoldGiving = totalGoldGiving;
	}
	
	public Long getCrtime() {
		return crtime;
	}

	public void setCrtime(Long crtime) {
		this.crtime = crtime;
	}

	@Override
	public String toString(){
		return JSON.toJSONString(this);
	}
	
}

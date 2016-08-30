package com.qtz.ht.order.spi.order.model;

import java.io.Serializable;

public class PayHtOrderModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6183650687698860817L;

	/**
	 * 
	 * 商品数量
	 */
	private int goodsNum;
	/**
	 * 订单价格
	 */
	private Double payMoney;
	/**
	 * 商家ID
	 */
	private Long staffCode;
	/**
	 * 商家名称
	 */
	private String staffName;
	/**
	 * 会员
	 */
	private Long vipCode;
	/**
	 * 创建时间
	 */
	private Long crtime;
	
	private Integer status;
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public int getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}

	public Double getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(Double payMoney) {
		this.payMoney = payMoney;
	}

	public Long getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(Long staffCode) {
		this.staffCode = staffCode;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public Long getVipCode() {
		return vipCode;
	}

	public void setVipCode(Long vipCode) {
		this.vipCode = vipCode;
	}

	public Long getCrtime() {
		return crtime;
	}

	public void setCrtime(Long crtime) {
		this.crtime = crtime;
	}
	
	
	
}


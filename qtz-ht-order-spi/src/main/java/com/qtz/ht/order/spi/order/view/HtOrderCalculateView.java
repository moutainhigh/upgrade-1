package com.qtz.ht.order.spi.order.view;

import java.io.Serializable;

public class HtOrderCalculateView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5851130031135776628L;
	/**
	 * 订单价格
	 */
	private double orderPrice;
	/**
	 * 商品数量
	 */
	private int goodsNum;
	
	public double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	
	

}

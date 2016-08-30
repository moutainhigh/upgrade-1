package com.qtz.ht.order.spi.order.view;

import java.io.Serializable;

public class HtOrderGoodsPayView implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3714152040360661391L;
	/**
	 * 
	 * 商品Id
	 */
	private Long dmId;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 商品数量
	 */
	private int goodsNum;
	/**
	 * 商品价格
	 */
	private Double goodsPrice;
	/**
	 * 商品总价
	 */
	private Double goodsTotalPrice;

	public Long getDmId() {
		return dmId;
	}

	public void setDmId(Long dmId) {
		this.dmId = dmId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}

	public Double getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Double getGoodsTotalPrice() {
		return goodsTotalPrice;
	}

	public void setGoodsTotalPrice(Double goodsTotalPrice) {
		this.goodsTotalPrice = goodsTotalPrice;
	}

}

package com.qtz.ht.order.spi.order.view;

import java.io.Serializable;

public class HtOrderGoodsView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2212327530398104799L;
	/**
	 * 用于展示的商品图片
	 */
	private String mainPicture;

	/**
	 * 用于展示的商品 名称
	 */
	private String goodName;
	/**
	 * 商品数量
	 */
	private Integer goodNumber;
	/**
	 * 商品单价
	 */
	private double goodPrice;
	
	/**
	 * 商品规格
	 */
	private String goodSpec;
	
	public String getGoodSpec() {
		return goodSpec;
	}

	public void setGoodSpec(String goodSpec) {
		this.goodSpec = goodSpec;
	}

	public String getMainPicture() {
		return mainPicture;
	}

	public void setMainPicture(String mainPicture) {
		this.mainPicture = mainPicture;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public Integer getGoodNumber() {
		return goodNumber;
	}

	public void setGoodNumber(Integer goodNumber) {
		this.goodNumber = goodNumber;
	}

	public double getGoodPrice() {
		return goodPrice;
	}

	public void setGoodPrice(double goodPrice) {
		this.goodPrice = goodPrice;
	}

}

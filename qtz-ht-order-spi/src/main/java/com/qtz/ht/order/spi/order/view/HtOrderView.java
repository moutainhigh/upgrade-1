package com.qtz.ht.order.spi.order.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 海淘订单列表展示类
 * 
 * @author Administrator
 *
 */
public class HtOrderView implements Serializable {

	private static final long serialVersionUID = 7760288356740782951L;
	/**
	 * 订单号
	 */
	private Long dmId;
	/**
	 * 订单批量号
	 */
	private Long batchId;
	/**
	 * 订单状态
	 */
	private Integer status;
	/**
	 * 订单支付金额
	 */
	private Double payMoney;
	/**
	 * 订单总价:商品总价 
	 */
	private Double countMoney;
	/**
	 * 商品个数
	 */
	private int goodsNum;
	/**
	 * 收货人
	 */
	private String consignee;
	/**
	 * 手机
	 */
	private String mphoneNo;
	/**
	 * 下单时间
	 */
	private Long crtime;
	/**
	 * 支付方式
	 */
	private String paymentWay;
	/**
	 * 备注
	 */
	private String noteMan;
	/**
	 * 地址
	 */
	private String detailAddr;
	/**
	 * 快递公司
	 */
	private String express;
	/**
	 * 快递单号
	 */
	private String expressCode;
	/**
	 * 补贴名称
	 */
	private String constantName;
	/**
	 * 补贴金额
	 */
	private Double deductionPrice;
	
	private List<HtOrderGoodsView> htOrderGoodsList = new ArrayList<>();
	
	public String getExpress() {
		return express;
	}

	public String getConstantName() {
		return constantName;
	}



	public void setConstantName(String constantName) {
		this.constantName = constantName;
	}



	public Double getDeductionPrice() {
		return deductionPrice;
	}



	public void setDeductionPrice(Double deductionPrice) {
		this.deductionPrice = deductionPrice;
	}



	public void setExpress(String express) {
		this.express = express;
	}

	public String getExpressCode() {
		return expressCode;
	}

	public void setExpressCode(String expressCode) {
		this.expressCode = expressCode;
	}

	public String getDetailAddr() {
		return detailAddr;
	}

	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getMphoneNo() {
		return mphoneNo;
	}

	public void setMphoneNo(String mphoneNo) {
		this.mphoneNo = mphoneNo;
	}

	public Long getCrtime() {
		return crtime;
	}

	public void setCrtime(Long crtime) {
		this.crtime = crtime;
	}

	public String getPaymentWay() {
		return paymentWay;
	}

	public void setPaymentWay(String paymentWay) {
		this.paymentWay = paymentWay;
	}

	public String getNoteMan() {
		return noteMan;
	}

	public void setNoteMan(String noteMan) {
		this.noteMan = noteMan;
	}

	public Long getDmId() {
		return dmId;
	}

	public void setDmId(Long dmId) {
		this.dmId = dmId;
	}

	public Long getBatchId() {
		return batchId;
	}

	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Double getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(Double payMoney) {
		this.payMoney = payMoney;
	}

	public int getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}

	public List<HtOrderGoodsView> getHtOrderGoodsList() {
		return htOrderGoodsList;
	}

	public void setHtOrderGoodsList(List<HtOrderGoodsView> htOrderGoodsList) {
		this.htOrderGoodsList = htOrderGoodsList;
	}

	public Double getCountMoney() {
		return countMoney;
	}

	public void setCountMoney(Double countMoney) {
		this.countMoney = countMoney;
	}
	
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

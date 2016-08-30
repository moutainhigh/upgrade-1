package com.qtz.ht.order.spi.order.page;

import java.io.Serializable;

import com.qtz.base.common.Pager;
import com.qtz.ht.order.spi.order.vo.HtOrder;

/**
 * 
 * 
 * @author Administrator
 *
 */
public class HtOrderPage extends Pager<HtOrder, Long> implements Serializable {

	private static final long serialVersionUID = 5683448391126214595L;
	
	private Long dmId;
	/**
	 * 批次号
	 */
	private Long batchId;
	/**
	 * 会员ID
	 */
	private Long vipCode;
	/**
	 * 供应商ID
	 */
	private Long staffCode;
	/**
	 * 供商名称
	 */
	private String staffName;
	/**
	 * 状态：0:关闭,1未付款,2:待发货,3:待收货,4:退款中,5:完成
	 */
	private Integer status;
	/**
	 * 商家同意状态  1：同意退款， 2:拒绝退款
	 */
	private Integer agreeState;
	/**
	 * 订单付款状态:1未付款 2已付款  3 已取消订单
	 */
	private Integer payType;
	/**
	 * 订单查询起始时间
	 */
	private Long orderStartTime;
	/**
	 * 订单查询结束时间
	 */
	private Long orderEndTime;
	/**
	 * 支付查询起始时间
	 */
	private Long payStartTime;
	/**
	 * 支付查询结束时间
	 */
	private Long payEndTime;
	/**
	 * 收货人地址
	 */
	private String detailAddr;
	/**
	 * 收货人电话
	 */
	private String mphoneNo;
	/**
	 * 收货人姓名
	 */
	private String consignee;
	/**
	 * 完成时间
	 */
	private Long completeTime;
	/**
	 * 运单号
	 */
	private Long expressCode;
	/**
	 * 商品编号 
	 */
	private String goodSpec;
	
	public String getGoodSpec() {
		return goodSpec;
	}

	public void setGoodSpec(String goodSpec) {
		this.goodSpec = goodSpec;
	}

	public Long getExpressCode() {
		return expressCode;
	}

	public void setExpressCode(Long expressCode) {
		this.expressCode = expressCode;
	}
	
	public Long getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(Long completeTime) {
		this.completeTime = completeTime;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getDetailAddr() {
		return detailAddr;
	}

	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}

	public String getMphoneNo() {
		return mphoneNo;
	}

	public void setMphoneNo(String mphoneNo) {
		this.mphoneNo = mphoneNo;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public Integer getAgreeState() {
		return agreeState;
	}

	public void setAgreeState(Integer agreeState) {
		this.agreeState = agreeState;
	}

	public Long getVipCode() {
		return vipCode;
	}

	public void setVipCode(Long vipCode) {
		this.vipCode = vipCode;
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

	public Long getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(Long staffCode) {
		this.staffCode = staffCode;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public Long getOrderStartTime() {
		return orderStartTime;
	}

	public void setOrderStartTime(Long orderStartTime) {
		this.orderStartTime = orderStartTime;
	}

	public Long getOrderEndTime() {
		return orderEndTime;
	}

	public void setOrderEndTime(Long orderEndTime) {
		this.orderEndTime = orderEndTime;
	}

	public Long getPayStartTime() {
		return payStartTime;
	}

	public void setPayStartTime(Long payStartTime) {
		this.payStartTime = payStartTime;
	}

	public Long getPayEndTime() {
		return payEndTime;
	}

	public void setPayEndTime(Long payEndTime) {
		this.payEndTime = payEndTime;
	}

}

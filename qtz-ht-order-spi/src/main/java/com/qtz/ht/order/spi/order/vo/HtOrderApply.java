package com.qtz.ht.order.spi.order.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.qtz.base.dto.VO;

public class HtOrderApply extends VO<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1565481338275694006L;

	/**
	 * 订单ID
	 */
	private Long orderId;
	/**
	 * 操作类型(用户操作：1， 商家操作：2, 3：客服)
	 */
	private Integer handleType;
	/**
	 * 理由（买家：申请退货理由，商家：拒绝理由）
	 */
	private String reason;
	/**
	 * 状态说明 1:用户申请   2:商家同意  3:商家拒绝  4:用户发货 5:客服仲裁
	 */
	private Integer stateExplain;
	/**
	 * 备注
	 */
	private String remarks;
	/**
	 * 创建时间
	 */
	private Long createTime;
	/**
	 * 商家地址
	 */
	private String shopAddress;
	/**
	 * 商家收货人
	 */
	private String shopConsignee;
	/**
	 * 商家电话
	 */
	private String shopTel;
	/**
	 * 快递
	 */
	private String express;
	/**
	 * 快递号
	 */
	private String expressCode;
	/**
	 * 发货时间
	 */
	private Long deliverTime;
	/**
	 * 商品图片
	 */
	private String goodsImg;
	
	@Override
	public Long getDmId() {
		// TODO Auto-generated method stub
		return super.getDmId();
	}
	@Override
	public void setDmId(Long dmId) {
		// TODO Auto-generated method stub
		super.setDmId(dmId);
	}

	public String getGoodsImg() {
		return goodsImg;
	}

	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Integer getHandleType() {
		return handleType;
	}

	public void setHandleType(Integer handleType) {
		this.handleType = handleType;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	public Integer getStateExplain() {
		return stateExplain;
	}
	public void setStateExplain(Integer stateExplain) {
		this.stateExplain = stateExplain;
	}
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public String getShopConsignee() {
		return shopConsignee;
	}

	public void setShopConsignee(String shopConsignee) {
		this.shopConsignee = shopConsignee;
	}

	public String getShopTel() {
		return shopTel;
	}

	public void setShopTel(String shopTel) {
		this.shopTel = shopTel;
	}

	public String getExpress() {
		return express;
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

	public Long getDeliverTime() {
		return deliverTime;
	}

	public void setDeliverTime(Long deliverTime) {
		this.deliverTime = deliverTime;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

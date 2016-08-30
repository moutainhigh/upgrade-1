package com.qtz.ht.order.spi.rpt.trade.vo;

import java.io.Serializable;

import com.qtz.base.dto.VO;

/**
 * Title:RptOrder<br/>
 * Description:(报表专用订单表VO实体类)<br/>
 * Copyright: Copyright (c) 2016<br/>
 * Company: 深圳市擎天柱信息科技有限公司<br/>
 * @author  甘佳 jackgrays@matrix.com
 * @version v1.0 2016-03-11
 */
public class RptOrder extends VO<Long> implements Serializable {

	/**(序列化UID)*/
	private static final long serialVersionUID = 7146473493405584699L;
    /**(订单id)*/
	private Long dmId;
    /**(商家id)*/
	private Long sellerId;
    /**(使用优惠卷 没有 则为null)*/
	private Long couponId;
    /**(购买用户)*/
	private Long userId;
    /**(创建时间 下单时间)*/
	private Long crtime;
    /**(1 外卖订单 2 堂食订单)*/
	private Integer orderType;
    /**(订单价格)*/
	private Double orderPrice;
    /**(支付成功时间)*/
	private Long chargeTime;
    /**(订单状态)*/
	private Integer orderStatus;
    /**(第三方流水号)*/
	private String threeSerialNumber;
    /**(优惠金额)*/
	private Double couponPrice;
    /**(付款金额)*/
	private Double paymentPrice;
    /**(收货手机号码)*/
	private String receivingPhone;
    /**(收货名字)*/
	private String receivingName;
    /**(门牌号)*/
	private String houseNumber;
    /**(收货地址)*/
	private String receivingAddress;
    /**(商品总数量)*/
	private Integer goodsCount;
    /**(支付状态 0支付成功 1 未支付  3退款)*/
	private Integer payStatus;
    /**(预约开始时间)*/
	private Long makeTime;
    /**(派送费)*/
	private Double sendFee;
    /**(餐盒费)*/
	private Double mealFee;
    /**(交易状态 0交易成功 1 交易失败   2默认交易中)*/
	private Integer transactionStatus;
    /**(收货状态  0 未收货  1 已收货)*/
	private Integer receivingStatus;
    /**(退款状态 0 未申请退款  1申请退款 2同意退款 3拒绝退款)*/
	private Integer refundStatus;
    /**(接单状态 0已接单  1 未接单  2拒绝接单)*/
	private Integer sellerOrderStatus;
    /**(备注)*/
	private String note;
    /**(支付类型 1支付宝  2微信  )*/
	private Integer payType;
    /**( 退款备注)*/
	private String refundNote;

	public Long getDmId(){
		return this.dmId;
	}
	public void setDmId(Long dmId){
		this.dmId = dmId;
	}
	public Long getSellerId(){
		return this.sellerId;
	}
	public void setSellerId(Long sellerId){
		this.sellerId = sellerId;
	}
	public Long getCouponId(){
		return this.couponId;
	}
	public void setCouponId(Long couponId){
		this.couponId = couponId;
	}
	public Long getUserId(){
		return this.userId;
	}
	public void setUserId(Long userId){
		this.userId = userId;
	}
	public Long getCrtime(){
		return this.crtime;
	}
	public void setCrtime(Long crtime){
		this.crtime = crtime;
	}
	public Integer getOrderType(){
		return this.orderType;
	}
	public void setOrderType(Integer orderType){
		this.orderType = orderType;
	}
	public Double getOrderPrice(){
		return this.orderPrice;
	}
	public void setOrderPrice(Double orderPrice){
		this.orderPrice = orderPrice;
	}
	public Long getChargeTime(){
		return this.chargeTime;
	}
	public void setChargeTime(Long chargeTime){
		this.chargeTime = chargeTime;
	}
	public Integer getOrderStatus(){
		return this.orderStatus;
	}
	public void setOrderStatus(Integer orderStatus){
		this.orderStatus = orderStatus;
	}
	public String getThreeSerialNumber(){
		return this.threeSerialNumber;
	}
	public void setThreeSerialNumber(String threeSerialNumber){
		this.threeSerialNumber = threeSerialNumber;
	}
	public Double getCouponPrice(){
		return this.couponPrice;
	}
	public void setCouponPrice(Double couponPrice){
		this.couponPrice = couponPrice;
	}
	public Double getPaymentPrice(){
		return this.paymentPrice;
	}
	public void setPaymentPrice(Double paymentPrice){
		this.paymentPrice = paymentPrice;
	}
	public String getReceivingPhone(){
		return this.receivingPhone;
	}
	public void setReceivingPhone(String receivingPhone){
		this.receivingPhone = receivingPhone;
	}
	public String getReceivingName(){
		return this.receivingName;
	}
	public void setReceivingName(String receivingName){
		this.receivingName = receivingName;
	}
	public String getHouseNumber(){
		return this.houseNumber;
	}
	public void setHouseNumber(String houseNumber){
		this.houseNumber = houseNumber;
	}
	public String getReceivingAddress(){
		return this.receivingAddress;
	}
	public void setReceivingAddress(String receivingAddress){
		this.receivingAddress = receivingAddress;
	}
	public Integer getGoodsCount(){
		return this.goodsCount;
	}
	public void setGoodsCount(Integer goodsCount){
		this.goodsCount = goodsCount;
	}
	public Integer getPayStatus(){
		return this.payStatus;
	}
	public void setPayStatus(Integer payStatus){
		this.payStatus = payStatus;
	}
	public Long getMakeTime(){
		return this.makeTime;
	}
	public void setMakeTime(Long makeTime){
		this.makeTime = makeTime;
	}
	public Double getSendFee(){
		return this.sendFee;
	}
	public void setSendFee(Double sendFee){
		this.sendFee = sendFee;
	}
	public Double getMealFee(){
		return this.mealFee;
	}
	public void setMealFee(Double mealFee){
		this.mealFee = mealFee;
	}
	public Integer getTransactionStatus(){
		return this.transactionStatus;
	}
	public void setTransactionStatus(Integer transactionStatus){
		this.transactionStatus = transactionStatus;
	}
	public Integer getReceivingStatus(){
		return this.receivingStatus;
	}
	public void setReceivingStatus(Integer receivingStatus){
		this.receivingStatus = receivingStatus;
	}
	public Integer getRefundStatus(){
		return this.refundStatus;
	}
	public void setRefundStatus(Integer refundStatus){
		this.refundStatus = refundStatus;
	}
	public Integer getSellerOrderStatus(){
		return this.sellerOrderStatus;
	}
	public void setSellerOrderStatus(Integer sellerOrderStatus){
		this.sellerOrderStatus = sellerOrderStatus;
	}
	public String getNote(){
		return this.note;
	}
	public void setNote(String note){
		this.note = note;
	}
	public Integer getPayType(){
		return this.payType;
	}
	public void setPayType(Integer payType){
		this.payType = payType;
	}
	public String getRefundNote(){
		return this.refundNote;
	}
	public void setRefundNote(String refundNote){
		this.refundNote = refundNote;
	}

	@Override
	public String toString() {
		return "RptOrder[" +
		"dmId=" + dmId +
		",sellerId=" + sellerId +
		",couponId=" + couponId +
		",userId=" + userId +
		",crtime=" + crtime +
		",orderType=" + orderType +
		",orderPrice=" + orderPrice +
		",chargeTime=" + chargeTime +
		",orderStatus=" + orderStatus +
		",threeSerialNumber=" + threeSerialNumber +
		",couponPrice=" + couponPrice +
		",paymentPrice=" + paymentPrice +
		",receivingPhone=" + receivingPhone +
		",receivingName=" + receivingName +
		",houseNumber=" + houseNumber +
		",receivingAddress=" + receivingAddress +
		",goodsCount=" + goodsCount +
		",payStatus=" + payStatus +
		",makeTime=" + makeTime +
		",sendFee=" + sendFee +
		",mealFee=" + mealFee +
		",transactionStatus=" + transactionStatus +
		",receivingStatus=" + receivingStatus +
		",refundStatus=" + refundStatus +
		",sellerOrderStatus=" + sellerOrderStatus +
		",note=" + note +
		",payType=" + payType +
		",refundNote=" + refundNote +
		']';
	}

}

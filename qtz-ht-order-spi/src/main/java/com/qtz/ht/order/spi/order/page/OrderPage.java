package com.qtz.ht.order.spi.order.page;
import com.qtz.base.common.Pager;
/**
 * <p>Title:OrderPage</p>
 * <p>Description:订单分页类</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
 * @author 涂鑫 -xin.tu
 * @version v1.0 2015-09-18
 */
public class OrderPage extends Pager<com.qtz.ht.order.spi.order.vo.HtOrder,java.lang.Long> implements java.io.Serializable{

	/**类的版本号*/
	private static final long serialVersionUID = 1323933640427521L;

		/** 订单id */	private java.lang.Long dmId;	/** 商家id */	private java.lang.Long sellerId;	/** 使用优惠卷 没有 则为null */	private java.lang.Long couponId;	/** 购买用户 */	private java.lang.Long userId;	/** 创建时间 下单时间 */	private java.lang.Long crtime;	/** 1 外卖订单 2 堂食订单 */	private java.lang.Integer orderType;	/** 订单价格 */	private java.lang.Double orderPrice;	/** 支付成功时间 */	private java.lang.Long chargeTime;	/** 订单状态 */	private java.lang.Integer orderStatus;	/** 第三方流水号 */	private java.lang.String threeSerialNumber;	/** 优惠金额 */	private java.lang.Double couponPrice;	/** 付款金额 */	private java.lang.Double paymentPrice;	/** 收货手机号码 */	private java.lang.String receivingPhone;	/** 收货名字 */	private java.lang.String receivingName;	/** 门牌号 */	private java.lang.String houseNumber;	/** 收货地址 */	private java.lang.String receivingAddress;	/** 商品总数量 */	private java.lang.Integer goodsCount;	/** 支付状态 0支付成功 1 未支付  3退款 */	private java.lang.Integer payStatus;	/** 预约开始时间 */	private java.lang.Long makeTime;	/** 派送费 */	private java.lang.Double sendFee;	/** 餐盒费 */	private java.lang.Double mealFee;	/** 交易状态 0交易成功 1 交易失败   2默认交易中 */	private java.lang.Integer transactionStatus;	/** 收货状态  0 未收货  1 已收货 */	private java.lang.Integer receivingStatus;	/** 退款状态 0 未申请退款  1申请退款 2同意退款 3拒绝退款 */	private java.lang.Integer refundStatus;	/** 接单状态 0已接单  1 未接单  2拒绝接单 */	private java.lang.Integer sellerOrderStatus;	/** 备注 */	private java.lang.String note;	/** 支付类型 1支付宝  2微信 */	private java.lang.Integer payType;
	
	/**
	 * 退款备注
	 */
	private String refundNote;
	
	/** 时间查询入参  (接收页面传递数据) 不与数据库交付 */
	private String orderstime;
	
	private String orderetime;
	
	private String paystime;
	
	private String payetime;
	
	/** **/
	/** 下单时间*/
	private Long orderStartTime;
	
	private Long orderEndTime;
	
	/** 支付成功时间*/
	private Long payStartTime;
	
	private Long payEndTime;
	
	private String paOrdersId;
	
	public String getPaOrdersId() {
		return paOrdersId;
	}
	public void setPaOrdersId(String paOrdersId) {
		this.paOrdersId = paOrdersId;
	}
	public java.lang.Long getDmId() {	    return this.dmId;	}	public void setDmId(java.lang.Long dmId) {	    this.dmId=dmId;	}	public java.lang.Long getSellerId() {	    return this.sellerId;	}	public void setSellerId(java.lang.Long sellerId) {	    this.sellerId=sellerId;	}	public java.lang.Long getCouponId() {	    return this.couponId;	}	public void setCouponId(java.lang.Long couponId) {	    this.couponId=couponId;	}	public java.lang.Long getUserId() {	    return this.userId;	}	public void setUserId(java.lang.Long userId) {	    this.userId=userId;	}	public java.lang.Long getCrtime() {	    return this.crtime;	}	public void setCrtime(java.lang.Long crtime) {	    this.crtime=crtime;	}	public java.lang.Integer getOrderType() {	    return this.orderType;	}	public void setOrderType(java.lang.Integer orderType) {	    this.orderType=orderType;	}	public java.lang.Double getOrderPrice() {	    return this.orderPrice;	}	public void setOrderPrice(java.lang.Double orderPrice) {	    this.orderPrice=orderPrice;	}	public java.lang.Long getChargeTime() {	    return this.chargeTime;	}	public void setChargeTime(java.lang.Long chargeTime) {	    this.chargeTime=chargeTime;	}	public java.lang.Integer getOrderStatus() {	    return this.orderStatus;	}	public void setOrderStatus(java.lang.Integer orderStatus) {	    this.orderStatus=orderStatus;	}	public java.lang.String getThreeSerialNumber() {	    return this.threeSerialNumber;	}	public void setThreeSerialNumber(java.lang.String threeSerialNumber) {	    this.threeSerialNumber=threeSerialNumber;	}	public java.lang.Double getCouponPrice() {	    return this.couponPrice;	}	public void setCouponPrice(java.lang.Double couponPrice) {	    this.couponPrice=couponPrice;	}	public java.lang.Double getPaymentPrice() {	    return this.paymentPrice;	}	public void setPaymentPrice(java.lang.Double paymentPrice) {	    this.paymentPrice=paymentPrice;	}	public java.lang.String getReceivingPhone() {	    return this.receivingPhone;	}	public void setReceivingPhone(java.lang.String receivingPhone) {	    this.receivingPhone=receivingPhone;	}	public java.lang.String getReceivingName() {	    return this.receivingName;	}	public void setReceivingName(java.lang.String receivingName) {	    this.receivingName=receivingName;	}	public java.lang.String getHouseNumber() {	    return this.houseNumber;	}	public void setHouseNumber(java.lang.String houseNumber) {	    this.houseNumber=houseNumber;	}	public java.lang.String getReceivingAddress() {	    return this.receivingAddress;	}	public void setReceivingAddress(java.lang.String receivingAddress) {	    this.receivingAddress=receivingAddress;	}	public java.lang.Integer getGoodsCount() {	    return this.goodsCount;	}	public void setGoodsCount(java.lang.Integer goodsCount) {	    this.goodsCount=goodsCount;	}	public java.lang.Integer getPayStatus() {	    return this.payStatus;	}	public void setPayStatus(java.lang.Integer payStatus) {	    this.payStatus=payStatus;	}	public java.lang.Long getMakeTime() {	    return this.makeTime;	}	public void setMakeTime(java.lang.Long makeTime) {	    this.makeTime=makeTime;	}	public java.lang.Double getSendFee() {	    return this.sendFee;	}	public void setSendFee(java.lang.Double sendFee) {	    this.sendFee=sendFee;	}	public java.lang.Double getMealFee() {	    return this.mealFee;	}	public void setMealFee(java.lang.Double mealFee) {	    this.mealFee=mealFee;	}	public java.lang.Integer getTransactionStatus() {	    return this.transactionStatus;	}	public void setTransactionStatus(java.lang.Integer transactionStatus) {	    this.transactionStatus=transactionStatus;	}	public java.lang.Integer getReceivingStatus() {	    return this.receivingStatus;	}	public void setReceivingStatus(java.lang.Integer receivingStatus) {	    this.receivingStatus=receivingStatus;	}	public java.lang.Integer getRefundStatus() {	    return this.refundStatus;	}	public void setRefundStatus(java.lang.Integer refundStatus) {	    this.refundStatus=refundStatus;	}	public java.lang.Integer getSellerOrderStatus() {	    return this.sellerOrderStatus;	}	public void setSellerOrderStatus(java.lang.Integer sellerOrderStatus) {	    this.sellerOrderStatus=sellerOrderStatus;	}	public java.lang.String getNote() {	    return this.note;	}	public void setNote(java.lang.String note) {	    this.note=note;	}	public java.lang.Integer getPayType() {	    return this.payType;	}	public void setPayType(java.lang.Integer payType) {	    this.payType=payType;	}
		public String getRefundNote() {
		return refundNote;
	}
	public void setRefundNote(String refundNote) {
		this.refundNote = refundNote;
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
	
	public String getOrderstime() {
		return orderstime;
	}
	public void setOrderstime(String orderstime) {
		this.orderstime = orderstime;
	}
	public String getOrderetime() {
		return orderetime;
	}
	public void setOrderetime(String orderetime) {
		this.orderetime = orderetime;
	}
	public String getPaystime() {
		return paystime;
	}
	public void setPaystime(String paystime) {
		this.paystime = paystime;
	}
	public String getPayetime() {
		return payetime;
	}
	public void setPayetime(String payetime) {
		this.payetime = payetime;
	}
	public String toString() {	    return "[" + "dmId:" + getDmId() +"," + "sellerId:" + getSellerId() +"," + "couponId:" + getCouponId() +"," + "userId:" + getUserId() +"," + "crtime:" + getCrtime() +"," + "orderType:" + getOrderType() +"," + "orderPrice:" + getOrderPrice() +"," + "chargeTime:" + getChargeTime() +"," + "orderStatus:" + getOrderStatus() +"," + "threeSerialNumber:" + getThreeSerialNumber() +"," + "couponPrice:" + getCouponPrice() +"," + "paymentPrice:" + getPaymentPrice() +"," + "receivingPhone:" + getReceivingPhone() +"," + "receivingName:" + getReceivingName() +"," + "houseNumber:" + getHouseNumber() +"," + "receivingAddress:" + getReceivingAddress() +"," + "goodsCount:" + getGoodsCount() +"," + "payStatus:" + getPayStatus() +"," + "makeTime:" + getMakeTime() +"," + "sendFee:" + getSendFee() +"," + "mealFee:" + getMealFee() +"," + "transactionStatus:" + getTransactionStatus() +"," + "receivingStatus:" + getReceivingStatus() +"," + "refundStatus:" + getRefundStatus() +"," + "sellerOrderStatus:" + getSellerOrderStatus() +"," + "note:" + getNote() +"," + "payType:" + getPayType() +"]";	}
}
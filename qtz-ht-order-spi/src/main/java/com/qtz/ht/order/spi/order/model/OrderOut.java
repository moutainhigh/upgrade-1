package com.qtz.ht.order.spi.order.model;
/**
 * <p>Title:Order</p>
 * <p>Description:订单VO类</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
 * @author 涂鑫 -xin.tu
 * @version v1.0 2015-09-07
 */
public class OrderOut implements java.io.Serializable {
	
	/**类的版本号*/
	private static final long serialVersionUID = 1308498390534144L;
	
	private java.lang.String dmId;
	/** 商家id */
	private java.lang.Long sellerId;
	/** 使用优惠卷 没有 则为null */
	private java.lang.Long couponId;
	/** 购买用户 */
	private java.lang.Long userId;
	/** 创建时间 下单时间 */
	private java.lang.Long crtime;
	/** 1 外卖订单 2 堂食订单 */
	private java.lang.Integer orderType;
	/** 订单价格 */
	private java.lang.Double orderPrice;
	/** 支付成功时间 */
	private java.lang.Long chargeTime;
	/** 订单状态 */
	private java.lang.Integer orderStatus;
	/** 第三方流水号 */
	private java.lang.String threeSerialNumber;
	/** 优惠金额 */
	private java.lang.Double couponPrice;
	/** 付款金额 */
	private java.lang.Double paymentPrice;
	/** 收货手机号码 */
	private java.lang.String receivingPhone;
	/** 收货名字 */
	private java.lang.String receivingName;
	/** 收货地址 */
	private java.lang.String receivingAddress;
	/**
	 * 收货门牌号
	 */
	private java.lang.String houseNumber;
	/** 商品总数量 */
	private java.lang.Integer goodsCount;
	/** 支付状态 0支付成功 1 未支付  3退款 */
	private java.lang.Integer payStatus;
	/**
	 * 备注
	 */
	private String note;
	/**
	 * 预约时间
	 */
	private java.lang.Long makeTime;
	
	/** 派送费 */
	private java.lang.Double sendFee;
	/** 餐盒费 */
	private java.lang.Double mealFee;
	/**
	 * 交易状态
	 */
	private java.lang.Integer transactionStatus;
	
	
	
	/**
	 * 支付类型
	 */
	private java.lang.Integer payType;
	//start luoshun 20160326
	/**
	 * 支付类型文本
	 */
	private java.lang.String payTypeContent;
	//end luoshun 20160326
	
	/**
	 * 
	 * <p>Title:OrderStatus</p>
	 * <p>Description:(订单状态)</p>
	 * <p>Copyright: Copyright (c) 2015</p>
	 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
	 * @author 涂鑫 - changbo.li
	 * @version v1.0 2015年9月7日
	 */
	public enum OrderStatus{
		/**
		 * 支付成功
		 */
		success(0,"成功 交易关闭"),
		
		/**
		 * 未支付 	 未支付
		 */
		unpay(1,"下单 未支付"),
		
		/**
		 * 退款 	订单失败
		 */
		refund(2,"退款中  同意退款"),
		/**
		 * 拒绝订单	订单失败
		 */
		refused(3,"拒绝接单"),
		/**
		 * 接单	属于已支付
		 */
		reorder(4,"已经支付已接单"),
		/**
		 * 支付 未接单
		 */
		pay_dont_answer_sheet(5,"支付后  商家未接单"),
		/**
		 * 交易关闭失败
		 */
		failure(6,"交易失败  关闭"),
		/**
		 * 申请退款
		 */
		applyRefund(7,"申请退款中");
		
		private int  id;//id
		private String desc;//描述
		private OrderStatus(int id,String desc){
			this.id=id;
			this.desc=desc;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
	}
	
	/**
	 * 商家接单状态
	 */
	private Integer sellerOrderStatus;
	/**
	 * 退款状态
	 */
	private Integer refundStatus;
	/**
	 * 收货状态
	 */
	private Integer receivingStatus;
	/**
	 * 
	 * <p>Title:sellerOrderStatus</p>
	 * <p>Description:(商家接单情况)</p>
	 * <p>Copyright: Copyright (c) 2015</p>
	 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
	 * @author 涂鑫 - changbo.li
	 * @version v1.0 2015年9月16日
	 */
	public enum SellerOrderStatus{
		//已接单
		havaOrder(0),
		/**
		 * 未接单
		 */
		donHavaOrder(1),
		/**
		 * 已拒绝
		 */
		refusedOrder(2);
		private int value;
		private SellerOrderStatus(int value){
			this.value=value;
		}
		public int value(){
			return value;
		}
	}
	/**
	 * 
	 * <p>Title:RefundStatus</p>
	 * <p>Description:(退款状态)</p>
	 * <p>Copyright: Copyright (c) 2015</p>
	 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
	 * @author 涂鑫 - changbo.li
	 * @version v1.0 2015年9月16日
	 */
	public enum RefundStatus{
		/**
		 * 未申请退款
		 */
		dontApplyRefund(0),
		/**
		 * 申请退款
		 */
		applyRefund(1),
		/**
		 * 同意退款
		 */
		agreedRefund(2),
		/**
		 * 拒绝退款
		 */
		refusedRefund(3);
		private int value;
		private RefundStatus(int value){
			this.value=value;
		}
		public int value(){
			return value;
		}
	}
	
	/**
	 * 
	 * <p>Title:ReceivingStatus</p>
	 * <p>Description:(收货状态)</p>
	 * <p>Copyright: Copyright (c) 2015</p>
	 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
	 * @author 涂鑫 - changbo.li
	 * @version v1.0 2015年9月16日
	 */
	public enum ReceivingStatus{
		/**
		 * 0 未消费 	未收货
		 */
		notSpending(0),
		/**
		 * 已经消费	已收货
		 */
		hasSpending(1);
		private int value;
		private ReceivingStatus(int value){
			this.value=value;
		}
		public int value(){
			return value;
		}
	}
	/**
	 * 
	 * <p>Title:transactionStatus</p>
	 * <p>Description:(交易状态	这个交易状态属于用户与商家直接的交易)</p>
	 * <p>Copyright: Copyright (c) 2015</p>
	 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
	 * @author 涂鑫 - changbo.li
	 * @version v1.0 2015年9月16日
	 */
	public enum TransactionStatus{
		/**
		 * 成功
		 */
		success(0),
		/**
		 * 失败
		 */
		failure(1);
		private int value;
		private TransactionStatus(int value){
			this.value=value;
		}
		public int value(){
			return value;
		}
	}
	/**
	 * 
	 * <p>Title:OrderTypeEnum</p>
	 * <p>Description:(订单类型)</p>
	 * <p>Copyright: Copyright (c) 2015</p>
	 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
	 * @author 涂鑫 - changbo.li
	 * @version v1.0 2015年9月2日
	 */
	public enum OrderTypeEnum{
		/**
		 * 1 外卖订单 	2堂食订单
		 * 
		 */
		takeOut(1),eatIn(2);
		private int value;
		private OrderTypeEnum(int value){
			this.value=value;
		}
		public int value(){
			return this.value;
		}
	}

	/**
	 * 
	 * <p>Title:PayStatusEnum</p>
	 * <p>Description:(支付枚举)</p>
	 * <p>Copyright: Copyright (c) 2015</p>
	 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
	 * @author 涂鑫 - changbo.li
	 * @version v1.0 2015年8月26日
	 */
	public enum PayStatusEnum{
		/**
		 * 支付成功
		 */
		PAY_SUCCESS(0,"success","pay"),
		/**
		 * 未支付
		 */
		PAY_FAILURE(1,"failure","unpay"),
		/**
		 * 支付失败 退款
		 */
		PAY_REFUND(2,"failure","refund");
		private int  id;//id
		private String desc;//描述
		private String payResult;//支付结果
		private PayStatusEnum(int id,String desc,String payResult){
			this.id=id;
			this.desc=desc;
			this.payResult=payResult;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
		public String getPayResult() {
			return payResult;
		}
		public void setPayResult(String payResult) {
			this.payResult = payResult;
		}
	}
	
	public java.lang.Integer getTransactionStatus() {
		return transactionStatus;
	}


	public void setTransactionStatus(java.lang.Integer transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public java.lang.Long getSellerId() {
	    return this.sellerId;
	}
	public void setSellerId(java.lang.Long sellerId) {
	    this.sellerId=sellerId;
	}
	public java.lang.Long getCouponId() {
	    return this.couponId;
	}
	public void setCouponId(java.lang.Long couponId) {
	    this.couponId=couponId;
	}
	public java.lang.Long getUserId() {
	    return this.userId;
	}
	public void setUserId(java.lang.Long userId) {
	    this.userId=userId;
	}
	public java.lang.Long getCrtime() {
	    return this.crtime;
	}
	public void setCrtime(java.lang.Long crtime) {
	    this.crtime=crtime;
	}
	public java.lang.Integer getOrderType() {
	    return this.orderType;
	}
	public void setOrderType(java.lang.Integer orderType) {
	    this.orderType=orderType;
	}
	public java.lang.Double getOrderPrice() {
	    return this.orderPrice;
	}
	public void setOrderPrice(java.lang.Double orderPrice) {
	    this.orderPrice=orderPrice;
	}
	public java.lang.Long getChargeTime() {
	    return this.chargeTime;
	}
	public void setChargeTime(java.lang.Long chargeTime) {
	    this.chargeTime=chargeTime;
	}
	public java.lang.Integer getOrderStatus() {
	    return this.orderStatus;
	}
	public void setOrderStatus(java.lang.Integer orderStatus) {
	    this.orderStatus=orderStatus;
	}
	public java.lang.String getThreeSerialNumber() {
	    return this.threeSerialNumber;
	}
	public void setThreeSerialNumber(java.lang.String threeSerialNumber) {
	    this.threeSerialNumber=threeSerialNumber;
	}
	public java.lang.Double getCouponPrice() {
	    return this.couponPrice;
	}
	public void setCouponPrice(java.lang.Double couponPrice) {
	    this.couponPrice=couponPrice;
	}
	public java.lang.Double getPaymentPrice() {
	    return this.paymentPrice;
	}
	public void setPaymentPrice(java.lang.Double paymentPrice) {
	    this.paymentPrice=paymentPrice;
	}
	public java.lang.String getReceivingPhone() {
	    return this.receivingPhone;
	}
	public void setReceivingPhone(java.lang.String receivingPhone) {
	    this.receivingPhone=receivingPhone;
	}
	public java.lang.String getReceivingName() {
	    return this.receivingName;
	}
	public void setReceivingName(java.lang.String receivingName) {
	    this.receivingName=receivingName;
	}
	public java.lang.String getReceivingAddress() {
	    return this.receivingAddress;
	}
	public void setReceivingAddress(java.lang.String receivingAddress) {
	    this.receivingAddress=receivingAddress;
	}
	public java.lang.Integer getGoodsCount() {
	    return this.goodsCount;
	}
	public void setGoodsCount(java.lang.Integer goodsCount) {
	    this.goodsCount=goodsCount;
	}
	public java.lang.Integer getPayStatus() {
	    return this.payStatus;
	}
	public void setPayStatus(java.lang.Integer payStatus) {
	    this.payStatus=payStatus;
	}

	public java.lang.Long getMakeTime() {
		return makeTime;
	}

	public void setMakeTime(java.lang.Long makeTime) {
		this.makeTime = makeTime;
	}


	public java.lang.Double getSendFee() {
		return sendFee;
	}


	public void setSendFee(java.lang.Double sendFee) {
		this.sendFee = sendFee;
	}


	public java.lang.Double getMealFee() {
		return mealFee;
	}


	public void setMealFee(java.lang.Double mealFee) {
		this.mealFee = mealFee;
	}


	public java.lang.String getHouseNumber() {
		return houseNumber;
	}


	public void setHouseNumber(java.lang.String houseNumber) {
		this.houseNumber = houseNumber;
	}


	public Integer getSellerOrderStatus() {
		return sellerOrderStatus;
	}


	public void setSellerOrderStatus(Integer sellerOrderStatus) {
		this.sellerOrderStatus = sellerOrderStatus;
	}


	public Integer getRefundStatus() {
		return refundStatus;
	}


	public void setRefundStatus(Integer refundStatus) {
		this.refundStatus = refundStatus;
	}


	public Integer getReceivingStatus() {
		return receivingStatus;
	}


	public void setReceivingStatus(Integer receivingStatus) {
		this.receivingStatus = receivingStatus;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}



	public java.lang.Integer getPayType() {
		return payType;
	}


	public void setPayType(java.lang.Integer payType) {
		this.payType = payType;
	}


	public java.lang.String getDmId() {
		return dmId;
	}


	public void setDmId(java.lang.String dmId) {
		this.dmId = dmId;
	}


	public java.lang.String getPayTypeContent() {
		return payTypeContent;
	}


	public void setPayTypeContent(java.lang.String payTypeContent) {
		this.payTypeContent = payTypeContent;
	}
}
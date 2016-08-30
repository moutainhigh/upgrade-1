package com.qtz.ht.order.spi.common;

public interface HtOrderStatusConstant {
	
	String no_payment = "你已下单成功,请尽快支付";
	
	String already_payment = "你已支付成功,商家会尽快给你发货";
	
	String already_shipped = "商家已发货,请注意查收";
	
	String order_complete = "订单交易成功,欢迎下次再来";
	
	String order_refund = "你已申请退款";
	
	String order_close = "你的订单已经关闭";
	
	String agree_refund = "商家已同意你的退款申请";
	
	String not_refund = "商家拒绝你的退款申请";
}

package com.qtz.ht.order.spi.rpt.seller.page;

import java.io.Serializable;

import com.qtz.base.common.Pager;
import com.qtz.ht.order.spi.rpt.seller.vo.RptSellerMore;

/**
 * Title:RptSellerMorePage<br/>
 * Description:(商家统计表(多)Page分页类)<br/>
 * Copyright: Copyright (c) 2016<br/>
 * Company: 深圳市擎天柱信息科技有限公司<br/>
 * @author  甘佳 jackgrays@matrix.com
 * @version v1.0 2016-03-11
 */
public class RptSellerMorePage extends Pager<RptSellerMore,Long> implements Serializable {

	/**(序列化UID)*/
	private static final long serialVersionUID = 2936879978246654073L;
    /**()*/
	private Long dmId;
    /**(统计类型0天,1周,2月,3年)*/
	private Integer statType;
    /**(统计时间，当期开始时间)*/
	private Long statTime;
    /**(商家ID)*/
	private Long sellerId;
    /**(订单数量)*/
	private Integer orderNum;
    /**(订单总额)*/
	private Double orderTotalAmount;
    /**(商家总净收入额)*/
	private Double sellerTotalAmount;
    /**(支付宝总付款额)*/
	private Double alipayTotalAmount;
    /**(微信总付款额)*/
	private Double wechatTotalAmount;
    /**(钱包总付款额)*/
	private Double walletTotalAmount;
    /**(当期扣点总额)*/
	private Double deductTotalAmount;

	private java.lang.Long startTime;
	private java.lang.Long endTime;

	public Long getDmId(){
		return this.dmId;
	}
	public void setDmId(Long dmId){
		this.dmId = dmId;
	}
	public Integer getStatType(){
		return this.statType;
	}
	public void setStatType(Integer statType){
		this.statType = statType;
	}
	public Long getStatTime(){
		return this.statTime;
	}
	public void setStatTime(Long statTime){
		this.statTime = statTime;
	}
	public Long getSellerId(){
		return this.sellerId;
	}
	public void setSellerId(Long sellerId){
		this.sellerId = sellerId;
	}
	public Integer getOrderNum(){
		return this.orderNum;
	}
	public void setOrderNum(Integer orderNum){
		this.orderNum = orderNum;
	}
	public Double getOrderTotalAmount(){
		return this.orderTotalAmount;
	}
	public void setOrderTotalAmount(Double orderTotalAmount){
		this.orderTotalAmount = orderTotalAmount;
	}
	public Double getSellerTotalAmount(){
		return this.sellerTotalAmount;
	}
	public void setSellerTotalAmount(Double sellerTotalAmount){
		this.sellerTotalAmount = sellerTotalAmount;
	}
	public Double getAlipayTotalAmount(){
		return this.alipayTotalAmount;
	}
	public void setAlipayTotalAmount(Double alipayTotalAmount){
		this.alipayTotalAmount = alipayTotalAmount;
	}
	public Double getWechatTotalAmount(){
		return this.wechatTotalAmount;
	}
	public void setWechatTotalAmount(Double wechatTotalAmount){
		this.wechatTotalAmount = wechatTotalAmount;
	}
	public Double getWalletTotalAmount(){
		return this.walletTotalAmount;
	}
	public void setWalletTotalAmount(Double walletTotalAmount){
		this.walletTotalAmount = walletTotalAmount;
	}
	public Double getDeductTotalAmount(){
		return this.deductTotalAmount;
	}
	public void setDeductTotalAmount(Double deductTotalAmount){
		this.deductTotalAmount = deductTotalAmount;
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Long getEndTime() {
		return endTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "RptSellerMorePage[" +
		"dmId=" + dmId +
		",statType=" + statType +
		",statTime=" + statTime +
		",sellerId=" + sellerId +
		",orderNum=" + orderNum +
		",orderTotalAmount=" + orderTotalAmount +
		",sellerTotalAmount=" + sellerTotalAmount +
		",alipayTotalAmount=" + alipayTotalAmount +
		",wechatTotalAmount=" + wechatTotalAmount +
		",walletTotalAmount=" + walletTotalAmount +
		",deductTotalAmount=" + deductTotalAmount +
		']';
	}

}

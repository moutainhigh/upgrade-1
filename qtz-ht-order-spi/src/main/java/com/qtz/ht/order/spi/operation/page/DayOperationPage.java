package com.qtz.ht.order.spi.operation.page;

import com.qtz.base.common.Pager;

public class DayOperationPage extends Pager<com.qtz.ht.order.spi.operation.vo.DayOperation,java.lang.Long> implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1951477871884870326L;
	
	private Long dmId;
	/** 支付宝支付*/
	private Double alipay;
	/** 微信支付*/
	private Double wechat;
	/** 银联支付*/
	private Double unionPay;
	/** 钱包支付*/
	private Double wallet;
	/** 总营业额*/
	private Double turnover;
	/** 总申请提现额*/
	private Double withdrawals;
	/** 总提现打款额*/
	private Double playMoney;
	/** 总余额*/
	private Double balance;
	/** 统计时间*/
	private Long statisticalTime;
	/** 创建时间*/
	private Long crtime;
	/** 时间查询条件*/
	private Long stime;
	private Long etime;
	public Long getDmId() {
		return dmId;
	}
	public void setDmId(Long dmId) {
		this.dmId = dmId;
	}
	public Double getAlipay() {
		return alipay;
	}
	public void setAlipay(Double alipay) {
		this.alipay = alipay;
	}
	public Double getWechat() {
		return wechat;
	}
	public void setWechat(Double wechat) {
		this.wechat = wechat;
	}
	public Double getUnionPay() {
		return unionPay;
	}
	public void setUnionPay(Double unionPay) {
		this.unionPay = unionPay;
	}
	public Double getWallet() {
		return wallet;
	}
	public void setWallet(Double wallet) {
		this.wallet = wallet;
	}
	public Double getTurnover() {
		return turnover;
	}
	public void setTurnover(Double turnover) {
		this.turnover = turnover;
	}
	public Double getWithdrawals() {
		return withdrawals;
	}
	public void setWithdrawals(Double withdrawals) {
		this.withdrawals = withdrawals;
	}
	public Double getPlayMoney() {
		return playMoney;
	}
	public void setPlayMoney(Double playMoney) {
		this.playMoney = playMoney;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Long getStatisticalTime() {
		return statisticalTime;
	}
	public void setStatisticalTime(Long statisticalTime) {
		this.statisticalTime = statisticalTime;
	}
	public Long getCrtime() {
		return crtime;
	}
	public void setCrtime(Long crtime) {
		this.crtime = crtime;
	}
	public Long getStime() {
		return stime;
	}
	public void setStime(Long stime) {
		this.stime = stime;
	}
	public Long getEtime() {
		return etime;
	}
	public void setEtime(Long etime) {
		this.etime = etime;
	}
	public String toString() {
	    return "[" + "dmId:" + getDmId() +"," + "alipay:" + getAlipay() +"," + "wechat:" + getWechat() +"," + "unionPay" + getUnionPay()+ "wallet" + getWallet()+"," + "turnover" + getTurnover()+"," + "withdrawals" + getWithdrawals()+"," + "playMoney" + getPlayMoney()+"," + "balance" + getBalance()+"," + "statisticalTime" + getStatisticalTime() +"," + "crtime:" + getCrtime() +"]";
	}
}

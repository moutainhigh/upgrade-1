package com.qtz.ht.order.spi.operation.model;

public class DayOperationOut {
	
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
	private String statisticalTime;
	/** 创建时间*/
	private String crtime;
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
	public String getStatisticalTime() {
		return statisticalTime;
	}
	public void setStatisticalTime(String statisticalTime) {
		this.statisticalTime = statisticalTime;
	}
	public String getCrtime() {
		return crtime;
	}
	public void setCrtime(String crtime) {
		this.crtime = crtime;
	}
}

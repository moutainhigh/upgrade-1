package com.qtz.ht.order.spi.order.view;

import java.io.Serializable;

public class HtOrderStatusView implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5355407529578032441L;
	
	/**
	 * 备注
	 */
	private String  note;
	/**
	 * 订单ID
	 */
	private Long orderId;
	/**
	 * 订单状态
	 */
	private Integer status;
	/**
	 * 时间
	 */
	private Long time;
	/**
	 * 标题 
	 */
	private String title;

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	} 
	
}

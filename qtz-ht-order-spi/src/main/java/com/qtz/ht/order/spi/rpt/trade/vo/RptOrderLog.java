package com.qtz.ht.order.spi.rpt.trade.vo;

import java.io.Serializable;

import com.qtz.base.dto.VO;

/**
 * Title:RptOrderLog<br/>
 * Description:(报表专用订单记录表VO实体类)<br/>
 * Copyright: Copyright (c) 2016<br/>
 * Company: 深圳市擎天柱信息科技有限公司<br/>
 * @author  甘佳 jackgrays@matrix.com
 * @version v1.0 2016-03-14
 */
public class RptOrderLog extends VO<Long> implements Serializable {

	/**(序列化UID)*/
	private static final long serialVersionUID = -5512467824290543124L;
    /**()*/
	private Long dmId;
    /**(订单id)*/
	private Long orderId;
    /**(下单时间)*/
	private Long time;
    /**(订单状态)*/
	private Integer status;
    /**()*/
	private String notes;

	public Long getDmId(){
		return this.dmId;
	}
	public void setDmId(Long dmId){
		this.dmId = dmId;
	}
	public Long getOrderId(){
		return this.orderId;
	}
	public void setOrderId(Long orderId){
		this.orderId = orderId;
	}
	public Long getTime(){
		return this.time;
	}
	public void setTime(Long time){
		this.time = time;
	}
	public Integer getStatus(){
		return this.status;
	}
	public void setStatus(Integer status){
		this.status = status;
	}
	public String getNotes(){
		return this.notes;
	}
	public void setNotes(String notes){
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "RptOrderLog[" +
		"dmId=" + dmId +
		",orderId=" + orderId +
		",time=" + time +
		",status=" + status +
		",notes=" + notes +
		']';
	}

}

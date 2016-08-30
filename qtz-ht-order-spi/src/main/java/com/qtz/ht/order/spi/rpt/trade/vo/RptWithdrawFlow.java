package com.qtz.ht.order.spi.rpt.trade.vo;

import java.io.Serializable;

import com.qtz.base.dto.VO;

/**
 * Title:RptWithdrawFlow<br/>
 * Description:(提现明细表VO实体类)<br/>
 * Copyright: Copyright (c) 2016<br/>
 * Company: 深圳市擎天柱信息科技有限公司<br/>
 * @author  甘佳 jackgrays@matrix.com
 * @version v1.0 2016-03-22
 */
public class RptWithdrawFlow extends VO<Long> implements Serializable {

	/**(序列化UID)*/
	private static final long serialVersionUID = 441507756226071177L;
    /**()*/
	private Long dmId;
    /**(商家ID)*/
	private Long userId;
    /**(用户类别:0 普通用户  1 商家   2系统用户   3 代理商)*/
	private Integer userType;
    /**(提现处理时间)*/
	private Long finishTime;
    /**(提现金额)*/
	private Double amount;
    /**(完结状态:0提现成功;1,提现失败;2,待处理)*/
	private Integer okStatus;

	public enum OkStatus{
		SUCCESS(0),
		FAILURE(1),
		PENDING(2);
		private int id;
		OkStatus(int id){
			this.id = id;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return "OkStatus{" +
					"id=" + id +
					'}';
		}
	}

	public Long getDmId(){
		return this.dmId;
	}
	public void setDmId(Long dmId){
		this.dmId = dmId;
	}
	public Long getUserId(){
		return this.userId;
	}
	public void setUserId(Long userId){
		this.userId = userId;
	}
	public Integer getUserType(){
		return this.userType;
	}
	public void setUserType(Integer userType){
		this.userType = userType;
	}
	public Long getFinishTime(){
		return this.finishTime;
	}
	public void setFinishTime(Long finishTime){
		this.finishTime = finishTime;
	}
	public Double getAmount(){
		return this.amount;
	}
	public void setAmount(Double amount){
		this.amount = amount;
	}
	public Integer getOkStatus(){
		return this.okStatus;
	}
	public void setOkStatus(Integer okStatus){
		this.okStatus = okStatus;
	}

	@Override
	public String toString() {
		return "RptWithdrawFlow[" +
		"dmId=" + dmId +
		",userId=" + userId +
		",userType=" + userType +
		",finishTime=" + finishTime +
		",amount=" + amount +
		",okStatus=" + okStatus +
		']';
	}

}

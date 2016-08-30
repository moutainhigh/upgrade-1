package com.qtz.ht.order.spi.rpt.trade.model;

import java.io.Serializable;

/**
 * Title:(新钱包分润模型)<br/>
 * Description:(新钱包分润模型)<br/>
 * Copyright: Copyright © 2016<br/>
 * Company: 深圳市擎天柱信息技术有限公司<br/>
 * 
 * @author 甘佳-jackgrays@matrix.com
 * @version v1.0 2016年4月28日
 */
public class RptRunSubModel implements Serializable {

	/** (info) */
	private static final long serialVersionUID = -6030897759415082453L;

	/** (用户ID) */
	private Long userId;
	/** (操作时间) */
	private Long crtime;
	/** (操作金额) */
	private Double money;
	/**(1用户，2商家，3代理)*/
	private Byte userType;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getCrtime() {
		return crtime;
	}
	public void setCrtime(Long crtime) {
		this.crtime = crtime;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public Byte getUserType() {
		return userType;
	}
	public void setUserType(Byte userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "RptRunSubModel [userId=" + userId + ", crtime=" + crtime + ", money=" + money + ", userType=" + userType
				+ "]";
	}
	
}

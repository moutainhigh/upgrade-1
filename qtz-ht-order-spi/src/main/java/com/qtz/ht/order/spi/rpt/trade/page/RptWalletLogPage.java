package com.qtz.ht.order.spi.rpt.trade.page;

import java.io.Serializable;

import com.qtz.base.common.Pager;
import com.qtz.ht.order.spi.rpt.trade.vo.RptWalletLog;

/**
 * Title:RptWalletLogPage<br/>
 * Description:(报表专用钱包记录表Page分页类)<br/>
 * Copyright: Copyright (c) 2016<br/>
 * Company: 深圳市擎天柱信息科技有限公司<br/>
 * @author  甘佳 jackgrays@matrix.com
 * @version v1.0 2016-03-14
 */
public class RptWalletLogPage extends Pager<RptWalletLog,Long> implements Serializable {

	/**(序列化UID)*/
	private static final long serialVersionUID = 2278565966340179242L;
    /**()*/
	private Long dmId;
    /**(用户ID)*/
	private Long userId;
    /**(操作时间)*/
	private Long crtime;
    /**(1 分润  2 退款  3 金币返现   20  消费  21 提现  30 分润冻结  31 货款冻结  33 金币返现冻结)*/
	private Short type;
    /**(操作类型说明)*/
	private String typeMes;
    /**(操作流水号)*/
	private String objNum;
    /**(操作金额)*/
	private Double money;
    /**(解冻时间)*/
	private Long unfreezeTime;
    /**()*/
	private String month;
    /**()*/
	private Byte userType;

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
	public Long getCrtime(){
		return this.crtime;
	}
	public void setCrtime(Long crtime){
		this.crtime = crtime;
	}
	public Short getType(){
		return this.type;
	}
	public void setType(Short type){
		this.type = type;
	}
	public String getTypeMes(){
		return this.typeMes;
	}
	public void setTypeMes(String typeMes){
		this.typeMes = typeMes;
	}
	public String getObjNum(){
		return this.objNum;
	}
	public void setObjNum(String objNum){
		this.objNum = objNum;
	}
	public Double getMoney(){
		return this.money;
	}
	public void setMoney(Double money){
		this.money = money;
	}
	public Long getUnfreezeTime(){
		return this.unfreezeTime;
	}
	public void setUnfreezeTime(Long unfreezeTime){
		this.unfreezeTime = unfreezeTime;
	}
	public String getMonth(){
		return this.month;
	}
	public void setMonth(String month){
		this.month = month;
	}
	public Byte getUserType(){
		return this.userType;
	}
	public void setUserType(Byte userType){
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "RptWalletLogPage[" +
		"dmId=" + dmId +
		",userId=" + userId +
		",crtime=" + crtime +
		",type=" + type +
		",typeMes=" + typeMes +
		",objNum=" + objNum +
		",money=" + money +
		",unfreezeTime=" + unfreezeTime +
		",month=" + month +
		",userType=" + userType +
		']';
	}

}

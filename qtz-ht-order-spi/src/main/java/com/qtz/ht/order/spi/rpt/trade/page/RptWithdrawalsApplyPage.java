package com.qtz.ht.order.spi.rpt.trade.page;

import java.io.Serializable;

import com.qtz.base.common.Pager;
import com.qtz.ht.order.spi.rpt.trade.vo.RptWithdrawalsApply;

/**
 * Title:RptWithdrawalsApplyPage<br/>
 * Description:(报表专用提现记录表Page分页类)<br/>
 * Copyright: Copyright (c) 2016<br/>
 * Company: 深圳市擎天柱信息科技有限公司<br/>
 * @author  甘佳 jackgrays@matrix.com
 * @version v1.0 2016-03-22
 */
public class RptWithdrawalsApplyPage extends Pager<RptWithdrawalsApply,Long> implements Serializable {

	/**(序列化UID)*/
	private static final long serialVersionUID = 704196949426392888L;
    /**()*/
	private Long dmID;
    /**()*/
	private Long userId;
    /**( 提现金额)*/
	private Double money;
    /**(收款卡号)*/
	private String receivablesNum;
    /**(收款银行名字)*/
	private String backName;
    /**(持卡人名字)*/
	private String cardholderName;
    /**(申请时间)*/
	private Long applyTime;
    /**(0 申请中  1 已处理   2 驳回)*/
	private Byte handleStatus;
    /**(处理时间)*/
	private Long handleTime;
    /**(处理备注)*/
	private String handleNote;
    /**()*/
	private Byte userType;

	public Long getDmID(){
		return this.dmID;
	}
	public void setDmID(Long dmID){
		this.dmID = dmID;
	}
	public Long getUserId(){
		return this.userId;
	}
	public void setUserId(Long userId){
		this.userId = userId;
	}
	public Double getMoney(){
		return this.money;
	}
	public void setMoney(Double money){
		this.money = money;
	}
	public String getReceivablesNum(){
		return this.receivablesNum;
	}
	public void setReceivablesNum(String receivablesNum){
		this.receivablesNum = receivablesNum;
	}
	public String getBackName(){
		return this.backName;
	}
	public void setBackName(String backName){
		this.backName = backName;
	}
	public String getCardholderName(){
		return this.cardholderName;
	}
	public void setCardholderName(String cardholderName){
		this.cardholderName = cardholderName;
	}
	public Long getApplyTime(){
		return this.applyTime;
	}
	public void setApplyTime(Long applyTime){
		this.applyTime = applyTime;
	}
	public Byte getHandleStatus(){
		return this.handleStatus;
	}
	public void setHandleStatus(Byte handleStatus){
		this.handleStatus = handleStatus;
	}
	public Long getHandleTime(){
		return this.handleTime;
	}
	public void setHandleTime(Long handleTime){
		this.handleTime = handleTime;
	}
	public String getHandleNote(){
		return this.handleNote;
	}
	public void setHandleNote(String handleNote){
		this.handleNote = handleNote;
	}
	public Byte getUserType(){
		return this.userType;
	}
	public void setUserType(Byte userType){
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "RptWithdrawalsApplyPage[" +
		"dmID=" + dmID +
		",userId=" + userId +
		",money=" + money +
		",receivablesNum=" + receivablesNum +
		",backName=" + backName +
		",cardholderName=" + cardholderName +
		",applyTime=" + applyTime +
		",handleStatus=" + handleStatus +
		",handleTime=" + handleTime +
		",handleNote=" + handleNote +
		",userType=" + userType +
		']';
	}

}

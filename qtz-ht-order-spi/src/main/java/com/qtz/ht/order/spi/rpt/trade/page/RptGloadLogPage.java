package com.qtz.ht.order.spi.rpt.trade.page;

import java.io.Serializable;

import com.qtz.base.common.Pager;
import com.qtz.ht.order.spi.rpt.trade.vo.RptGloadLog;

/**
 * Title:RptGloadLogPage<br/>
 * Description:(报表专用金币记录表Page分页类)<br/>
 * Copyright: Copyright (c) 2016<br/>
 * Company: 深圳市擎天柱信息科技有限公司<br/>
 * @author  甘佳 jackgrays@matrix.com
 * @version v1.0 2016-03-14
 */
public class RptGloadLogPage extends Pager<RptGloadLog,Long> implements Serializable {

	/**(序列化UID)*/
	private static final long serialVersionUID = -2458991583459521336L;
    /**()*/
	private Long dmId;
    /**(用户ID)*/
	private Long userId;
    /**(操作时间)*/
	private Long crtime;
    /**(操作类型   1消费赠送    20 消费返现)*/
	private Short type;
    /**(操作类型说明)*/
	private String typeMes;
    /**(操作流水号)*/
	private String objnum;
    /**(操作金额)*/
	private Integer gloadNum;
    /**()*/
	private String month;

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
	public String getObjnum(){
		return this.objnum;
	}
	public void setObjnum(String objnum){
		this.objnum = objnum;
	}
	public Integer getGloadNum(){
		return this.gloadNum;
	}
	public void setGloadNum(Integer gloadNum){
		this.gloadNum = gloadNum;
	}
	public String getMonth(){
		return this.month;
	}
	public void setMonth(String month){
		this.month = month;
	}

	@Override
	public String toString() {
		return "RptGloadLogPage[" +
		"dmId=" + dmId +
		",userId=" + userId +
		",crtime=" + crtime +
		",type=" + type +
		",typeMes=" + typeMes +
		",objnum=" + objnum +
		",gloadNum=" + gloadNum +
		",month=" + month +
		']';
	}

}

package com.qtz.ht.order.spi.order.page;
import com.qtz.base.common.Pager;
/**
 * <p>Title:OrderLogPage</p>
 * <p>Description:订单分页类</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
 * @author 涂鑫 -xin.tu
 * @version v1.0 2015-09-22
 */
public class OrderLogPage extends Pager<com.qtz.ht.order.spi.order.vo.OrderLog,java.lang.Long> implements java.io.Serializable{

	/**类的版本号*/
	private static final long serialVersionUID = 1329561157453825L;

		/**  */	private java.lang.Long dmId;	/** 订单id */	private java.lang.Long orderId;	/** 下单时间 */	private java.lang.Long time;	/** 订单状态 */	private java.lang.Integer status;
	/**
	 * 备注
	 */
	private java.lang.String notes;	public java.lang.Long getDmId() {	    return this.dmId;	}	public void setDmId(java.lang.Long dmId) {	    this.dmId=dmId;	}	public java.lang.Long getOrderId() {	    return this.orderId;	}	public void setOrderId(java.lang.Long orderId) {	    this.orderId=orderId;	}	public java.lang.Long getTime() {	    return this.time;	}	public void setTime(java.lang.Long time) {	    this.time=time;	}	public java.lang.Integer getStatus() {	    return this.status;	}	public void setStatus(java.lang.Integer status) {	    this.status=status;	}
		public java.lang.String getNotes() {
    return notes;
  }
  public void setNotes(java.lang.String notes) {
    this.notes = notes;
  }
  public String toString() {	    return "[" + "dmId:" + getDmId() +"," + "orderId:" + getOrderId() +"," + "time:" + getTime() +"," + "status:" + getStatus() +"]";	}
}
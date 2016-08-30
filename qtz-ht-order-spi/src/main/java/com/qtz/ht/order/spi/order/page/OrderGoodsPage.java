package com.qtz.ht.order.spi.order.page;
import com.qtz.base.common.Pager;
/**
 * <p>Title:OrderGoodsPage</p>
 * <p>Description:订单对应商品分页类</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
 * @author 涂鑫 -xin.tu
 * @version v1.0 2015-09-02
 */
public class OrderGoodsPage extends Pager<com.qtz.ht.order.spi.order.vo.OrderGoods,java.lang.Long> implements java.io.Serializable{

	/**类的版本号*/
	private static final long serialVersionUID = 1301400735860737L;

		/**  */	private java.lang.Long dmId;	/** 订单id */	private java.lang.Long orderId;	/** 商品名字 */	private java.lang.String goodsName;	/** 单个商品数量 */	private java.lang.Integer goodsNum;	/** 商品总额 */	private java.lang.Double goodsTotalPrice;	/** 商品单价 */	private java.lang.Double goodsPrice;	/** 商品id */	private java.lang.Long goodsId;	public java.lang.Long getDmId() {	    return this.dmId;	}	public void setDmId(java.lang.Long dmId) {	    this.dmId=dmId;	}	public java.lang.Long getOrderId() {	    return this.orderId;	}	public void setOrderId(java.lang.Long orderId) {	    this.orderId=orderId;	}	public java.lang.String getGoodsName() {	    return this.goodsName;	}	public void setGoodsName(java.lang.String goodsName) {	    this.goodsName=goodsName;	}	public java.lang.Integer getGoodsNum() {	    return this.goodsNum;	}	public void setGoodsNum(java.lang.Integer goodsNum) {	    this.goodsNum=goodsNum;	}	public java.lang.Double getGoodsTotalPrice() {	    return this.goodsTotalPrice;	}	public void setGoodsTotalPrice(java.lang.Double goodsTotalPrice) {	    this.goodsTotalPrice=goodsTotalPrice;	}	public java.lang.Double getGoodsPrice() {	    return this.goodsPrice;	}	public void setGoodsPrice(java.lang.Double goodsPrice) {	    this.goodsPrice=goodsPrice;	}	public java.lang.Long getGoodsId() {	    return this.goodsId;	}	public void setGoodsId(java.lang.Long goodsId) {	    this.goodsId=goodsId;	}	public String toString() {	    return "[" + "dmId:" + getDmId() +"," + "orderId:" + getOrderId() +"," + "goodsName:" + getGoodsName() +"," + "goodsNum:" + getGoodsNum() +"," + "goodsTotalPrice:" + getGoodsTotalPrice() +"," + "goodsPrice:" + getGoodsPrice() +"," + "goodsId:" + getGoodsId() +"]";	}
}
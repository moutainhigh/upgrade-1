package com.qtz.ht.order.spi.order.vo;

import java.io.Serializable;

import com.qtz.base.dto.VO;
/**
 * 海淘物流信息
 * 
 * @author zxm
 *
 */
public class HtLogistics extends VO<java.lang.Long> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4327410015249493716L;
	/**
	 * 订单ID
	 */
	private Long orderId;
	/**
	 * 物流公司
	 */
	private String express;
	/**
	 * 物流号
	 */
	private String expressCode;
	/**
	 * 创建时间
	 */
	private Long crtime;
	
	
}

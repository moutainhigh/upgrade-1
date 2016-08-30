package com.qtz.ht.order.spi.order.page;

import java.io.Serializable;

import com.qtz.base.common.Pager;
import com.qtz.ht.order.spi.order.vo.SupermarketOrder;

public class SupermarketPage extends Pager<SupermarketOrder, Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2467438037180166834L;

	private Long dmId;
	/**
	 * 批量Id
	 */
	private Long batchId; 
	/**
	 * 0:完成，1:未支付，4：商家接单，7退款中，9:待收货
	 */
	private Integer orderStatus;
	/**
	 * 订单查询起始时间
	 */
	private Long orderStartTime;
	/**
	 * 订单查询结束时间
	 */
	private Long orderEndTime;
	/**
	 * 支付查询起始时间
	 */
	private Long payStartTime;
	/**
	 * 收货人姓名
	 */
	private String receivingName;
	/**
	 * 收货人地址
	 */
	private String receivingAddress;
	/**
	 * 收货人电话 
	 */
	private String receivingPhone;
	/**
	 * 供应商ID
	 */
	private Long sellerId;
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 仓储中心ID  
	 */
	private Long storageId;
	/**
	 * 是否客服务介入0：不介入，1:介入 2：以仲裁
	 */
	private Integer intervention;
	
	/**
	 * 仓库中心名称
	 */
    private String storageName;
    /**
     * 订单类型（1：超市，2：便利店）
     */
    private Integer orderType; 
    /**
     * 便利店消费类型(1：配送订单  2：到店自取订单)
     */
    private Integer consumeType;
    /**
     * 仲裁类型(0:无需仲裁  1:需要仲裁  2：已经仲裁  3:需仲裁和以仲裁)
     */
    private Integer interventionType;

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getReceivingName() {
		return receivingName;
	}

	public void setReceivingName(String receivingName) {
		this.receivingName = receivingName;
	}

	public String getReceivingAddress() {
		return receivingAddress;
	}

	public void setReceivingAddress(String receivingAddress) {
		this.receivingAddress = receivingAddress;
	}

	public String getReceivingPhone() {
		return receivingPhone;
	}

	public void setReceivingPhone(String receivingPhone) {
		this.receivingPhone = receivingPhone;
	}

	public Long getDmId() {
		return dmId;
	}

	public void setDmId(Long dmId) {
		this.dmId = dmId;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Long getOrderStartTime() {
		return orderStartTime;
	}

	public void setOrderStartTime(Long orderStartTime) {
		this.orderStartTime = orderStartTime;
	}

	public Long getOrderEndTime() {
		return orderEndTime;
	}

	public void setOrderEndTime(Long orderEndTime) {
		this.orderEndTime = orderEndTime;
	}

	public Long getPayStartTime() {
		return payStartTime;
	}

	public void setPayStartTime(Long payStartTime) {
		this.payStartTime = payStartTime;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getStorageId() {
		return storageId;
	}

	public void setStorageId(Long storageId) {
		this.storageId = storageId;
	}

	public Integer getIntervention() {
		return intervention;
	}

	public void setIntervention(Integer intervention) {
		this.intervention = intervention;
	}

	public String getStorageName() {
		return storageName;
	}

	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}

	public Long getBatchId() {
		return batchId;
	}

	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}

    public Integer getOrderType()
    {
    
        return orderType;
    }

    public void setOrderType(Integer orderType)
    {
    
        this.orderType = orderType;
    }

    public Integer getConsumeType()
    {
    
        return consumeType;
    }

    public void setConsumeType(Integer consumeType)
    {
    
        this.consumeType = consumeType;
    }

	public Integer getInterventionType() {
		return interventionType;
	}

	public void setInterventionType(Integer interventionType) {
		this.interventionType = interventionType;
	}

}

package com.qtz.ht.order.spi.order.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.qtz.base.dto.VO;

/**
 * 超市订单类
 * 
 * @author zxm
 *
 */
public class SupermarketOrder extends VO<Long> implements Serializable {

	private static final long serialVersionUID = -1064228053734625446L;

	/**
	 * 批量Id
	 */
	private Long batchId;
	/**
	 * 订单ID
	 */
	private String orderStringID;
	/**
	 * 0:完成，1:未支付，2:同意退款3：拒绝接单 5：商家待接单，7退款中，8：不同意退款 ，4:待收货
	 */
	private Integer orderStatus;
	/**
	 * 订单金额
	 */
	private Double orderPrice;
	/**
	 * 优惠金额
	 */
	private Double couponPrice;
	/**
	 * 付款金额
	 */
	private Double paymentPrice;
	/**
	 * 第三方流水号
	 */
	private String threeSerialNumber;
	/**
	 * 优惠ID
	 */
	private Long couponId;
	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 供应商ID
	 */
	private Long sellerId;
	/**
	 * 下单时间
	 */
	private Long crtime;
	/**
	 * 支付时间
	 */
	private Long payTime;
	/**
	 * 完成时间
	 */
	private Long completeTime;
	/**
	 * 申请退款时间
	 */
	private Long applyTime;
	/**
	 * 订单备注
	 */
	private String note;
	/**
	 * 支付类型 如：支付宝支付 微信支付
	 */
	private Integer payType;
	/**
	 * 商品数量
	 */
	private Integer goodsCount;

	/**
	 * 会员期望送达时间
	 */
	private Long expectedTime;
	/**
	 * 收货手机号码
	 */
	private String receivingPhone;
	/**
	 * 收货名字
	 */
	private String receivingName;
	/**
	 * 收货地址
	 */
	private String receivingAddress;
	/**
	 * 订单类型（1：超市，2：便利店）
	 */
	private Integer orderType;
	/**
	 * 仓储中心ID  
	 */
	private Long storageId;
	/**
	 * 仓库中心名称
	 */
    private String storageName;
	/**
	 * 接单是否打印(0:打印 1：不打印)
	 */
	private Integer printFlag;
	
	/**
	 * 是否客服务介入0：不介入，1:介入 2：以仲裁
	 */
	private Integer intervention;
	/**
	 * 便利店消费类型(1：配送订单  2：到店自取订单)
	 */
	private Integer consumeType;
	/**
	 * 接单/拒接单时间
	 */
	private Long handleTime;
	/**
	 * 超市行业ID
	 */
	private String categoryId;
	/**
	 * 补贴金额（根据折扣率算出）
	 */
	private Double deductionPrice;
	/**
	 * 折扣率(当前订单)
	 */
	private Integer discountPercent;
	/**
	 * 可消费补贴名称
	 */
	private String constantName;
	/**
	 * 可消费补贴KEY值
	 */
	private String constantKey;
	
	public Long getStorageId() {
		return storageId;
	}

	public void setStorageId(Long storageId) {
		this.storageId = storageId;
	}

	private List<SupermarketGoods> SupermarketGoods = new ArrayList<>();
	
	private List<SupermarketOrderApply> supermarketOrderApplieList;
	
	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public List<SupermarketGoods> getSupermarketGoods() {
		return SupermarketGoods;
	}

	public void setSupermarketGoods(List<SupermarketGoods> supermarketGoods) {
		SupermarketGoods = supermarketGoods;
	}

	@Override
	public Long getDmId() {
	    return this.dmId;
	}
	
	@Override
	public void setDmId(Long dmId) {
	    this.dmId=dmId;
	}
	
	public Long getBatchId() {
		return batchId;
	}

	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}

	public String getOrderStringID() {
		return orderStringID;
	}

	public void setOrderStringID(String orderStringID) {
		this.orderStringID = orderStringID;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Double getCouponPrice() {
		return couponPrice;
	}

	public void setCouponPrice(Double couponPrice) {
		this.couponPrice = couponPrice;
	}

	public Double getPaymentPrice() {
		return paymentPrice;
	}

	public void setPaymentPrice(Double paymentPrice) {
		this.paymentPrice = paymentPrice;
	}

	public String getThreeSerialNumber() {
		return threeSerialNumber;
	}

	public void setThreeSerialNumber(String threeSerialNumber) {
		this.threeSerialNumber = threeSerialNumber;
	}

	public Long getCouponId() {
		return couponId;
	}

	public void setCouponId(Long couponId) {
		this.couponId = couponId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public Long getCrtime() {
		return crtime;
	}

	public void setCrtime(Long crtime) {
		this.crtime = crtime;
	}

	public Long getPayTime() {
		return payTime;
	}

	public void setPayTime(Long payTime) {
		this.payTime = payTime;
	}

	public Long getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(Long completeTime) {
		this.completeTime = completeTime;
	}

	public Long getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Long applyTime) {
		this.applyTime = applyTime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public Integer getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(Integer goodsCount) {
		this.goodsCount = goodsCount;
	}

	public Long getExpectedTime() {
		return expectedTime;
	}

	public void setExpectedTime(Long expectedTime) {
		this.expectedTime = expectedTime;
	}

	public String getReceivingPhone() {
		return receivingPhone;
	}

	public void setReceivingPhone(String receivingPhone) {
		this.receivingPhone = receivingPhone;
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

	public Integer getPrintFlag() {
		return printFlag;
	}

	public void setPrintFlag(Integer printFlag) {
		this.printFlag = printFlag;
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

	public Integer getConsumeType()
    {
    
        return consumeType;
    }

    public void setConsumeType(Integer consumeType)
    {
    
        this.consumeType = consumeType;
    }

    public List<SupermarketOrderApply> getSupermarketOrderApplieList()
    {
    
        return supermarketOrderApplieList;
    }

    public void setSupermarketOrderApplieList(
        List<SupermarketOrderApply> supermarketOrderApplieList)
    {
    
        this.supermarketOrderApplieList = supermarketOrderApplieList;
    }

    public Long getHandleTime()
    {
    
        return handleTime;
    }

    public void setHandleTime(Long handleTime)
    {
    
        this.handleTime = handleTime;
    }

    public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public Double getDeductionPrice() {
		return deductionPrice;
	}

	public void setDeductionPrice(Double deductionPrice) {
		this.deductionPrice = deductionPrice;
	}

	public Integer getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(Integer discountPercent) {
		this.discountPercent = discountPercent;
	}

	public String getConstantName() {
		return constantName;
	}

	public void setConstantName(String constantName) {
		this.constantName = constantName;
	}

	public String getConstantKey() {
		return constantKey;
	}

	public void setConstantKey(String constantKey) {
		this.constantKey = constantKey;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

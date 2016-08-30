package com.qtz.ht.order.spi.order.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.qtz.base.dto.VO;

/**
 * 超市订单商品
 * 
 * @author zxm
 *
 */
public class SupermarketGoods extends VO<Long> implements Serializable {

	private static final long serialVersionUID = -1456663304095356321L;

	/**
	 * 订单id
	 */
	private Long orderId;
	/**
	 * 商品名字
	 */
	private String goodsName;
	/**
	 * 单个商品数量
	 */
	private Integer goodsNum;
	/**
	 * 商品单价
	 */
	private Double goodsPrice;
	/**
	 * 供应价
	 */
	private Double supplyPrice;
	/**
	 * 便利店管理公司溢价率
	 */
	private double storePercent;
	/**
	 * 超市管理公司溢价率
	 * 
	 */
	private double supermarketPercent;
	/**
	 * 供应链溢价率
	 */
	private double supplyChainPercent;
	/**
	 * 云存储溢价率
	 */
	private double storagePercent;
	/**
	 * 优惠价
	 */
	private Double discountPrice;
	/**
	 * 商品id
	 */
	private Long goodsId;
	/**
	 * 商品图片
	 */
	private String goodsImg;
	/**
	 * 商品描述
	 */
	private String remark;
	/**
	 * 商品属性值信息
	 */
	private String goodsProValMsg;
	/** 
	 * 商家ID 
	 */
    private Long sellerId;
	/**
	 *库存ID
	 */
	private Long skuId;
	/**
	 * 商品规格
	 */
	private String goodsSpec;
	/**
	 * 商品编码
	 */
	private String goodsCode;
	/**
	 * 供应商ID
	 */
	private Long supplierId;
	
	@Override
	public Long getDmId() {
		// TODO Auto-generated method stub
		return super.getDmId();
	}

	@Override
	public void setDmId(Long dmId) {
		// TODO Auto-generated method stub
		super.setDmId(dmId);
	}
	
	public double getStorePercent() {
		return storePercent;
	}

	public void setStorePercent(double storePercent) {
		this.storePercent = storePercent;
	}

	public double getSupermarketPercent() {
		return supermarketPercent;
	}

	public void setSupermarketPercent(double supermarketPercent) {
		this.supermarketPercent = supermarketPercent;
	}

	public double getSupplyChainPercent() {
		return supplyChainPercent;
	}

	public void setSupplyChainPercent(double supplyChainPercent) {
		this.supplyChainPercent = supplyChainPercent;
	}

	public double getStoragePercent() {
		return storagePercent;
	}

	public void setStoragePercent(double storagePercent) {
		this.storagePercent = storagePercent;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

	public Double getSupplyPrice() {
		return supplyPrice;
	}

	public void setSupplyPrice(Double supplyPrice) {
		this.supplyPrice = supplyPrice;
	}

	public Double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}

	public Double getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsImg() {
		return goodsImg;
	}

	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getGoodsProValMsg() {
		return goodsProValMsg;
	}

	public void setGoodsProValMsg(String goodsProValMsg) {
		this.goodsProValMsg = goodsProValMsg;
	}
	
	public String getGoodsSpec() {
		return goodsSpec;
	}

	public void setGoodsSpec(String goodsSpec) {
		this.goodsSpec = goodsSpec;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public Long getSupplierId()
    {
    
        return supplierId;
    }

    public void setSupplierId(Long supplierId)
    {
    
        this.supplierId = supplierId;
    }

    @Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}

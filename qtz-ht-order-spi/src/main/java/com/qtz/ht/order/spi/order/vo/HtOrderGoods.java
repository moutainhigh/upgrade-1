package com.qtz.ht.order.spi.order.vo;
import com.qtz.base.dto.VO;
/**
 * 订单对应商品VO类
 * @author Administrator
 */
public class HtOrderGoods extends VO<java.lang.Long> implements java.io.Serializable {
	
	private static final long serialVersionUID = 1736027318272867558L;
	/**
	 * 订单id
	 */	private Long orderId;	/**
	 *  商品名字 
	 */	private String goodsName;	/**
	 * 商品总额 
	 */
	private Double goodsTotalPrice;
	/**
	 * 商品id
	 */	private Long goodsId;
	/**
	 * 售价
	 */
	private Double saleMoney;
	/**
	 * 原价
	 */
	private Double supMoney;
	/**
	 * 总价
	 */
	private Double countMoney;
	/**
	 * 总原价
	 */
	private Double countSup;
	/**
	 * 总毛利
	 */
	private Double countProfit;
	/**
	 * 数量
	 */
	private Integer goodsNum;
	/**
	 * 发/收货状态:1 未发货  2 已发货  3 已收货   4 缺货
	 */
	private Integer sendType;
	/**
	 * 退货状态:1 没退货  2 有退货
	 */
	private Integer returnType;
	/**
	 * 退货数量
	 */
	private Integer returnNum;
	/**
	 * 物流编号
	 */
	private String logisticCode;
	/**
	 * 发货时间
	 */
	private Long sendTime;
	/**
	 * 收货时间
	 */
	private Long receiptTime;
	/**
	 * 预计收货时间
	 */
	private Long estReceiptTime;
	/**
	 * 快照地址
	 */
	private String quickPhoto;
	/**
	 * 商品主图
	 */
	private String goodImg;
	/**
	 * 优惠金额：总额
	 */
	private Double discountMoney;
	/**
	 * 单品优惠信息
	 */
	private String discountNote;
	/**
	 * 完结状态：1：未完成；2：已完成；3：服务申请中；4：服务仲裁中；5：已取消
	 */
	private Integer endStatus;
	/**
	 * 返现金额：总额
	 */
	private Double rebateMoney;
	/**
	 * 发货单号
	 */
	private Long invoiceNumber;
	/**
	 * 商品编号
	 */
	private String goodSpec;
	/**
	 * 商品的成本价
	 */
	private Double finalPrice;
	/**
	 * 商品总成本价
	 * 
	 */
	private Double totalFinalPrice;
	
	public Double getTotalFinalPrice() {
		return totalFinalPrice;
	}
	public void setTotalFinalPrice(Double totalFinalPrice) {
		this.totalFinalPrice = totalFinalPrice;
	}
	public Double getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(Double finalPrice) {
		this.finalPrice = finalPrice;
	}
	@Override	public java.lang.Long getDmId() {	    return this.dmId;	}
	@Override	public void setDmId(java.lang.Long dmId) {	    this.dmId=dmId;	}
		public String getGoodSpec() {
		return goodSpec;
	}
	public void setGoodSpec(String goodSpec) {
		this.goodSpec = goodSpec;
	}
	public java.lang.Long getOrderId() {	    return this.orderId;	}	public void setOrderId(java.lang.Long orderId) {	    this.orderId=orderId;	}	public java.lang.String getGoodsName() {	    return this.goodsName;	}	public void setGoodsName(java.lang.String goodsName) {	    this.goodsName=goodsName;	}	public java.lang.Double getGoodsTotalPrice() {	    return this.goodsTotalPrice;	}	public void setGoodsTotalPrice(java.lang.Double goodsTotalPrice) {	    this.goodsTotalPrice=goodsTotalPrice;	}	public java.lang.Long getGoodsId() {	    return this.goodsId;	}	public void setGoodsId(java.lang.Long goodsId) {	    this.goodsId=goodsId;	}
	public Double getSaleMoney() {
		return saleMoney;
	}
	public void setSaleMoney(Double saleMoney) {
		this.saleMoney = saleMoney;
	}
	public Double getSupMoney() {
		return supMoney;
	}
	public void setSupMoney(Double supMoney) {
		this.supMoney = supMoney;
	}
	public Double getCountMoney() {
		return countMoney;
	}
	public void setCountMoney(Double countMoney) {
		this.countMoney = countMoney;
	}
	public Double getCountSup() {
		return countSup;
	}
	public void setCountSup(Double countSup) {
		this.countSup = countSup;
	}
	public Double getCountProfit() {
		return countProfit;
	}
	public void setCountProfit(Double countProfit) {
		this.countProfit = countProfit;
	}
	public Integer getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}
	public Integer getSendType() {
		return sendType;
	}
	public void setSendType(Integer sendType) {
		this.sendType = sendType;
	}
	public Integer getReturnType() {
		return returnType;
	}
	public void setReturnType(Integer returnType) {
		this.returnType = returnType;
	}
	public Integer getReturnNum() {
		return returnNum;
	}
	public void setReturnNum(Integer returnNum) {
		this.returnNum = returnNum;
	}
	public String getLogisticCode() {
		return logisticCode;
	}
	public void setLogisticCode(String logisticCode) {
		this.logisticCode = logisticCode;
	}
	public Long getSendTime() {
		return sendTime;
	}
	public void setSendTime(Long sendTime) {
		this.sendTime = sendTime;
	}
	public Long getReceiptTime() {
		return receiptTime;
	}
	public void setReceiptTime(Long receiptTime) {
		this.receiptTime = receiptTime;
	}
	public Long getEstReceiptTime() {
		return estReceiptTime;
	}
	public void setEstReceiptTime(Long estReceiptTime) {
		this.estReceiptTime = estReceiptTime;
	}
	public String getQuickPhoto() {
		return quickPhoto;
	}
	public void setQuickPhoto(String quickPhoto) {
		this.quickPhoto = quickPhoto;
	}
	public String getGoodImg() {
		return goodImg;
	}
	public void setGoodImg(String goodImg) {
		this.goodImg = goodImg;
	}
	public Double getDiscountMoney() {
		return discountMoney;
	}
	public void setDiscountMoney(Double discountMoney) {
		this.discountMoney = discountMoney;
	}
	public String getDiscountNote() {
		return discountNote;
	}
	public void setDiscountNote(String discountNote) {
		this.discountNote = discountNote;
	}
	public Integer getEndStatus() {
		return endStatus;
	}
	public void setEndStatus(Integer endStatus) {
		this.endStatus = endStatus;
	}
	public Double getRebateMoney() {
		return rebateMoney;
	}
	public void setRebateMoney(Double rebateMoney) {
		this.rebateMoney = rebateMoney;
	}
	public Long getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(Long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public HtOrderGoods() {
	}
	public void set(Long orderId, String goodsName,
			Double goodsTotalPrice, Long goodsId,
			Double saleMoney, Double supMoney, Double countMoney,
			Double countSup, Double countProfit, Integer goodsNum,
			Integer sendType, Integer returnType, Integer returnNum,
			String logisticCode, Long sendTime,
			Long receiptTime, Long estReceiptTime, String quickPhoto,
			String goodImg, Double discountMoney, String discountNote,
			Integer endStatus, Double rebateMoney, Long invoiceNumber, String goodSpec, Double finalPrice, Double totalFinalPrice) {
		this.orderId = orderId;
		this.goodsName = goodsName;
		this.goodsTotalPrice = goodsTotalPrice;
		this.goodsId = goodsId;
		this.saleMoney = saleMoney;
		this.supMoney = supMoney;
		this.countMoney = countMoney;
		this.countSup = countSup;
		this.countProfit = countProfit;
		this.goodsNum = goodsNum;
		this.sendType = sendType;
		this.returnType = returnType;
		this.returnNum = returnNum;
		this.logisticCode = logisticCode;
		this.sendTime = sendTime;
		this.receiptTime = receiptTime;
		this.estReceiptTime = estReceiptTime;
		this.quickPhoto = quickPhoto;
		this.goodImg = goodImg;
		this.discountMoney = discountMoney;
		this.discountNote = discountNote;
		this.endStatus = endStatus;
		this.rebateMoney = rebateMoney;
		this.invoiceNumber = invoiceNumber;
		this.goodSpec = goodSpec;
		this.finalPrice = finalPrice;
		this.totalFinalPrice = totalFinalPrice;
	}
	}
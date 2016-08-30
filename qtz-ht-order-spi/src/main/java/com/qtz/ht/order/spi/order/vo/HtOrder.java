package com.qtz.ht.order.spi.order.vo;
import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.qtz.base.dto.VO;

/**
 * 海淘订单vo
 * @author Administrator
 */
public class HtOrder extends VO<java.lang.Long> implements Serializable {

	private static final long serialVersionUID = 7664747241808925220L;
	/**
	 * 批次号
	 */   
	private Long batchId;
	/**
	 * 供应商ID
	 */
	private Long staffCode;
	/**
	 * 供应商名称
	 */
	private String staffName;
	/**
	 * 会员ID
	 */
	private Long vipCode;
	/**
	 * 会员名字
	 */
	private String vipName;
	/**
	 * 商品总价(平台扣完折扣后的商品总价)
	 */
	private Double goodtMoney;
	/**
	 * 运费
	 */
	private Double freightMoney;
	/**
	 * 优惠费用：红包，活动减少
	 */
	private Double disMoney;
	/**
	 * 订单总价:商品总价 
	 */
	private Double countMoney;
	/**
	 * 实付金额
	 */
	private Double payMoney;
	/**
	 * 支付类型   1 ：支付宝; 2： 微信; 3 ：钱包支付.
	 */
	private String paymentWay;
	/**
	 * 订单成本金额
	 */
	private Double finalMoney;
	/**
	 * 总成本:商品总进货价
	 */
	private Double countSupMoney;
	/**
	 * 总毛利:实付金额 - 运费 - 总成本
	 */
	private Double countProfitMoney;
	/**
	 * 订单收货状态:1未发货 2 已发货 3退货中
	 */
	private Integer reciptType;
	/**
	 * 商品数量
	 */
	private int goodsNum;
	/**
	 * 订单创建时间
	 */
	private Long crtime;
	/**
	 * 订单付款时间
	 */
	private Long payTime;
	/**
	 * 订单失效时间
	 */
	private Long failureTime;
	/**
	 * 申请退款时间
	 */
	private Long applyTime;
	/**
	 * 同意退款时间
	 */
	private Long agreeTime;
	/**
	 * 收货人
	 */
	private String consignee;
	/**
	 * 省份id
	 */
	private Long provinceId;
	/**
	 * 市区id
	 */
	private Long cityId;
	/**
	 * 县级id
	 */
	private Long countyId;
	/**
	 * 镇级id
	 */
	private Long townId;
	/**
	 * 详细地址
	 */
	private String detailAddr;
	/**
	 * 门牌号
	 */
	private String houseNumber;
	/**
	 * 手机号
	 */
	private String mphoneNo;
	/**
	 * 固定电话
	 */
	private String fixphoneNo;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 会员说明
	 */
	private String noteVip;
	/**
	 * 厂家说明
	 */
	private String noteFac;
	/**
	 * 状态：6:关闭,1下单 未支付,5:待发货,4:已发货,7:申请退款/退货中,0:交易成功, 2：商家同意退款， 8:商家拒绝退款
	 */
	private Integer status;
	/**
	 * 快递公司
	 */
	private String express;
	/**
	 * 快递单号
	 */
	private String expressCode;
	/**
	 * 发货时间
	 */
	private Long deliveryTime;
	/**
	 * 运送方式id
	 */
	private Long sendTypeid;
	/**
	 * 总返利金额
	 */
	private Double totalRebateMoney;
	/**
	 * 订单来源，1安卓，2苹果，3微商城
	 */
	private Integer sourceType;
	/**
	 * 平台说明
	 */
	private String noteMan;
	/**
	 * 第三方流水号
	 */
	private String threeSerialNumber;
	/**
	 * 完成时间
	 */
	private Long completeTime;
	/**
	 * 是否客服务介入0：不介入，1:介入
	 */
	private Integer intervention;
	/**
	 * 用户是否发货 0 ：用户未发货，1：用户已发货,2:用户未收到货
	 */
	private Integer userDeliver;
	/**
	 * 订单商品列表集合
	 * 
	 */
	private List<HtOrderGoods> htOrderGoodsList;
	/**
	 * 订单申请信息集合
	 */
	private List<HtOrderApply> htOrderApplieList;
	/**
	 * 身份ID
	 */
	private String idCard;
	/**
	 * 隐藏身份ID
	 */
	private String hideIdCard;
	/**
	 * 海淘行业ID 
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
	
	public Double getFinalMoney() {
		return finalMoney;
	}
	public void setFinalMoney(Double finalMoney) {
		this.finalMoney = finalMoney;
	}
	public String getHideIdCard() {
		return hideIdCard;
	}
	public void setHideIdCard(String hideIdCard) {
		this.hideIdCard = hideIdCard;
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
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public Integer getUserDeliver() {
		return userDeliver;
	}
	public void setUserDeliver(Integer userDeliver) {
		this.userDeliver = userDeliver;
	}
	public Integer getIntervention() {
		return intervention;
	}
	public void setIntervention(Integer intervention) {
		this.intervention = intervention;
	}
	public Long getCompleteTime() {
		return completeTime;
	}
	public void setCompleteTime(Long completeTime) {
		this.completeTime = completeTime;
	}
	public List<HtOrderApply> getHtOrderApplieList() {
		return htOrderApplieList;
	}
	public void setHtOrderApplieList(List<HtOrderApply> htOrderApplieList) {
		this.htOrderApplieList = htOrderApplieList;
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
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
	public Long getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Long applyTime) {
		this.applyTime = applyTime;
	}
	public Long getAgreeTime() {
		return agreeTime;
	}
	public void setAgreeTime(Long agreeTime) {
		this.agreeTime = agreeTime;
	}
	public String getExpress() {
		return express;
	}
	public void setExpress(String express) {
		this.express = express;
	}
	public String getExpressCode() {
		return expressCode;
	}
	public void setExpressCode(String expressCode) {
		this.expressCode = expressCode;
	}
	public Long getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(Long deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public Long getStaffCode() {
		return staffCode;
	}
	public void setStaffCode(Long staffCode) {
		this.staffCode = staffCode;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public Long getVipCode() {
		return vipCode;
	}
	public void setVipCode(Long vipCode) {
		this.vipCode = vipCode;
	}
	public String getVipName() {
		return vipName;
	}
	public void setVipName(String vipName) {
		this.vipName = vipName;
	}
	public Double getGoodtMoney() {
		return goodtMoney;
	}
	public void setGoodtMoney(Double goodtMoney) {
		this.goodtMoney = goodtMoney;
	}
	public Double getFreightMoney() {
		return freightMoney;
	}
	public void setFreightMoney(Double freightMoney) {
		this.freightMoney = freightMoney;
	}
	public Double getDisMoney() {
		return disMoney;
	}
	public void setDisMoney(Double disMoney) {
		this.disMoney = disMoney;
	}
	public Double getCountMoney() {
		return countMoney;
	}
	public void setCountMoney(Double countMoney) {
		this.countMoney = countMoney;
	}
	public Double getPayMoney() {
		return payMoney;
	}
	public void setPayMoney(Double payMoney) {
		this.payMoney = payMoney;
	}
	public String getPaymentWay() {
		return paymentWay;
	}
	public void setPaymentWay(String paymentWay) {
		this.paymentWay = paymentWay;
	}
	public Double getCountSupMoney() {
		return countSupMoney;
	}
	public void setCountSupMoney(Double countSupMoney) {
		this.countSupMoney = countSupMoney;
	}
	public Double getCountProfitMoney() {
		return countProfitMoney;
	}
	public void setCountProfitMoney(Double countProfitMoney) {
		this.countProfitMoney = countProfitMoney;
	}
	public Integer getReciptType() {
		return reciptType;
	}
	public void setReciptType(Integer reciptType) {
		this.reciptType = reciptType;
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
	public Long getFailureTime() {
		return failureTime;
	}
	public void setFailureTime(Long failureTime) {
		this.failureTime = failureTime;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public Long getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}
	public Long getCityId() {
		return cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	public Long getCountyId() {
		return countyId;
	}
	public void setCountyId(Long countyId) {
		this.countyId = countyId;
	}
	public Long getTownId() {
		return townId;
	}
	public void setTownId(Long townId) {
		this.townId = townId;
	}
	public String getDetailAddr() {
		return detailAddr;
	}
	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getMphoneNo() {
		return mphoneNo;
	}
	public void setMphoneNo(String mphoneNo) {
		this.mphoneNo = mphoneNo;
	}
	public String getFixphoneNo() {
		return fixphoneNo;
	}
	public void setFixphoneNo(String fixphoneNo) {
		this.fixphoneNo = fixphoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNoteVip() {
		return noteVip;
	}
	public void setNoteVip(String noteVip) {
		this.noteVip = noteVip;
	}
	public String getNoteFac() {
		return noteFac;
	}
	public void setNoteFac(String noteFac) {
		this.noteFac = noteFac;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getSendTypeid() {
		return sendTypeid;
	}
	public void setSendTypeid(Long sendTypeid) {
		this.sendTypeid = sendTypeid;
	}
	public Double getTotalRebateMoney() {
		return totalRebateMoney;
	}
	public void setTotalRebateMoney(Double totalRebateMoney) {
		this.totalRebateMoney = totalRebateMoney;
	}
	public Integer getSourceType() {
		return sourceType;
	}
	public void setSourceType(Integer sourceType) {
		this.sourceType = sourceType;
	}
	
	public String getNoteMan() {
		return noteMan;
	}
	public void setNoteMan(String noteMan) {
		this.noteMan = noteMan;
	}
	public Long getBatchId() {
		return batchId;
	}
	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}
	
	public List<HtOrderGoods> getHtOrderGoodsList() {
		return htOrderGoodsList;
	}
	public void setHtOrderGoodsList(List<HtOrderGoods> htOrderGoodsList) {
		this.htOrderGoodsList = htOrderGoodsList;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	public void set(Long dmId,Long batchId, Long staffCode, String staffName,
			Long vipCode, String vipName, Double goodtMoney,
			Double freightMoney, Double disMoney, Double countMoney,
			Double payMoney, String paymentWay, Double countSupMoney,
			Double countProfitMoney,
			Integer reciptType, Long crtime, Long payTime, Long deliverTime,
			Long failureTime, String consignee,
			Long provinceId, Long cityId, Long countyId, Long townId,
			String detailAddr, String houseNumber, String mphoneNo,
			String fixphoneNo, String email, String noteVip, String noteFac,
			Integer status, Long sendTypeid,Double totalRebateMoney, Integer sourceType, String note_man, int goodsNum,String idCard, String hideIdCard, String categoryId, Double finalMoney) {
		this.dmId = dmId;
		this.batchId = batchId;
		this.staffCode = staffCode;
		this.staffName = staffName;
		this.vipCode = vipCode;
		this.vipName = vipName;
		this.goodtMoney = goodtMoney;
		this.freightMoney = freightMoney;
		this.disMoney = disMoney;
		this.countMoney = countMoney;
		this.payMoney = payMoney;
		this.paymentWay = paymentWay;
		this.countSupMoney = countSupMoney;
		this.countProfitMoney = countProfitMoney;
		this.reciptType = reciptType;
		this.crtime = crtime;
		this.payTime = payTime;
		this.deliveryTime = deliverTime;
		this.failureTime = failureTime;
		this.consignee = consignee;
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.countyId = countyId;
		this.townId = townId;
		this.detailAddr = detailAddr;
		this.houseNumber = houseNumber;
		this.mphoneNo = mphoneNo;
		this.fixphoneNo = fixphoneNo;
		this.email = email;
		this.noteVip = noteVip;
		this.noteFac = noteFac;
		this.status = status;
		this.sendTypeid = sendTypeid;
		this.totalRebateMoney = totalRebateMoney;
		this.sourceType = sourceType;
		this.noteMan = note_man;
		this.goodsNum = goodsNum;
		this.idCard = idCard;
		this.hideIdCard = hideIdCard;
		this.categoryId = categoryId;
		this.finalMoney = finalMoney;
	}
	
	public String getThreeSerialNumber() {
		return threeSerialNumber;
	}
	public void setThreeSerialNumber(String threeSerialNumber) {
		this.threeSerialNumber = threeSerialNumber;
	}
	
}
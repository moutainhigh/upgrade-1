package com.qtz.ht.spi.good.vo;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.qtz.base.dto.VO;
/**
 * <p>Title:HtStaffGoods</p>
 * <p>Description:商户商品操作记录VO类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: 深圳市好实再商贸有限公司</p>
 * @author tanglijun
 * @version v1.0 2016-04-07
 */
public class HtStaffGoods extends VO<Long> implements java.io.Serializable {
	
	/**类的版本号*/
	private static final long serialVersionUID = 1609975852992512L;

	
	/**
	 * 商品成本价格
	 */
	private Double finalPrice;
	/** 非数据库字段 ，购买数量*/
	private Integer buyNumber;
	/** 全称 */
	private String fullName;
	/** 手机 */
	private String mobilePhone;
	/** 法人 */
	private String legalPerson;
	
	
	public Integer getBuyNumber() {
		return buyNumber;
	}
	public void setBuyNumber(Integer buyNumber) {
		this.buyNumber = buyNumber;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getLegalPerson() {
		return legalPerson;
	}
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	
	public Double getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(Double finalPrice) {
		this.finalPrice = finalPrice;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
package com.qtz.ht.session.spi.wallet.page;
import java.io.Serializable;

import com.qtz.base.common.Pager;
import com.qtz.ht.session.spi.wallet.vo.HtBankCard;
/**
 * <p>Title:HtBankCardPage</p>
 * <p>Description:商户银行卡信息表分页类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: 深圳擎天柱信息技术有限公司</p>
 * @author 唐礼军 - 1309025893@qq.com
 * @version v1.0 2016-06-21
 */
public class HtBankCardPage extends Pager<HtBankCard,Long> implements Serializable{

	/**类的版本号*/
	private static final long serialVersionUID = 1715845820172289L;

		/**  */	private java.lang.Long dmId;	/**  */	private java.lang.Long busiId;	/** 银行卡号 */	private java.lang.String cardNum;	/** 开户行名称 */	private java.lang.String bankName;	/** 支行名称 */	private java.lang.String bankBranch;	/** 开户行所在省 */	private java.lang.Long accountProvince;	/** 开户行所在市 */	private java.lang.Long accountCity;	/** 银行账户类型 0 对公 1对私 */	private java.lang.Integer accountType;	/** 持卡人 */	private java.lang.String cardholder;	/** 添加人id */	private java.lang.Long crUser;	/** 添加时间 */	private java.lang.Long crTime;	public java.lang.Long getDmId() {	    return this.dmId;	}	public void setDmId(java.lang.Long dmId) {	    this.dmId=dmId;	}	public java.lang.Long getBusiId() {	    return this.busiId;	}	public void setBusiId(java.lang.Long busiId) {	    this.busiId=busiId;	}	public java.lang.String getCardNum() {	    return this.cardNum;	}	public void setCardNum(java.lang.String cardNum) {	    this.cardNum=cardNum;	}	public java.lang.String getBankName() {	    return this.bankName;	}	public void setBankName(java.lang.String bankName) {	    this.bankName=bankName;	}	public java.lang.String getBankBranch() {	    return this.bankBranch;	}	public void setBankBranch(java.lang.String bankBranch) {	    this.bankBranch=bankBranch;	}	public java.lang.Long getAccountProvince() {	    return this.accountProvince;	}	public void setAccountProvince(java.lang.Long accountProvince) {	    this.accountProvince=accountProvince;	}	public java.lang.Long getAccountCity() {	    return this.accountCity;	}	public void setAccountCity(java.lang.Long accountCity) {	    this.accountCity=accountCity;	}	public java.lang.Integer getAccountType() {	    return this.accountType;	}	public void setAccountType(java.lang.Integer accountType) {	    this.accountType=accountType;	}	public java.lang.String getCardholder() {	    return this.cardholder;	}	public void setCardholder(java.lang.String cardholder) {	    this.cardholder=cardholder;	}	public java.lang.Long getCrUser() {	    return this.crUser;	}	public void setCrUser(java.lang.Long crUser) {	    this.crUser=crUser;	}	public java.lang.Long getCrTime() {	    return this.crTime;	}	public void setCrTime(java.lang.Long crTime) {	    this.crTime=crTime;	}	public String toString() {	    return "[" + "dmId:" + getDmId() +"," + "busiId:" + getBusiId() +"," + "cardNum:" + getCardNum() +"," + "bankName:" + getBankName() +"," + "bankBranch:" + getBankBranch() +"," + "accountProvince:" + getAccountProvince() +"," + "accountCity:" + getAccountCity() +"," + "accountType:" + getAccountType() +"," + "cardholder:" + getCardholder() +"," + "crUser:" + getCrUser() +"," + "crTime:" + getCrTime() +"]";	}
}
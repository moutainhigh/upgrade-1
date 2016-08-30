package com.qtz.ht.order.spi.order.vo;

import java.io.Serializable;

import com.qtz.base.dto.VO;
/**
 * 
 * 
 * 
 * @author zxm
 *
 */
public class SupermarketOrderApply extends VO<Long> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4434421706470906627L;

	/**
	 * 订单ID
	 */
	private Long orderId;
	/**
	 * 操作类型(1:用户操作：1， 2:商家操作,3:客服介入)
	 */
	private Integer handleType;
	/**
	 * 状态说明 ：7:退款中 2：同意退款， 8:拒绝退款
	 */
	private Integer stateExplain;
	/**
	 * 理由（买家：申请退货理由，商家：拒绝理由）
	 */
	private String reason;
	/**
	 * 商品图片
	 */
	private String goodsImg;
	/**
	 * 创建时间
	 */
	private Long createTime;
	
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

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Integer getHandleType() {
		return handleType;
	}

	public void setHandleType(Integer handleType) {
		this.handleType = handleType;
	}

	public Integer getStateExplain() {
		return stateExplain;
	}

	public void setStateExplain(Integer stateExplain) {
		this.stateExplain = stateExplain;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getGoodsImg() {
		return goodsImg;
	}

	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

}

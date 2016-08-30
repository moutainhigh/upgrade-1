package com.qtz.ht.order.spi.message.vo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.qtz.base.dto.VO;
/**
 * 
 * 
 * @author Administrator
 *
 */
public class Message extends VO<Long> implements Serializable {

	private static final long serialVersionUID = 1216884246565741646L;

	/**
	 * 消息内容　　
	 */
	private String content;
	/**
	 * 类型
	 */
	private Integer type;
	/**
	 * 状态  2 商家同意退款，（其它 消息可能也会用到这个字段）
	 */
	private Integer state;
	/**
	 * 来源ID
	 */
	private Long sourceId;
	/**
	 * 创建时间
	 */
	private Long createTime;
	/**
	 * 用户ID
	 */
	private Long userId;
	
	private Long orderId;
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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

	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Long getSourceId() {
		return sourceId;
	}
	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

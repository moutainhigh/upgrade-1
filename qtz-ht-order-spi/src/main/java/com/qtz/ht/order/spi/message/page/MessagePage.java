package com.qtz.ht.order.spi.message.page;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.qtz.base.common.Pager;
import com.qtz.ht.order.spi.message.vo.Message;

public class MessagePage extends Pager<Message, Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3374084406927727489L;
	
	/**
	 * 消息内容　　
	 */
	private String content;
	/**
	 * 类型
	 */
	private Integer type;
	/**
	 * 状态  1 商家同意退款，（其它 消息可能也会用到这个字段）
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
	
	private Long dmId;
	
	public Long getDmId() {
		return dmId;
	}

	public void setDmId(Long dmId) {
		this.dmId = dmId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Long getSourceId() {
		return sourceId;
	}

	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}

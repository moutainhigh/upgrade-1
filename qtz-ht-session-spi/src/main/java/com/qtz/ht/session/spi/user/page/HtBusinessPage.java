package com.qtz.ht.session.spi.user.page;


import org.apache.commons.lang3.builder.ToStringBuilder;

import com.qtz.base.common.Pager;
import com.qtz.ht.session.spi.user.vo.HtBusiness;
/**
 * <p>Title:HtBusinessPage</p>
 * <p>Description:商户信息表分页类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
 * @author tanglijun
 * @version v1.0 2016-04-08
 */
public class HtBusinessPage extends Pager<HtBusiness,Long> implements java.io.Serializable{

	/**类的版本号*/
	private static final long serialVersionUID = 1611442937595905L;
	
	private Long dmId;
	
	/** 注册时间 */
	private Long crtime;
	/** 开始时间 */
	private Long startTime;
	/** 结束时间 */
	private Long endTime;
	
		return startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	public Long getEndTime() {
		return endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	public Long getCrtime() {
		return crtime;
	}
	public void setCrtime(Long crtime) {
		this.crtime = crtime;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
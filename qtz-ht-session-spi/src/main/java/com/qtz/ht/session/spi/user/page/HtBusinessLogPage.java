package com.qtz.ht.session.spi.user.page;


import org.apache.commons.lang3.builder.ToStringBuilder;

import com.qtz.base.common.Pager;
import com.qtz.ht.session.spi.user.vo.HtBusinessLog;
/**
 * <p>Title:HtBusinessLogPage</p>
 * <p>Description:商户信息日志表分页类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
 * @author tanglijun
 * @version v1.0 2016-04-11
 */
public class HtBusinessLogPage extends Pager<HtBusinessLog,Long> implements java.io.Serializable{

	/**类的版本号*/
	private static final long serialVersionUID = 1615681708705793L;
	
	private Long dmId;
	
		return ToStringBuilder.reflectionToString(this);
	}
}
package com.qtz.ht.spi.system.page;

import com.qtz.base.common.Pager;
import com.qtz.ht.spi.system.vo.HtActivity;

/**
 * <p>Title:HtActivityPage</p>
 * <p>Description:活动管理表分页类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
 * @author tanglijun
 * @version v1.0 2016-08-08
 */
public class HtActivityPage extends Pager<HtActivity,Long> implements java.io.Serializable{

	/**类的版本号*/
	private static final long serialVersionUID = 1783998137092097L;
	
	private Long dmId;
	
}
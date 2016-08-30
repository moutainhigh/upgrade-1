package com.qtz.ht.session.spi.user.page;


import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.qtz.base.common.Pager;
import com.qtz.ht.session.spi.user.vo.HtRole;
/**
 * <p>Title:HtRolePage</p>
 * <p>Description:商户角色分页类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: 深圳市好实再商贸有限公司</p>
 * @author tanglijun
 * @version v1.0 2016-01-25
 */
public class HtRolePage extends Pager<HtRole,Long> implements Serializable{

	/**类的版本号*/
	private static final long serialVersionUID = 1506688407422977L;

	
		return ToStringBuilder.reflectionToString(this);
	}
}
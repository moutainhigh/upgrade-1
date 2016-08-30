package com.qtz.ht.spi.good.page;


import org.apache.commons.lang3.builder.ToStringBuilder;

import com.qtz.base.common.Pager;
import com.qtz.ht.spi.good.vo.HtGoodCate;
/**
 * <p>Title:HtGoodCatePage</p>
 * <p>Description:商户商品分类分页类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
 * @author tanglijun
 * @version v1.0 2016-04-11
 */
public class HtGoodCatePage extends Pager<HtGoodCate,Long> implements java.io.Serializable{

	/**类的版本号*/
	private static final long serialVersionUID = 1615750346164225L;
	
	private Long dmId;
	
}
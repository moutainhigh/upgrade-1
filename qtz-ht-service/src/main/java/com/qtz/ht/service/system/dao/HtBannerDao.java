package com.qtz.ht.service.system.dao;
import java.util.List;

import com.qtz.base.dao.BizDao;
import com.qtz.base.exception.DaoException;
import com.qtz.ht.spi.system.vo.HtBanner;
/**
 * <p>Title:HtBannerDao</p>
 * <p>Description:横幅管理表DAO接口类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
 * @author tanglijun
 * @version v1.0 2016-04-15
 */
public interface HtBannerDao extends BizDao<HtBanner,Long> {


	/**
	* 【首页显示查询列表方法】
	* @param obj
	* @return
	* @throws DaoException  
	*/
	List<HtBanner> findSpecifyFieldList(HtBanner obj)throws DaoException;
	
}
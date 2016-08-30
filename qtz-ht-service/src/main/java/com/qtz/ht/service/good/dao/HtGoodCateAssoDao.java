package com.qtz.ht.service.good.dao;

import com.qtz.base.dao.BizDao;
import com.qtz.base.exception.DaoException;
import com.qtz.ht.spi.good.vo.HtGoodCateAsso;

/**
 * <p>Title:HtGoodCateAssoDao</p>
 * <p>Description:商家商品与分类关联DAO接口类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
 * @author tanglijun
 * @version v1.0 2016-08-10
 */
public interface HtGoodCateAssoDao extends BizDao<HtGoodCateAsso,Long> {
	
	/**
	* 【去重查询已类的商品】
	* @return
	* @throws DaoException  
	*/
	Integer queryGoodsCount()throws DaoException;
}
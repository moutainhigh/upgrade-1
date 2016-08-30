package com.qtz.ht.service.system.dao;

import java.util.List;

import com.qtz.base.common.Pager;
import com.qtz.base.dao.BizDao;
import com.qtz.base.exception.DaoException;
import com.qtz.ht.spi.system.page.HtCategoryPage;
import com.qtz.ht.spi.system.vo.HtCategory;


public interface CategoryDao extends BizDao<HtCategory,Long>  {
		
	/**
	 * 查询海淘在后台的二级唯一分类
	 * @param mark
	 * @return
	 * @throws DaoException
	 */
	HtCategory findVoByMark(String mark)throws DaoException;
	
	/**
	* 【根据parentID查询所有】
	* @param parentId
	* @return
	* @throws DaoException  
	*/
	List<HtCategory> findAllByparentId(Long parentId,Integer status,Integer show)throws DaoException;
	
	/**
	* 【分页查询】
	* @param page
	* @return
	* @throws DaoException  
	*/
	Pager<HtCategory, Long> queryPage(HtCategoryPage page) throws DaoException;
	
	/**
	* 【删除】
	* @param dmId
	* @throws DaoException  
	*/
	void delete(Long dmId)throws DaoException;
	
	/**
	* 【查询序号】
	* @param parentId
	* @return
	* @throws DaoException  
	*/
	public List<HtCategory> queryOrder(Long parentId) throws DaoException;
}

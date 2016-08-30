package com.qtz.ht.order.service.order.dao;

import java.util.List;
import java.util.Map;

import com.qtz.base.dao.BizDao;
import com.qtz.base.exception.DaoException;
import com.qtz.ht.order.spi.order.vo.SupermarketOrder;

public interface SupermarketOrderDao extends BizDao<SupermarketOrder, Long>{
	
	/*public SupermarketPage query(SupermarketPage page) throws DaoException;*/
	
	/*public SupermarketOrder querySupermarketOrderByStorageId(Long storageId) throws DaoException;*/
	
	public List<SupermarketOrder> querySupermarkerByOrderId(SupermarketOrder supermarketOrder) throws DaoException;

	public int physicalIntervention(Integer intervention,Integer orderStatus, Long applyTime) throws DaoException;
	
	public int updateOrderById(Map<String, Object> param) throws DaoException;
}

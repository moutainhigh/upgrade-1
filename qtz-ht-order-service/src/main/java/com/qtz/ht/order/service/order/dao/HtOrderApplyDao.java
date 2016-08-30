package com.qtz.ht.order.service.order.dao;

import java.util.List;

import com.qtz.base.dao.BizDao;
import com.qtz.base.exception.DaoException;
import com.qtz.ht.order.spi.order.vo.HtOrderApply;

public interface HtOrderApplyDao extends BizDao<HtOrderApply,Long>{
	
	/**
	 * 商家同意退款时获得商家的地址信息
	 * 
	 * @param orderId
	 * @param state
	 * @return
	 */
	public HtOrderApply getShopApply(Long orderId) throws DaoException;
	/**
	 * 获得订单申请退款信息集合
	 * 
	 * @param orderId
	 * @return
	 */
	public List<HtOrderApply> getOrderApplyList(Long orderId) throws DaoException;
	
}

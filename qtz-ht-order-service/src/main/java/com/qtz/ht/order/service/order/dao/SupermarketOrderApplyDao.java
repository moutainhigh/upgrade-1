package com.qtz.ht.order.service.order.dao;


import java.util.List;

import com.qtz.base.dao.BizDao;
import com.qtz.base.exception.DaoException;
import com.qtz.ht.order.spi.order.vo.SupermarketOrderApply;

public interface SupermarketOrderApplyDao extends BizDao<SupermarketOrderApply, Long>{
		/**
		  * 查询订单是否符合仲裁
		  * @param orderApply
		  * @return
		  * @throws DaoException List<Long>
		  * @time: 2016年7月5日下午8:09:11
		  * @author 张玉兵
		  * @throws OrderException
		 */
      	public Integer getOrderApplyCount(SupermarketOrderApply orderApply) throws DaoException;
      	/**
      	 * 根据订单号查询退款记录
      	 * description:<br>
      	 * @param orderId
      	 * @return
      	 * @throws DaoException
      	 */
      	public List<SupermarketOrderApply> getOrderApplyList(Long orderId)  throws DaoException;
}

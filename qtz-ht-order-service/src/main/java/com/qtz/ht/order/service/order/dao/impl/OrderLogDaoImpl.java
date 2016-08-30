package com.qtz.ht.order.service.order.dao.impl;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.qtz.base.dao.impl.MyBaitsDaoImpl;
import com.qtz.base.exception.DaoException;
import com.qtz.ht.order.service.order.dao.OrderLogDao;
import com.qtz.ht.order.spi.order.vo.OrderLog;
/**
 * <p>Title:OrderLogDaoImpl</p>
 * <p>Description:订单日志DAO实现类</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
 * @author 涂鑫 -xin.tu
 * @version v1.0 2015-09-08
 */
@Repository("orderLogDaoImpl")
public class OrderLogDaoImpl extends MyBaitsDaoImpl<OrderLog,Long> implements OrderLogDao {
	/**MYBatis命名空间名*/
	private static String preName = OrderLogDao.class.getName();
	/** 
	* 【取得】MYBatis命名空间名
	* @return  	MYBatis命名空间名
	*/
	@Override
	protected String getPreName() {
		return preName;
	}
	@Override
	public List<OrderLog> findByOrderId(Long orderId) throws DaoException {
		OrderLog ol = new OrderLog();
		ol.setOrderId(orderId);
		List<OrderLog> olList = getMyBaitsTemplate().findList(getPreName(), "findByOrderId", ol);
		return olList;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void updateOrderLogByOrderIdNotNull(OrderLog orderLog) throws DaoException{
		if(orderLog==null){
			throw new DaoException("null exception");
		}
		getMyBaitsTemplate().mod(getPreName(), "updateOrderLogByOrderIdNotNull", orderLog);
	}
}
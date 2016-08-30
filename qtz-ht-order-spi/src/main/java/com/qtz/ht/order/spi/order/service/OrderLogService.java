package com.qtz.ht.order.spi.order.service;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.BaseService;
import com.qtz.ht.order.spi.order.vo.OrderLog;
/**
 * <p>Title:OrderLogService</p>
 * <p>Description:订单日志服务接口类</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
 * @author 涂鑫 -xin.tu
 * @version v1.0 2015-09-08
 */
public interface OrderLogService extends BaseService<com.qtz.ht.order.spi.order.vo.OrderLog,java.lang.Long> {
	/**
	 * 
	  * 【订单id 删除订单日志】
	  * @param orderid
	  * @throws ServiceException  
	  * @time:2015年9月25日 下午7:25:16
	  * @author 涂鑫
	  * @version
	 */
	void delOrderLogByOrderId(Long orderid) throws ServiceException;
	/**
	 * 
	  * 【根据订单id 更新不为null 的订单日志】
	  * @param orderLog  
	  * @time:2015年9月17日 上午10:06:59
	  * @author 涂鑫
	  * @version
	 */
	public void updateOrderLogByOrderIdNotNull(OrderLog orderLog) throws ServiceException;
	
	/**
	 * 
	 * 【获取订单日志信息】
	 * @param orderId					订单id
	 * @return
	 * @throws ServiceException  
	 * @time:2015年9月16日 上午11:12:10
	 * @author 聂恒
	 * @version
	 */
	public List<OrderLog> findByOrderId(Long orderId)throws ServiceException; 
	
	
	/**
	 * 
	  * 【获取订单日志】
	  * @param orderId
	  * @return
	  * @throws ServiceException  
	  * @time:2015年9月21日 上午10:39:00
	  * @author 涂鑫
	  * @version
	 */
	public JSONArray getOrderStatus(long orderId) throws ServiceException;
}

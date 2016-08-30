package com.qtz.ht.order.spi.order.service;

import java.util.List;

import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.BaseService;
import com.qtz.ht.order.spi.order.vo.OrderGoods;
/**
 * <p>Title:OrderGoodsService</p>
 * <p>Description:订单对应商品服务接口类</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
 * @author 涂鑫 -xin.tu
 * @version v1.0 2015-09-02
 */
public interface OrderGoodsService extends BaseService<com.qtz.ht.order.spi.order.vo.HtOrderGoods,java.lang.Long> {
	/**
	 * 
	  * 【订单号删除订单商品】
	  * @param orderid
	  * @throws ServiceException  
	  * @time:2015年9月25日 下午7:23:44
	  * @author 涂鑫
	  * @version
	 */
	void delOrderGoodsByOrderId(Long orderid) throws ServiceException;
	/**
	 * 
	  * 【获取订单下商品】
	  * @param orderId				订单id
	  * @return
	  * @throws ServiceException  
	  * @time:2015年10月12日 上午11:33:13
	  * @author 涂鑫
	  * @version
	 */
	List<OrderGoods> getOrderGoodss(Long orderId) throws ServiceException; 
}
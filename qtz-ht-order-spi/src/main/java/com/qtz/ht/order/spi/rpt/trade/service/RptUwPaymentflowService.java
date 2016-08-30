package com.qtz.ht.order.spi.rpt.trade.service;

import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.BaseService;
import com.qtz.ht.order.spi.rpt.trade.vo.RptUwPaymentflow;

/**
 * Title:RptUwPaymentflowService<br/>
 * Description:(报表专用商家货款表SERVICE接口类)<br/>
 * Copyright: Copyright © 2016<br/>
 * Company: 深圳市擎天柱信息技术有限公司<br/>
 * @author 甘佳-jackgrays@matrix.com
 * @version v1.0 2016-04-28
 */
public interface RptUwPaymentflowService extends BaseService<RptUwPaymentflow,Long>{

	/**
	 * 根据订单ID查找商家货款金额
	 * 
	 * @param orderId
	 * @return
	 * @throws ServiceException
	 */
	Double findAmountByOrderId(Long orderId) throws ServiceException;
	
}
package com.qtz.ht.order.spi.rpt.trade.service;

import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.BaseService;
import com.qtz.ht.order.spi.rpt.trade.vo.RptOrderLog;

/**
 * Title:RptOrderLogService<br/>
 * Description:(报表专用订单记录表SERVICE接口类)<br/>
 * Copyright: Copyright (c) 2016<br/>
 * Company: 深圳市擎天柱信息科技有限公司<br/>
 * @author  甘佳 jackgrays@matrix.com
 * @version v1.0 2016-03-14
 */
public interface RptOrderLogService extends BaseService<RptOrderLog,Long>{

    /**
     *  查找交易失败记录的时间
     * @param orderId
     * @return
     * @throws ServiceException
     */
    Long findOrderFailTime(Long orderId) throws ServiceException;
    
    
    /**
     * 查询订单接单时间
     * @param orderId
     * @return
     * @throws ServiceException
     */
    Long findOrderRecieveTime(Long orderId) throws ServiceException;

}
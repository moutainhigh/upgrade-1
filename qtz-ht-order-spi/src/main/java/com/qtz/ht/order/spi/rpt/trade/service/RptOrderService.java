package com.qtz.ht.order.spi.rpt.trade.service;

import java.util.List;

import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.BaseService;
import com.qtz.ht.order.spi.rpt.trade.vo.RptOrder;

/**
 * Title:RptOrderService<br/>
 * Description:(报表专用订单表SERVICE接口类)<br/>
 * Copyright: Copyright (c) 2016<br/>
 * Company: 深圳市擎天柱信息科技有限公司<br/>
 * @author  甘佳 jackgrays@matrix.com
 * @version v1.0 2016-03-11
 */
public interface RptOrderService extends BaseService<RptOrder,Long>{

    /**
     *  查找指定付款时间后(不包含)，指定数量的订单
     * @param minPayTime 最小付款时间
     * @param nums 指定数量
     * @return
     * @throws ServiceException
     */
    List<RptOrder> findPayedOrdersAfterTime(Long minPayTime,int nums) throws ServiceException;

}
package com.qtz.ht.order.spi.rpt.trade.service;

import java.util.List;

import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.BaseService;
import com.qtz.ht.order.spi.rpt.trade.vo.RptOrder;
import com.qtz.ht.order.spi.rpt.trade.vo.RptTradeFlow;

/**
 * Title:RptTradeFlowService<br/>
 * Description:(订单交易明细表SERVICE接口类)<br/>
 * Copyright: Copyright (c) 2016<br/>
 * Company: 深圳市擎天柱信息科技有限公司<br/>
 * @author  甘佳 jackgrays@matrix.com
 * @version v1.0 2016-03-11
 */
public interface RptTradeFlowService extends BaseService<RptTradeFlow,Long>{

    /**
     *  查找已经统计了的最大付款时间
     * @return
     * @throws ServiceException
     */
    long findStatedMaxPayTime() throws ServiceException;

    /**
     *  查找介于两个时间点的记录(左闭区间)
     * @param minTime
     * @param maxTime
     * @return
     * @throws ServiceException
     */
    List<RptTradeFlow> findRecodeBetweenTimes(Long minTime,Long maxTime) throws ServiceException;

    /**
     *  统计订单列表
     * @param rptOrderList
     * @throws ServiceException
     */
    void modStatOrderList(List<RptOrder> rptOrderList) throws ServiceException;

    /**
     *  统计单个订单
     * @param order
     * @throws ServiceException
     */
    void modStatSingleOrder(RptOrder order) throws ServiceException;



}
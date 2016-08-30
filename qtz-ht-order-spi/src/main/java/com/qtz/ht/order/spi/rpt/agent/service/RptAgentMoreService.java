package com.qtz.ht.order.spi.rpt.agent.service;

import java.util.List;

import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.BaseService;
import com.qtz.ht.order.spi.rpt.agent.vo.RptAgentMore;
import com.qtz.ht.order.spi.rpt.common.RptStatTypeEnum;
import com.qtz.ht.order.spi.rpt.trade.vo.RptTradeFlow;

/**
 * Title:RptAgentMoreService<br/>
 * Description:(代理商分润统计表(多)SERVICE接口类)<br/>
 * Copyright: Copyright (c) 2016<br/>
 * Company: 深圳市擎天柱信息科技有限公司<br/>
 * @author  甘佳 jackgrays@matrix.com
 * @version v1.0 2016-03-11
 */
public interface RptAgentMoreService extends BaseService<RptAgentMore,Long>{

    /**
     *  查找已经统计了的最大统计时间
     * @return
     * @throws ServiceException
     */
    long findMaxStatedTime(Integer statType) throws ServiceException;

    /**
     *  代理商按天统计
     * @param flows
     * @param statDay
     * @throws ServiceException
     */
    void modStatAgentDay(List<RptTradeFlow> flows , Long statDay) throws ServiceException;

    /**
     *  代理商按周统计
     * @param flows
     * @param statWeek 统计日期,当期开始时刻
     * @throws ServiceException
     */
    void modStatAgent(List<RptAgentMore> flows , Long statWeek,RptStatTypeEnum typeEnum) throws ServiceException;

    /**
     *  查找介于两个时间点的记录(左闭区间)
     * @param minTime
     * @param maxTime
     * @return
     * @throws ServiceException
     */
    List<RptAgentMore> findRecodeBetweenTimes(Long minTime,Long maxTime,Integer statType) throws ServiceException;

}
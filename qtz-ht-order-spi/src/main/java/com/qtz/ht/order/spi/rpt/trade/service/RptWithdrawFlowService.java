package com.qtz.ht.order.spi.rpt.trade.service;

import java.util.List;

import com.qtz.base.exception.DaoException;
import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.BaseService;
import com.qtz.ht.order.spi.rpt.trade.vo.RptWithdrawFlow;
import com.qtz.ht.order.spi.rpt.trade.vo.RptWithdrawalsApply;

/**
 * Title:RptWithdrawFlowService<br/>
 * Description:(提现明细表SERVICE接口类)<br/>
 * Copyright: Copyright (c) 2016<br/>
 * Company: 深圳市擎天柱信息科技有限公司<br/>
 * @author  甘佳 jackgrays@matrix.com
 * @version v1.0 2016-03-22
 */
public interface RptWithdrawFlowService extends BaseService<RptWithdrawFlow,Long>{

    /**
     *  查找已经统计了的最大完成时间
     * @return
     * @throws DaoException
     */
    Long findMaxFinishTime() throws ServiceException;


    void modStatDrawList(List<RptWithdrawalsApply> draws) throws ServiceException;

    void modStatSingleDraw(RptWithdrawalsApply draw)throws ServiceException;

}
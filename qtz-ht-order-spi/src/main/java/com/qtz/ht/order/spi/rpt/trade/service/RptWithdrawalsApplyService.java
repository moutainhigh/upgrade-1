package com.qtz.ht.order.spi.rpt.trade.service;

import java.util.List;

import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.BaseService;
import com.qtz.ht.order.spi.rpt.trade.vo.RptWithdrawalsApply;

/**
 * Title:RptWithdrawalsApplyService<br/>
 * Description:(报表专用提现记录表SERVICE接口类)<br/>
 * Copyright: Copyright (c) 2016<br/>
 * Company: 深圳市擎天柱信息科技有限公司<br/>
 * @author  甘佳 jackgrays@matrix.com
 * @version v1.0 2016-03-22
 */
public interface RptWithdrawalsApplyService extends BaseService<RptWithdrawalsApply,Long>{

    /**
     *  查找指定付款时间后(不包含)，指定数量的订单
     * @param minFinishTime 最小处理时间
     * @param nums 指定数量
     * @return
     * @throws ServiceException
     */
    List<RptWithdrawalsApply> findFinishAfterTime(Long minFinishTime, int nums) throws ServiceException;

}
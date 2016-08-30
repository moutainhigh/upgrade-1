package com.qtz.ht.order.spi.rpt.trade.service;

import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.BaseService;
import com.qtz.ht.order.spi.rpt.trade.vo.RptWalletLog;

/**
 * Title:RptWalletLogService<br/>
 * Description:(报表专用钱包记录表SERVICE接口类)<br/>
 * Copyright: Copyright (c) 2016<br/>
 * Company: 深圳市擎天柱信息科技有限公司<br/>
 * @author  甘佳 jackgrays@matrix.com
 * @version v1.0 2016-03-14
 */
public interface RptWalletLogService extends BaseService<RptWalletLog,Long>{

    /**
     *  查找已退订单的退款时间
     * @param objNum 订单号
     * @return
     * @throws ServiceException
     */
    Long findRefundTime(String objNum) throws ServiceException;

}
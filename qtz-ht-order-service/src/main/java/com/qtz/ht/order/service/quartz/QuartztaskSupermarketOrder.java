package com.qtz.ht.order.service.quartz;

import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.qtz.base.exception.DaoException;
import com.qtz.commons.framework.SpringContextHelper;
import com.qtz.ht.order.service.order.dao.SupermarketOrderDao;
import com.qtz.ht.order.spi.common.HtOrderEnum.OrderStatus;
import com.qtz.ht.order.spi.common.HtOrderEnum.interventionState;

public class QuartztaskSupermarketOrder extends QuartzJobBean
{

    private static Logger log = Logger.getLogger(QuartztaskSupermarketOrder.class);

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException
    {
        SupermarketOrderDao dao = SpringContextHelper.getBean("supermarketOrderDaoImpl");
        long applyTime = DateUtils.addDays(new Date(), -3).getTime();
        try
        {
            int result = dao.physicalIntervention(interventionState.intervention.getId(), OrderStatus.refund.getId(),
                applyTime);
            log.info("客服介入理处更改数为" + result);
        }
        catch (DaoException e)
        {
            log.error(e);
        }
    }

}

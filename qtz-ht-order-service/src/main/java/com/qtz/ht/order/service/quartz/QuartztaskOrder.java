package com.qtz.ht.order.service.quartz;

import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.qtz.base.exception.DaoException;
import com.qtz.commons.framework.SpringContextHelper;
import com.qtz.ht.order.service.order.dao.OrderDao;
import com.qtz.ht.order.spi.common.HtOrderEnum.OrderStatus;
import com.qtz.ht.order.spi.common.HtOrderEnum.interventionState;

public class QuartztaskOrder extends QuartzJobBean{

	private static Logger log = Logger.getLogger(QuartztaskOrder.class);
	
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		OrderDao dao = SpringContextHelper.getBean("orderDaoImpl");
		
		long applyTime = DateUtils.addDays(new Date(), -3).getTime();
		
		long checkTime = DateUtils.addDays(new Date(), -10).getTime();
		
		try {
			int result  = dao.physicalIntervention(interventionState.intervention.getId(), OrderStatus.refund.getId(), applyTime);
			
			int resultSuccess = dao.automaticReceipt(checkTime, OrderStatus.waitTake.getId(), OrderStatus.success.getId());
			
			log.info("客服介入理处更改数为"+result);
			
			log.info("自动处理用户收货数为"+resultSuccess);
			
		} catch (DaoException e) {
			log.error(e);
		}
	}

	
	
	
}

package com.qtz.ht.session.service.ht.wallet.dao;
import com.qtz.base.dao.BizDao;
import com.qtz.base.exception.DaoException;
import com.qtz.ht.session.spi.wallet.vo.HtStaffPaymentFlow;
/**
 * <p>Title:HtStaffPaymentFlowDao</p>
 * <p>Description:商户货款流水DAO接口类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
 * @author tanglijun
 * @version v1.0 2016-04-28
 */
public interface HtStaffPaymentFlowDao extends BizDao<HtStaffPaymentFlow,Long> {
	
	public void delDataByCondition(HtStaffPaymentFlow vo)throws DaoException;
}
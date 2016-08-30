package com.qtz.ht.session.service.ht.wallet.dao;
import com.qtz.base.dao.BizDao;
import com.qtz.base.exception.DaoException;
import com.qtz.ht.session.spi.wallet.vo.HtCheckRecord;
/**
 * <p>Title:HtCheckRecordDao</p>
 * <p>Description:商户提现记录表DAO接口类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
 * @author tanglijun
 * @version v1.0 2016-04-28
 */
public interface HtCheckRecordDao extends BizDao<HtCheckRecord,Long> {
	/**
	* 【查询指定时间当天记录数】
	* @param busiId
	* 					商家信息ID
	* @param startTime
	* 					开始时间
	* @param endTime
	* 					结束时间
	* @return
	* @throws DaoException  
	*/
	int findCount(Long busiId, long startTime, long endTime)throws DaoException;
	
}
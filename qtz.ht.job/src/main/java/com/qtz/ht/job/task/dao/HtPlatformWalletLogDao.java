package com.qtz.ht.job.task.dao;
import com.qtz.base.dao.BizDao;
import com.qtz.base.exception.DaoException;
import com.qtz.ht.job.task.vo.HtPlatformWalletLog;
/**
 * 
 * 
 * <p>Title:HtPlatformWalletLogDao</p>
 * <p>Description:平台钱包流水DAO接口类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
 *  
 * ClassName: HtPlatformWalletLogDao <br/> 
 * Function: TODO (). <br/> 
 * Reason: TODO (). <br/> 
 * date: 2016年6月6日 上午9:25:54 <br/> 
 * 
 * @author yxd 
 * @version
 */
 
public interface HtPlatformWalletLogDao extends BizDao<HtPlatformWalletLog,Long> {
	
	public <T> void delDataByCondition(T vo)throws DaoException;

}
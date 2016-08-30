package com.qtz.ht.session.spi.wallet.service;
import com.qtz.base.exception.DaoException;
import com.qtz.base.service.BaseService;
import com.qtz.ht.session.spi.wallet.vo.HtPlatformWalletLog;

/**
 * <p>Title:HtPlatformWalletLogService</p>
 * <p>Description:平台钱包流水服务接口类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
 * @author tanglijun
 * @version v1.0 2016-04-28
 */
public interface HtPlatformWalletLogService extends BaseService<HtPlatformWalletLog,Long> {

	public void delDataByCondition(HtPlatformWalletLog vo)throws DaoException ;

}
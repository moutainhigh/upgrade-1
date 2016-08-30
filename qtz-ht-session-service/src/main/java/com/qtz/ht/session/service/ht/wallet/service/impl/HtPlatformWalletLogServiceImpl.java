package com.qtz.ht.session.service.ht.wallet.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qtz.base.dao.BizDao;
import com.qtz.base.exception.DaoException;
import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.impl.BaseServiceImpl;
import com.qtz.ht.session.service.ht.wallet.dao.HtPlatformWalletLogDao;
import com.qtz.ht.session.spi.wallet.service.HtPlatformWalletLogService;
import com.qtz.ht.session.spi.wallet.vo.HtPlatformWalletLog;
import com.qtz.id.spi.IdService;

/**
 * <p>
 * Title:HtPlatformWalletLogServiceImpl
 * </p>
 * <p>
 * Description:平台钱包流水服务实现类
 * </p>
 * <p>
 * Copyright: Copyright (c) 2016
 * </p>
 * <p>
 * Company: 深圳市擎天柱信息科技有限公司
 * </p>
 * @author tanglijun
 * @version v1.0 2016-04-28
 */
@Service("htPlatformWalletLogServiceImpl")
public class HtPlatformWalletLogServiceImpl extends BaseServiceImpl<HtPlatformWalletLog, Long> implements HtPlatformWalletLogService
{
    /** 注入平台钱包流水DAO接口类 */
    @Resource(name = "htPlatformWalletLogDaoImpl")
    private HtPlatformWalletLogDao dao;
	@Resource(name = "idServiceImpl")
	private IdService idService;

    /**
     * 【取得】业务DAO对象
     * @return 业务DAO对象
     */
    @Override
    protected BizDao<HtPlatformWalletLog, Long> getDao()
    {
        return dao;
    }

	@Override
	public HtPlatformWalletLog addVo(HtPlatformWalletLog vo) throws ServiceException {
		if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		return super.addVo(vo);
	}

	@Override
	public void addList(List<HtPlatformWalletLog> list) throws ServiceException {
		for (HtPlatformWalletLog vo : list) {
			if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		}
		super.addList(list);
	}

    @Override
    public void delDataByCondition(HtPlatformWalletLog vo) throws DaoException
    {
        dao.delDataByCondition(vo);
    }
}
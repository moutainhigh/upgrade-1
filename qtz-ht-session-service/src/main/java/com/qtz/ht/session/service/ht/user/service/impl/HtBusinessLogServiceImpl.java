package com.qtz.ht.session.service.ht.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qtz.base.dao.BizDao;
import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.impl.BaseServiceImpl;
import com.qtz.ht.session.service.ht.user.dao.HtBusinessLogDao;
import com.qtz.ht.session.spi.user.service.HtBusinessLogService;
import com.qtz.ht.session.spi.user.vo.HtBusinessLog;
import com.qtz.id.spi.IdService;

/**
 * <p>
 * Title:HtBusinessLogServiceImpl
 * </p>
 * <p>
 * Description:商户信息日志表服务实现类
 * </p>
 * <p>
 * Copyright: Copyright (c) 2016
 * </p>
 * <p>
 * Company: 深圳市擎天柱信息科技有限公司
 * </p>
 * @author tanglijun
 * @version v1.0 2016-04-11
 */
@Service("htBusinessLogServiceImpl")
public class HtBusinessLogServiceImpl extends BaseServiceImpl<HtBusinessLog, Long> implements HtBusinessLogService
{
    /** 注入商户信息日志表DAO接口类 */
    @Resource(name = "htBusinessLogDaoImpl")
    private HtBusinessLogDao dao;
	@Resource(name = "idServiceImpl")
	private IdService idService;

    /**
     * 【取得】业务DAO对象
     * @return 业务DAO对象
     */
    @Override
    protected BizDao<HtBusinessLog, Long> getDao()
    {
        return dao;
    }

	@Override
	public HtBusinessLog addVo(HtBusinessLog vo) throws ServiceException {
			if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		return super.addVo(vo);
	}

	@Override
	public void addList(List<HtBusinessLog> list) throws ServiceException {
		for (HtBusinessLog vo : list) {
				if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		}
		super.addList(list);
	}
}
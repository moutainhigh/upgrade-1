package com.qtz.ht.session.service.ht.wallet.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qtz.base.dao.BizDao;
import com.qtz.base.exception.DaoException;
import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.impl.BaseServiceImpl;
import com.qtz.ht.session.service.ht.wallet.dao.HtStaffPaymentFlowDao;
import com.qtz.ht.session.spi.wallet.service.HtStaffPaymentFlowService;
import com.qtz.ht.session.spi.wallet.vo.HtStaffPaymentFlow;
import com.qtz.id.spi.IdService;

/**
 * <p>
 * Title:HtStaffPaymentFlowServiceImpl
 * </p>
 * <p>
 * Description:商户货款流水服务实现类
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
@Service("htStaffPaymentFlowServiceImpl")
public class HtStaffPaymentFlowServiceImpl extends BaseServiceImpl<HtStaffPaymentFlow, Long>
    implements HtStaffPaymentFlowService
{
    /** 注入商户货款流水DAO接口类 */
    @Resource(name = "htStaffPaymentFlowDaoImpl")
    private HtStaffPaymentFlowDao dao;
	@Resource(name = "idServiceImpl")
	private IdService idService;

    /**
     * 【取得】业务DAO对象
     * @return 业务DAO对象
     */
    @Override
    protected BizDao<HtStaffPaymentFlow, Long> getDao()
    {
        return dao;
    }

	@Override
	public HtStaffPaymentFlow addVo(HtStaffPaymentFlow vo) throws ServiceException {
		if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		return super.addVo(vo);
	}

	@Override
	public void addList(List<HtStaffPaymentFlow> list) throws ServiceException {
		for (HtStaffPaymentFlow vo : list) {
			if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		}
		super.addList(list);
	}

    /// service 层删除条件记录
    @Override
    public void delDataByCondition(HtStaffPaymentFlow t) throws ServiceException
    {
        try
        {
            dao.delDataByCondition(t);
        }
        catch (DaoException e)
        {
            throw new ServiceException(e);
        }
    }

    @Override
    public HtStaffPaymentFlow getEntityByOrderId(Long orderId, Long staffCode) throws ServiceException
    {

        HtStaffPaymentFlow vo = new HtStaffPaymentFlow();
        vo.setOrderId(orderId);
        vo.setBusiId(staffCode);
        List<HtStaffPaymentFlow> list = super.findList(vo);
        if (null != list && list.size() > 0)
        {
            return list.get(0);
        }
        return null;
    }
}
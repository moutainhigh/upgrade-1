package com.qtz.ht.session.service.ht.wallet.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qtz.base.dao.BizDao;
import com.qtz.base.dto.user.UserType;
import com.qtz.base.exception.DaoException;
import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.impl.BaseServiceImpl;
import com.qtz.ht.session.service.ht.wallet.dao.HtWalletDao;
import com.qtz.ht.session.spi.user.vo.HtStaff;
import com.qtz.ht.session.spi.wallet.service.HtWalletService;
import com.qtz.ht.session.spi.wallet.vo.HtWallet;
import com.qtz.id.spi.IdService;

/**
 * <p>
 * Title:HtWalletServiceImpl
 * </p>
 * <p>
 * Description:钱包服务实现类
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
@Service("htWalletServiceImpl")
public class HtWalletServiceImpl extends BaseServiceImpl<HtWallet, Long> implements HtWalletService
{
    /** 注入钱包DAO接口类 */
    @Resource(name = "htWalletDaoImpl")
    private HtWalletDao dao;
	@Resource(name = "idServiceImpl")
	private IdService idService;

    /**
     * 【取得】业务DAO对象
     * @return 业务DAO对象
     */
    @Override
    protected BizDao<HtWallet, Long> getDao()
    {
        return dao;
    }

	@Override
	public HtWallet addVo(HtWallet vo) throws ServiceException {
		if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		return super.addVo(vo);
	}

	@Override
	public void addList(List<HtWallet> list) throws ServiceException {
		for (HtWallet vo : list) {
			if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		}
		super.addList(list);
	}

    @Override
    public HtWallet findPlatformWallet() throws ServiceException
    {
        HtWallet wallet = this.getWalletByUser(HtStaff.ADMIN_WALLET_ID, UserType.PPUSER.value());
        if (wallet != null)
        {
            // 未付供应商货款
            wallet.setUnpaidPayment(dao.getUnpaidPayment(UserType.BUSINESS.value()));
            // 已付供应商货款
            wallet.setPaidPayment(dao.getPaidPayment(UserType.BUSINESS.value()));
        }
        return wallet;
    }

    @Override
    public HtWallet getWalletByUser(Long busiId, int userType) throws ServiceException
    {
        try
        {
            return dao.getWalletByUser(busiId, userType);
        }
        catch (DaoException e)
        {
            throw new ServiceException(e);
        }
    }

    @Override
    public void modSuppReconciliation(Long busiId, Double staffRevenue) throws ServiceException
    {
        try
        {
            dao.modWallet(busiId, staffRevenue);
        }
        catch (DaoException e)
        {
            throw new ServiceException(e);
        }
    }

    @Override
    public void modPlatformReconciliation(double platformRevenue) throws ServiceException
    {
        try
        {
            dao.modWallet(HtStaff.ADMIN_WALLET_ID, platformRevenue);
        }
        catch (DaoException e)
        {
            throw new ServiceException(e);
        }
    }

    @Override
    public void countWalletTotalRefund(Long buessId, double amount) throws ServiceException
    {
        try
        {
            dao.countWalletTotalRefund(buessId, amount);
        }
        catch (DaoException e)
        {
            throw new ServiceException(e);
        }
    }

    @Override
    public void modWalletTotalPaymentGoods(Long buessId, double amount) throws ServiceException
    {
        try
        {
            dao.modWalletTotalPaymentGoods(buessId, amount);
        }
        catch (DaoException e)
        {
            throw new ServiceException(e);
        }
    }
}
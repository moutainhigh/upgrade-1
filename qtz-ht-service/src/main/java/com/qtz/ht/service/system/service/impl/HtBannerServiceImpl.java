package com.qtz.ht.service.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qtz.base.dao.BizDao;
import com.qtz.base.exception.DaoException;
import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.impl.BaseServiceImpl;
import com.qtz.ht.service.system.dao.HtBannerDao;
import com.qtz.ht.spi.system.service.HtBannerService;
import com.qtz.ht.spi.system.vo.HtBanner;
import com.qtz.id.spi.IdService;

/**
 * <p>
 * Title:HtBannerServiceImpl
 * </p>
 * <p>
 * Description:横幅管理表服务实现类
 * </p>
 * <p>
 * Copyright: Copyright (c) 2016
 * </p>
 * <p>
 * Company: 深圳市擎天柱信息科技有限公司
 * </p>
 * @author tanglijun
 * @version v1.0 2016-04-15
 */
@Service("htBannerServiceImpl")
public class HtBannerServiceImpl extends BaseServiceImpl<HtBanner, Long> implements HtBannerService
{
    /** 注入横幅管理表DAO接口类 */
    @Resource(name = "htBannerDaoImpl")
    private HtBannerDao dao;
	@Resource(name = "idServiceImpl")
	private IdService idService;

    /**
     * 【取得】业务DAO对象
     * @return 业务DAO对象
     */
    @Override
    protected BizDao<HtBanner, Long> getDao()
    {
        return dao;
    }

	@Override
	public HtBanner addVo(HtBanner vo) throws ServiceException {
			if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		return super.addVo(vo);
	}

	@Override
	public void addList(List<HtBanner> list) throws ServiceException {
		for (HtBanner vo : list) {
				if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		}
		super.addList(list);
	}
	
    @Override
    public List<HtBanner> findSpecifyFieldList(Integer versionType, Integer clientType, int status)
        throws ServiceException
    {
        try
        {
            HtBanner obj = new HtBanner();
            obj.setClientType(clientType);
            obj.setVersionType(versionType);
            obj.setStatus(status);
            return dao.findSpecifyFieldList(obj);
        }
        catch (DaoException e)
        {
            throw new ServiceException(e);
        }
    }
}
package com.qtz.ht.service.good.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qtz.base.dao.BizDao;
import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.impl.BaseServiceImpl;
import com.qtz.ht.service.good.dao.HtGoodDescDao;
import com.qtz.ht.spi.good.service.HtGoodDescService;
import com.qtz.ht.spi.good.vo.HtGoodDesc;
import com.qtz.id.spi.IdService;

/**
 * <p>
 * Title:HtGoodDescServiceImpl
 * </p>
 * <p>
 * Description:商户商品祥情服务实现类
 * </p>
 * <p>
 * Copyright: Copyright (c) 2016
 * </p>
 * <p>
 * Company: 深圳市好实再商贸有限公司
 * </p>
 * @author tanglijun
 * @version v1.0 2016-02-15
 */
@Service("htGoodDescServiceImpl")
public class HtGoodDescServiceImpl extends BaseServiceImpl<HtGoodDesc, Long> implements HtGoodDescService
{
    /** 注入商户商品祥情DAO接口类 */
    @Resource(name = "htGoodDescDaoImpl")
    private HtGoodDescDao dao;
	@Resource(name = "idServiceImpl")
	private IdService idService;

    /**
     * 【取得】业务DAO对象
     * @return 业务DAO对象
     */
    @Override
    protected BizDao<HtGoodDesc, Long> getDao()
    {
        return dao;
    }

	@Override
	public HtGoodDesc addVo(HtGoodDesc vo) throws ServiceException {
			if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		return super.addVo(vo);
	}

	@Override
	public void addList(List<HtGoodDesc> list) throws ServiceException {
		for (HtGoodDesc vo : list) {
				if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		}
		super.addList(list);
	}
}
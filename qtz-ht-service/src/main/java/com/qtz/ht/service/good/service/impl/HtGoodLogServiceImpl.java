package com.qtz.ht.service.good.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qtz.base.dao.BizDao;
import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.impl.BaseServiceImpl;
import com.qtz.ht.service.good.dao.HtGoodLogDao;
import com.qtz.ht.spi.good.service.HtGoodLogService;
import com.qtz.ht.spi.good.vo.HtGoodLog;
import com.qtz.id.spi.IdService;

/**
 * <p>Title:HtGoodLogServiceImpl</p>
 * <p>Description:商户商品操作记录服务实现类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: 深圳市好实再商贸有限公司</p>
 * @author tanglijun
 * @version v1.0 2016-04-07
 */
@Service("htGoodLogServiceImpl")
public class HtGoodLogServiceImpl extends BaseServiceImpl<HtGoodLog,Long> implements HtGoodLogService  {
	
	/**注入商户商品操作记录DAO接口类*/
	@Resource(name="htGoodLogDaoImpl")
    private HtGoodLogDao dao;
	@Resource(name = "idServiceImpl")
	private IdService idService;
    
	/** 
	* 【取得】业务DAO对象
	* @return 	业务DAO对象  
	*/
	@Override
	protected BizDao<HtGoodLog,Long> getDao() {
		return dao;
	}
	
	@Override
	public HtGoodLog addVo(HtGoodLog vo) throws ServiceException {
			if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		return super.addVo(vo);
	}

	@Override
	public void addList(List<HtGoodLog> list) throws ServiceException {
		for (HtGoodLog vo : list) {
				if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		}
		super.addList(list);
	}
}
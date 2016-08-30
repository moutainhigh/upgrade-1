package com.qtz.ht.service.system.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qtz.base.dao.BizDao;
import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.impl.BaseServiceImpl;
import com.qtz.ht.service.system.dao.HtActivityDao;
import com.qtz.ht.spi.system.service.HtActivityService;
import com.qtz.ht.spi.system.vo.HtActivity;
import com.qtz.id.spi.IdService;

/**
 * <p>Title:HtActivityServiceImpl</p>
 * <p>Description:活动管理表服务实现类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
 * @author tanglijun
 * @version v1.0 2016-08-08
 */
@Service("htActivityServiceImpl")
public class HtActivityServiceImpl extends BaseServiceImpl<HtActivity,Long> implements HtActivityService  {
	
	/**注入活动管理表DAO接口类*/
	@Resource(name="htActivityDaoImpl")
    private HtActivityDao dao;
	@Resource(name = "idServiceImpl")
	private IdService idService;
    
	/** 
	* 【取得】业务DAO对象
	* @return 	业务DAO对象  
	*/
	@Override
	protected BizDao<HtActivity,Long> getDao() {
		return dao;
	}

	@Override
	public HtActivity addVo(HtActivity vo) throws ServiceException {
			if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		return super.addVo(vo);
	}

	@Override
	public void addList(List<HtActivity> list) throws ServiceException {
		for (HtActivity vo : list) {
				if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		}
		super.addList(list);
	}
}
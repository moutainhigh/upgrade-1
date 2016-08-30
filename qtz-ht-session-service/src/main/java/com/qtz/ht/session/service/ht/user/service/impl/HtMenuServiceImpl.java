package com.qtz.ht.session.service.ht.user.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qtz.base.dao.BizDao;
import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.impl.BaseServiceImpl;
import com.qtz.ht.session.service.ht.user.dao.HtMenuDao;
import com.qtz.ht.session.spi.user.service.HtMenuService;
import com.qtz.ht.session.spi.user.vo.HtMenu;
import com.qtz.id.spi.IdService;

/**
 * <p>Title:HtMenuServiceImpl</p>
 * <p>Description:商户员工菜单服务实现类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: 深圳市好实再商贸有限公司</p>
 * @author tanglijun
 * @version v1.0 2016-01-25
 */
@Service("htMenuServiceImpl")
public class HtMenuServiceImpl extends BaseServiceImpl<HtMenu,Long> implements HtMenuService  {
	/**注入商户员工菜单DAO接口类*/
	@Resource(name="htMenuDaoImpl")
    private HtMenuDao dao;
	@Resource(name = "idServiceImpl")
	private IdService idService;
    
	/** 
	* 【取得】业务DAO对象
	* @return 	业务DAO对象  
	*/
	@Override
	protected BizDao<HtMenu,Long> getDao() {
		return dao;
	}

	@Override
	public HtMenu addVo(HtMenu vo) throws ServiceException {
			if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		return super.addVo(vo);
	}

	@Override
	public void addList(List<HtMenu> list) throws ServiceException {
		for (HtMenu vo : list) {
				if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		}
		super.addList(list);
	}
}
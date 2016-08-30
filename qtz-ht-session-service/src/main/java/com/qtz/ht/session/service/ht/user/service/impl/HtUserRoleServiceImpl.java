package com.qtz.ht.session.service.ht.user.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qtz.base.dao.BizDao;
import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.impl.BaseServiceImpl;
import com.qtz.ht.session.service.ht.user.dao.HtUserRoleDao;
import com.qtz.ht.session.spi.user.service.HtUserRoleService;
import com.qtz.ht.session.spi.user.vo.HtUserRole;
import com.qtz.id.spi.IdService;

/**
 * <p>Title:HtUserRoleServiceImpl</p>
 * <p>Description:商户用户与角色关联服务实现类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: 深圳市好实再商贸有限公司</p>
 * @author tanglijun
 * @version v1.0 2016-01-25
 */
@Service("htUserRoleServiceImpl")
public class HtUserRoleServiceImpl extends BaseServiceImpl<HtUserRole,Long> implements HtUserRoleService  {
	/**注入商户用户与角色关联DAO接口类*/
	@Resource(name="htUserRoleDaoImpl")
    private HtUserRoleDao dao;
	@Resource(name = "idServiceImpl")
	private IdService idService;
    
	/** 
	* 【取得】业务DAO对象
	* @return 	业务DAO对象  
	*/
	@Override
	protected BizDao<HtUserRole,Long> getDao() {
		return dao;
	}

	@Override
	public HtUserRole addVo(HtUserRole vo) throws ServiceException {
			if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		return super.addVo(vo);
	}

	@Override
	public void addList(List<HtUserRole> list) throws ServiceException {
		for (HtUserRole vo : list) {
				if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		}
		super.addList(list);
	}
}
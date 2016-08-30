package com.qtz.ht.session.service.ht.user.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qtz.base.dao.BizDao;
import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.impl.BaseServiceImpl;
import com.qtz.ht.session.service.ht.user.dao.HtRoleDao;
import com.qtz.ht.session.spi.user.service.HtRoleService;
import com.qtz.ht.session.spi.user.vo.HtRole;
import com.qtz.id.spi.IdService;

/**
 * <p>Title:HtRoleServiceImpl</p>
 * <p>Description:商户角色服务实现类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: 深圳市好实再商贸有限公司</p>
 * @author tanglijun
 * @version v1.0 2016-01-25
 */
@Service("htRoleServiceImpl")
public class HtRoleServiceImpl extends BaseServiceImpl<HtRole,Long> implements HtRoleService  {
	/**注入商户角色DAO接口类*/
	@Resource(name="htRoleDaoImpl")
    private HtRoleDao dao;
	@Resource(name = "idServiceImpl")
	private IdService idService;
    
	/** 
	* 【取得】业务DAO对象
	* @return 	业务DAO对象  
	*/
	@Override
	protected BizDao<HtRole,Long> getDao() {
		return dao;
	}

	@Override
	public HtRole addVo(HtRole vo) throws ServiceException {
			if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		return super.addVo(vo);
	}

	@Override
	public void addList(List<HtRole> list) throws ServiceException {
		for (HtRole vo : list) {
				if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		}
		super.addList(list);
	}
}
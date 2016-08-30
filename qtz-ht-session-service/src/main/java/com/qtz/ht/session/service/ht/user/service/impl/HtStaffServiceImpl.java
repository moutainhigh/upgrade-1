package com.qtz.ht.session.service.ht.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.qtz.base.common.ExceptionConstants;
import com.qtz.base.dao.BizDao;
import com.qtz.base.dto.DdmSession;
import com.qtz.base.exception.DaoException;
import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.impl.BaseServiceImpl;
import com.qtz.base.util.Constants;
import com.qtz.commons.time.DateUtil;
import com.qtz.ht.session.service.ht.user.dao.HtStaffDao;
import com.qtz.ht.session.spi.session.service.SessionService;
import com.qtz.ht.session.spi.user.service.HtStaffService;
import com.qtz.ht.session.spi.user.vo.HtStaff;
import com.qtz.id.spi.IdService;

/**
 * <p>
 * Title:HtStaffServiceImpl
 * </p>
 * <p>
 * Description:海淘员工表服务实现类
 * </p>
 * <p>
 * Copyright: Copyright (c) 2016
 * </p>
 * <p>
 * Company: 深圳市好实再商贸有限公司
 * </p>
 * @author tanglijun
 * @version v1.0 2016-04-06
 */
@Service("htStaffServiceImpl")
public class HtStaffServiceImpl extends BaseServiceImpl<HtStaff, Long> implements HtStaffService
{
    /** 初始化日志对象 */
    private static Logger log = Logger.getLogger(HtStaffServiceImpl.class);
    /** 注入海淘员工表DAO接口类 */
    @Resource(name = "htStaffDaoImpl")
    private HtStaffDao dao;
    @Resource(name = "sessionServiceImpl")
    private SessionService sessionService;
	@Resource(name = "idServiceImpl")
	private IdService idService;

    /**
     * 【取得】业务DAO对象
     * @return 业务DAO对象
     */
    @Override
    protected BizDao<HtStaff, Long> getDao()
    {
        return dao;
    }

	@Override
	public HtStaff addVo(HtStaff vo) throws ServiceException {
			if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		return super.addVo(vo);
	}

	@Override
	public void addList(List<HtStaff> list) throws ServiceException {
		for (HtStaff vo : list) {
				if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		}
		super.addList(list);
	}

    public DdmSession login(String account, String password, DdmSession s) throws ServiceException
    {
        log.debug(account + " 登录了 密码 = password；" + password);
        if (null == account || null == password)
        {
            throw new ServiceException(ExceptionConstants.ERRORCODE_7, "入参错误");
        }
        if (null != s.getSessionObject(Constants.SESSION_USER))
        {
            throw new ServiceException(ExceptionConstants.ERRORCODE_6, "当前session已经绑定登录用户");
        }
        DdmSession ns = s;
        HtStaff user = null;
        user = this.getLoginVo(account, password);
        if (null == user)
        {
            throw new ServiceException(ExceptionConstants.ERRORCODE_NEGATIVE1, "用户名或密码错误");
        }
        log.info("用户：【" + account + "】登陆系统成功!");
        user.setPwd(null);
        ns.save(Constants.SESSION_USER, user);
        ns.setLastOperaTime(System.currentTimeMillis());
        sessionService.saveSession(ns); // 保存session
        // 更新用户最后登录时间
        HtStaff update = new HtStaff();
        update.setDmId(user.getDmId());
        update.setLastLogin(DateUtil.getTimeInSeconds());
        super.modVoNotNull(update);
        return ns;
    }

    private HtStaff getLoginVo(String account, String password) throws ServiceException
    {
        try
        {
            return dao.getLoginVo(account, password, Constants.ZERO, Constants.ZERO);
        }
        catch (DaoException e)
        {
            throw new ServiceException(ExceptionConstants.ERRORCODE_NEGATIVE1, "登录查询用户失败");
        }
    }

    public boolean logout(Long userId, String sid) throws ServiceException
    {
        if (null == sid)
        {
            throw new ServiceException(ExceptionConstants.ERRORCODE_7, "入参错误", "入参错误，sessionKey=" + sid);
        }
        DdmSession s = sessionService.getSession(sid);
        if (null == s)
        {
            throw new ServiceException(ExceptionConstants.ERRORCODE_NEGATIVE1, "session无效",
                "session无效，sessionKey=" + sid);
        }
        sessionService.removeSession(sid);// 删除session
        return true;
    }
}
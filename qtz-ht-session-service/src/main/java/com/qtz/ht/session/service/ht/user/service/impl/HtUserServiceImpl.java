package com.qtz.ht.session.service.ht.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.qtz.base.common.ExceptionConstants;
import com.qtz.base.dao.BizDao;
import com.qtz.base.dto.DdmSession;
import com.qtz.base.dto.user.UserType;
import com.qtz.base.exception.DaoException;
import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.impl.BaseServiceImpl;
import com.qtz.base.util.Constants;
import com.qtz.commons.time.DateUtil;
import com.qtz.ht.session.service.ht.user.dao.HtBusinessDao;
import com.qtz.ht.session.service.ht.user.dao.HtUserDao;
import com.qtz.ht.session.spi.session.service.SessionService;
import com.qtz.ht.session.spi.user.service.HtUserService;
import com.qtz.ht.session.spi.user.vo.HtUser;
import com.qtz.id.spi.IdService;

/**
 * <p>
 * Title:HtUserServiceImpl
 * </p>
 * <p>
 * Description:商户用户服务实现类
 * </p>
 * <p>
 * Copyright: Copyright (c) 2016
 * </p>
 * <p>
 * Company: 深圳市好实再商贸有限公司
 * </p>
 * @author tanglijun
 * @version v1.0 2016-01-25
 */
@Service("htUserServiceImpl")
public class HtUserServiceImpl extends BaseServiceImpl<HtUser, Long> implements HtUserService
{
    /** 初始化日志对象 */
    private static Logger log = Logger.getLogger(HtUserServiceImpl.class);
    /** 注入商户用户DAO接口类 */
    @Resource(name = "htUserDaoImpl")
    private HtUserDao dao;
    @Resource(name = "htBusinessDaoImpl")
    private HtBusinessDao htBusinessDao;
    @Resource(name = "sessionServiceImpl")
    private SessionService sessionService;
	@Resource(name = "idServiceImpl")
	private IdService idService;

    /**
     * 【取得】业务DAO对象
     * @return 业务DAO对象
     */
    @Override
    protected BizDao<HtUser, Long> getDao()
    {
        return dao;
    }

	@Override
	public HtUser addVo(HtUser vo) throws ServiceException {
		if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		return super.addVo(vo);
	}

	@Override
	public void addList(List<HtUser> list) throws ServiceException {
		for (HtUser vo : list) {
			if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		}
		super.addList(list);
	}

    @Override
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
        HtUser user = null;
        user = this.getLoginVo(account, password, UserType.BUSINESS.value());
        if (null == user)
        {
            throw new ServiceException(ExceptionConstants.ERRORCODE_NEGATIVE1, "用户名或密码错误");
        }
        /*
         * Long busiId=user.getBusiId(); if(busiId!=null){ try { HtBusiness htBusiness =htBusinessDao.findVo(busiId,
         * null); if(htBusiness!=null){ if(htBusiness.getIsFrozen() == 1){//冻结 提示： throw new
         * ServiceException(ExceptionConstants.ERRORCODE_NEGATIVE1, user.getRealName()+"由于违反协议，被冻结无法使用"); } } } catch
         * (DaoException e) { e.printStackTrace(); } }
         */
        log.info("用户：【" + account + "】登陆系统成功!");
        user.setPassword(null);
        ns.save(Constants.SESSION_USER, user);
        ns.setLastOperaTime(System.currentTimeMillis());
        sessionService.saveSession(ns); // 保存session
        // 更新用户最后登录时间
        HtUser update = new HtUser();
        update.setDmId(user.getDmId());
        update.setLastLogin(DateUtil.getTimeInSeconds());
        super.modVoNotNull(update);
        return ns;
    }

    @Override
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

    @Override
    public HtUser getLoginVo(String account, String password, int userType) throws ServiceException
    {
        try
        {
            return dao.getLoginVo(account, password, userType);
        }
        catch (DaoException e)
        {
            throw new ServiceException(e);
        }
    }

    @Override
    public HtUser findVo(Long userId) throws ServiceException
    {
        try
        {
            return dao.findVo(userId, new HtUser());
        }
        catch (DaoException e)
        {
            throw new ServiceException(e);
        }
    }
}
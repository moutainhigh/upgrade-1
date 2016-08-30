package com.qtz.ht.session.service.impl;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.qtz.base.dto.DdmSession;
import com.qtz.base.util.Constants;
import com.qtz.ht.session.spi.session.service.SessionService;

/**
 * session 管理器
 * <p>
 * Title:SessionManager
 * </p>
 * <p>
 * Description:(用一句话描述该文件做什么)
 * </p>
 * <p>
 * Copyright: Copyright (c) 2014
 * </p>
 * <p>
 * Company: 深圳市好实再商贸有限公司
 * </p>
 * @author 赵汉江 - zhaohanjiang
 * @version v1.0 2014-12-6
 */
@Service("sessionServiceImpl")
public class SessionServiceImpl implements SessionService
{

    private static Logger log = Logger.getLogger(SessionServiceImpl.class);
    /** redis中的session分组 */
    public static final String SESSION = "ht_session";

    /** (普通时间 SESSION 过期时间 5分钟) */
    public static final long NOMAL_SESSION_TIMEOUT = 5 * 60 * 1000;
    /**
     * 用户 SESSION 过期时间 24小时
     */
    public static final long USER_SESSION_TIMEOUT = 24 * 60 * 60 * 1000;

    @Autowired
    private RedisTemplate<Serializable, Serializable> redisTemplate;

    /**
     * 【获取session,如果不存在则创建一个新session】(这里用一句话描述这个方法的作用)
     * @param sid
     * @return
     * @throws Exception
     */
    public DdmSession getSession(String sid)
    {
        DdmSession s = null;
        if (null == sid || sid.length() == 0)
        {
            s = new DdmSession();
        }
        else
        {
            try
            {
                Serializable obj = redisTemplate.opsForValue().get(SESSION + sid);
                if (obj instanceof DdmSession)
                {
                    s = (DdmSession) obj;
                }
            }
            catch (Exception e)
            {
                log.error("redisTemplate get Exception,key=" + (SESSION + sid), e);
            }
        }
        return s;
    }

    /**
     * 【新建一个session】(这里用一句话描述这个方法的作用)
     * @return
     * @throws Exception
     */
    public DdmSession newSession()
    {
        DdmSession s = new DdmSession();
        try
        {
            redisTemplate.opsForValue().set(SESSION + s.getId(), s, NOMAL_SESSION_TIMEOUT, TimeUnit.MINUTES);
        }
        catch (Exception e)
        {
            log.error("redisTemplate set Exception,key=" + SESSION + s.getId(), e);
        }
        return s;
    }

    /**
     * 【删除一个session】(这里用一句话描述这个方法的作用)
     * @param sid
     * @return
     * @throws Exception
     */
    public boolean removeSession(String sid)
    {
        try
        {
            redisTemplate.delete(SESSION + sid);
            return true;
        }
        catch (Exception e)
        {
            log.error("redisTemplate delete Exception,key=" + SESSION + sid, e);
        }
        return false;
    }

    public void saveSession(DdmSession s)
    {
        try
        {
            if (null != s && null != s.getId())
            {
                long timeout = USER_SESSION_TIMEOUT;//
                if (null == s || null == s.getSessionObject(Constants.SESSION_USER))
                {
                    timeout = NOMAL_SESSION_TIMEOUT;// 未登录,5分钟session
                }
                redisTemplate.opsForValue().set(SESSION + s.getId(), s, timeout, TimeUnit.MINUTES);
            }
        }
        catch (Exception e)
        {
            log.error("redisTemplate set Exception,key=" + SESSION + s.getId(), e);
        }
    }
}
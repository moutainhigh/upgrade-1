package com.qtz.ht.session.spi.session.service;

import com.qtz.base.dto.DdmSession;
import com.qtz.base.exception.ServiceException;

/**
 * session 管理器
 * <p>
 * 更改session后必须调用saveSession方法
 * </p>
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
public interface SessionService
{

    /**
     * 【获取session,如果不存在则创建一个新session】(这里用一句话描述这个方法的作用)
     * <p>
     * 更改session后必须调用saveSession方法
     * </p>
     * @param sid
     * @return
     * @throws RpcException
     */
    public DdmSession getSession(String sid) throws ServiceException;

    /**
     * 【保存session】(这里用一句话描述这个方法的作用)
     * @param sid
     * @return
     * @throws RpcException
     */
    public void saveSession(DdmSession s) throws ServiceException;

    /**
     * 【新建一个session】(这里用一句话描述这个方法的作用)
     * @return
     * @throws RpcException
     */
    public DdmSession newSession() throws ServiceException;

    /**
     * 【删除一个session】(这里用一句话描述这个方法的作用)
     * @param sid
     * @throws RpcException
     */
    public boolean removeSession(String sid) throws ServiceException;
}
package com.qtz.ht.session.service.ht.user.dao;
import com.qtz.base.dao.BizDao;
import com.qtz.base.exception.DaoException;
import com.qtz.ht.session.spi.user.vo.HtUser;
/**
 * <p>Title:HtUserDao</p>
 * <p>Description:商户用户DAO接口类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: 深圳市好实再商贸有限公司</p>
 * @author tanglijun
 * @version v1.0 2016-01-25
 */
public interface HtUserDao extends BizDao<HtUser,Long> {

	/**
	* 【登录方法】
	* @param account
	* 				用户账号
	* @param password
	* 				密码
	* @param userType
	* 				用户类型
	* @return
	* @throws DaoException  
	*/
	HtUser getLoginVo(String account, String password, int userType) throws DaoException;
	
}
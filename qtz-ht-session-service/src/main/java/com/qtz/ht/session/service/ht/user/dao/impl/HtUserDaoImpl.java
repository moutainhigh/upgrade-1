package com.qtz.ht.session.service.ht.user.dao.impl;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qtz.base.dao.impl.MyBaitsDaoImpl;
import com.qtz.base.exception.DaoException;
import com.qtz.ht.session.service.ht.user.dao.HtUserDao;
import com.qtz.ht.session.spi.user.vo.HtUser;
/**
 * <p>Title:HtUserDaoImpl</p>
 * <p>Description:商户用户DAO实现类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: 深圳市好实再商贸有限公司</p>
 * @author tanglijun
 * @version v1.0 2016-01-25
 */
@Repository("htUserDaoImpl")
public class HtUserDaoImpl extends MyBaitsDaoImpl<HtUser,Long> implements HtUserDao {
	/**MYBatis命名空间名*/
	private static String preName = HtUserDao.class.getName();
	/** 
	* 【取得】MYBatis命名空间名
	* @return  	MYBatis命名空间名
	*/
	@Override
	protected String getPreName() {
		return preName;
	}
	public HtUser getLoginVo(String account, String password, int userType) throws DaoException{
		HtUser result = null;
		if(null == account || null == password || userType < 0) throw new DaoException(this.getClass().getName() + ".getLoginVo(" + account + password + userType + ")传入的参数不能为空！");
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("userType", userType);
			params.put("account", account);
			params.put("password", password);
			result = getMyBaitsTemplate().getSqlSession().selectOne(getPreName() + ".getLoginVo" , params);
		} catch (Exception e) {
			throw new DaoException(e);
		}
		return result;
	}
}
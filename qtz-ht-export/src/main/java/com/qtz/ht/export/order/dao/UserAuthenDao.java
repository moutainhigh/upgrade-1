package com.qtz.ht.export.order.dao;
import com.qtz.base.dao.BizDao;
import com.qtz.base.exception.DaoException;
import com.qtz.ht.export.order.entity.UserAuthen;
/**
 * <p>Title:UserPersonDao</p>
 * <p>Description:个人认证DAO接口类</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
 * @author lzg - charli
 * @version v1.0 2015-03-14
 */
public interface UserAuthenDao extends BizDao<UserAuthen,Long> {
		
	public Long findCountByStatus(UserAuthen vo) throws DaoException ;
	
	UserAuthen findCountByUserId(Long userId, UserAuthen clazz) throws DaoException ;
}	
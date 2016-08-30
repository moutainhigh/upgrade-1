package com.qtz.ht.export.order.dao.Impl;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.qtz.base.dao.impl.MongDmDaoImpl;
import com.qtz.base.exception.DaoException;
import com.qtz.ht.export.order.dao.UserAuthenDao;
import com.qtz.ht.export.order.entity.UserAuthen;
/**
 * <p>Title:UserJobDaoImpl</p>
 * <p>Description:职业认证DAO实现类</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
 * @author lzg - charli
 * @version v1.0 2015-03-14
 * BizDaoImpl
 */
@Repository
public class UserAuthenDaoImpl extends MongDmDaoImpl<UserAuthen,Long> implements UserAuthenDao {
	
	@Override
	protected String getPreName() {
		return "user_authen";
	}

	public Long findCountByStatus(UserAuthen vo) throws DaoException {
		Query query = new Query();
		if (StringUtils.isNotEmpty(vo.getPno())) {
			query.addCriteria(Criteria.where("pno").is(vo.getPno()));
		}
		if (null != vo.getApplyStatus()) {
		}
		if (null != vo.getStatus() ) {
			query.addCriteria(Criteria.where("status").ne(vo.getStatus()));
		}
		return getMongoTemplate().count(query, getPreName());
	}

	@Override
	public UserAuthen findCountByUserId(Long userId,UserAuthen clazz) throws DaoException {
		Query query =new Query();
		try {
			query.addCriteria(Criteria.where("userId").is(userId));
		} catch (IllegalArgumentException e) {
			throw new DaoException(e);
		} 
		UserAuthen findOne =  getMongoTemplate().findOne(query,clazz.getClass(),getPreName());
		return findOne==null?null:findOne;
	}

}
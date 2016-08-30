package com.qtz.ht.order.service.message.dao.impl;

import org.springframework.stereotype.Repository;

import com.qtz.base.dao.impl.MyBaitsDaoImpl;
import com.qtz.ht.order.service.message.dao.MessageDao;
import com.qtz.ht.order.spi.message.vo.Message;

@Repository
public class MessageDaoImpl extends MyBaitsDaoImpl<Message, Long> implements MessageDao {

	/**MYBatis命名空间名*/
	private static String preName = MessageDao.class.getName();
	
	@Override
	protected String getPreName() {
		// TODO Auto-generated method stub
		return preName;
	}

	

}

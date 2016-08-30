package com.qtz.ht.order.spi.message.service;

import com.qtz.base.service.BaseService;
import com.qtz.ht.order.spi.common.Result;
import com.qtz.ht.order.spi.message.vo.Message;

public interface MessageService extends BaseService<Message, Long>{
	 
	public Result<Message> saveMessage(Message message);
	
	public Result<Message> getMessageListByUserId(Long userId,int pageOffset);
}

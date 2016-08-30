package com.qtz.ht.order.service.message.service.impl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qtz.base.common.Pager;
import com.qtz.base.dao.BizDao;
import com.qtz.base.exception.ExceptionCode;
import com.qtz.base.service.impl.BaseServiceImpl;
import com.qtz.ht.order.service.message.dao.MessageDao;
import com.qtz.ht.order.spi.common.Result;
import com.qtz.ht.order.spi.message.page.MessagePage;
import com.qtz.ht.order.spi.message.service.MessageService;
import com.qtz.ht.order.spi.message.vo.Message;
import com.qtz.id.spi.IdService;

@Service("messageServiceImpl")
public class MessageServiceImpl extends BaseServiceImpl<Message, Long> implements MessageService{

	/** 初始化日志对象 */
	private static Logger log = Logger.getLogger(MessageServiceImpl.class);
	
	@Autowired
	private MessageDao messageDao;
	
    @Resource(name = "idServiceImpl")
    private IdService idServiceImpl;
	

	@Override
	protected BizDao<Message, Long> getDao() {
		// TODO Auto-generated method stub
		return messageDao;
	}

	@Override
	public Result<Message> saveMessage(Message message) {
		
		Result<Message> result = new Result<>();
		
		try {
			
			if(message == null){
				result.setFailMessage("消息不能为空");
				return result;
			}
			
			if(message.getContent() == null){
				result.setFailMessage("消息内容不能为空");
				return result;
			}
			
			if(message.getUserId() == null){
				result.setFailMessage("消息接收人不能为空");
				return result;
			}
			
			if(message.getSourceId() == null){
				result.setFailMessage("消息来源ID不能为空");
				return result;
			}
			
			if(message.getType() == null){
				result.setFailMessage("消息类型不能为空");
				return result;
			}
			if(message.getDmId()==null||message.getDmId()<1){
			    message.setDmId(idServiceImpl.generateId());
			}
			getDao().addVo(message);
			
		} catch (Exception e) {
			log.error("MessageServiceImpl saveMessage exception|error:",e);
		}
		return result;
		
	}

	@Override
	public Result<Message> getMessageListByUserId(Long userId,int pageOffset) {
		
		Result<Message> result = new Result<>();
		
		try {
			
			MessagePage messagePage = new MessagePage();
		
			messagePage.setUserId(userId);
			
			messagePage.setNowPage(pageOffset);
			
			messagePage.setOrderField("createTime");
			
			messagePage.setOrderDirection(false);
			
			Pager<Message, Long> pager = super.query(messagePage, Message.class);
			
			result.setPager(pager);
			
		} catch (Exception e) {
			log.error("MessageServiceImpl getMessageListByUserId exception|userId="+userId,e);
			result.setCode(ExceptionCode.NULL_EXCEPTION);
			result.setFailMessage("系统异常");
			return result;
		}
		
		return result;
	}


}

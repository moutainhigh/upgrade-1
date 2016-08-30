package com.qtz.ht.order.service.order.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qtz.base.dao.BizDao;
import com.qtz.base.exception.DaoException;
import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.impl.BaseServiceImpl;
import com.qtz.ht.order.service.order.dao.OrderLogDao;
import com.qtz.ht.order.spi.order.service.OrderLogService;
import com.qtz.ht.order.spi.order.vo.OrderLog;
/**
 * <p>Title:OrderLogServiceImpl</p>
 * <p>Description:订单日志服务实现类</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
 * @author 涂鑫 -xin.tu
 * @version v1.0 2015-09-08
 */
@Service("origOrderLogServiceImpl")
public class OrderLogServiceImpl extends BaseServiceImpl<OrderLog,Long> implements OrderLogService  {
	/**初始化日志对象*/
	private static Logger log = Logger.getLogger(OrderLogServiceImpl.class);
	/**注入订单日志DAO接口类*/
	@Resource(name="orderLogDaoImpl")
    private OrderLogDao dao;
    
	/** 
	* 【取得】业务DAO对象
	* @return 	业务DAO对象  
	*/
	@Override
	protected BizDao<OrderLog,Long> getDao() {
		return dao;
	}
	
	@Override
	public List<OrderLog> findByOrderId(Long orderId) throws ServiceException{
		try {
			return dao.findByOrderId(orderId);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
	
	@Override
	public void updateOrderLogByOrderIdNotNull(OrderLog orderLog) throws ServiceException{
		try {
			dao.updateOrderLogByOrderIdNotNull(orderLog);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
	
	@Override
	public JSONArray getOrderStatus(long orderId) throws ServiceException{
		OrderLog where=new OrderLog();
		where.setOrderId(orderId);
		List<OrderLog> orderLogs = findList(where);
		
		JSONArray jsonArray=new JSONArray();
		for (OrderLog orderLog : orderLogs) {
			JSONObject json=new JSONObject();
			json.put("status", orderLog.getStatus());
			json.put("orderId", orderLog.getOrderId());
			json.put("time", orderLog.getTime());
			String title="";
			String note="";
			switch (orderLog.getStatus()) {
			case 5:
				title="订单提交成功";
				note="单号:"+orderId+",请耐心等待商家确认.";
				break;
			case 4:
				title="商家已经确认接单";
				note="单号:"+orderId+",请注意收货.";
				break;
			case 0:
				title="订单交易成功";
				note="订单交易成功,欢迎下次再来.";
				break;
			case 3:
			    note="商家拒绝接单";    
				title="商家拒绝接单";
				if (!org.springframework.util.StringUtils.isEmpty(orderLog.getNotes())) {
                  note+=",拒绝理由:"+orderLog.getNotes()+"";
                }
				note+="."; 
				break;
			case 7:
				title="申请退款中";
				note="商家会在72 小时内处理";
				if (!org.springframework.util.StringUtils.isEmpty(orderLog.getNotes())) {
                  note+=",退款理由:"+orderLog.getNotes()+"";
                }
                note+="请耐心等待...";
				
				break;
			case 2:
				title="商家同意退款";
				note="请前往钱包查收退款项";
				break;
				
			case 6:
				title="订单取消";
				note="订单取消,退款完成,交易完成.";
				break;
			case 8:
				title="拒绝退款";
				note="商家拒绝退款";
				if (!org.springframework.util.StringUtils.isEmpty(orderLog.getNotes())) {
                  note+=",拒绝理由:"+orderLog.getNotes()+"";
                }
				break;
			default:
				continue;
			}
			json.put("title", title);
			json.put("note", note);
			jsonArray.add(json);
		}
		return jsonArray;
	}
	@Override
	public void delOrderLogByOrderId(Long orderid) throws ServiceException {
		
		OrderLog ogLog = new OrderLog();
		
		ogLog.setOrderId(orderid);
		
		try {
			this.dao.delVo(ogLog);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		
	}
}

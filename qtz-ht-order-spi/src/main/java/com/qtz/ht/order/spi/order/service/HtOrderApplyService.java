package com.qtz.ht.order.spi.order.service;

import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.BaseService;
import com.qtz.ht.order.spi.common.Result;
import com.qtz.ht.order.spi.order.vo.HtOrderApply;

/**
 * <p>Title:OrderGoodsService</p>
 * <p>Description:订单申请（申请退货退款等）服务接口类</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
 * @author 
 * @version v1.0 2016-05-25
 */
public interface HtOrderApplyService extends BaseService<HtOrderApply,Long>{
	/**
	 * 用户发起订单申请（付款未发货退货申请 ，付款已发货退货申请）
	 * 
	 * @param htOrderApply
	 */
	void userApply(HtOrderApply htOrderApply) throws ServiceException;
	/**
	 * 商家回应用户发起的申请（商家拒绝退货，商家同意退货 ）
	 * 
	 * @param htOrderApply
	 */
	void shopReplyApply(HtOrderApply htOrderApply) throws ServiceException;
	/**
	 * 用户回应商家（填定快递号）
	 * 
	 * @param htOrderApply
	 */
	void userReplyApply(HtOrderApply htOrderApply) throws ServiceException;
	
	Result<HtOrderApply> getShopApplyById(Long orderApplyId);
	
	
	Result<HtOrderApply> getOrderApplyList(Long orderId);
}

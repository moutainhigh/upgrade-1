package com.qtz.ht.web.supplier.controller.wallet;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.qtz.base.common.ExceptionConstants;
import com.qtz.base.common.Pager;
import com.qtz.base.dto.order.PaymentMethodEnum;
import com.qtz.base.exception.ServiceException;
import com.qtz.base.response.RespJsonPHandler;
import com.qtz.ht.order.spi.common.Result;
import com.qtz.ht.order.spi.order.service.OrigOrderService;
import com.qtz.ht.order.spi.order.vo.HtOrder;
import com.qtz.ht.session.spi.user.vo.HtUser;
import com.qtz.ht.session.spi.wallet.page.HtStaffPaymentFlowPage;
import com.qtz.ht.session.spi.wallet.service.HtStaffPaymentFlowService;
import com.qtz.ht.session.spi.wallet.vo.HtStaffPaymentFlow;
import com.qtz.ht.spi.util.BeanUtils;
import com.qtz.ht.web.supplier.controller.BaseController;
import com.qtz.ht.web.supplier.model.HtStaffPaymentFlowResponseModel;

/**
 * <p>Title:HtStaffPaymentFlowController</p>
 * <p>Description:商户货款流水Controller类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: 深圳市擎天柱信息技术有限公司</p>
 * @author tanglijun
 * @version v1.0 2016-04-29
 */
@RestController
@RequestMapping("v1.0/payment")
public class HtStaffPaymentFlowController extends BaseController {
	/**初始化日志对象*/
	private final static Logger log= Logger.getLogger(HtStaffPaymentFlowController.class);
	/**注入商户货款流水Service类*/
	@Resource(name="htStaffPaymentFlowServiceImpl")
	private HtStaffPaymentFlowService htStaffPaymentFlowService; 
	
	@Autowired
	private OrigOrderService origOrderService;
	
	/** 
	* 【分页】
	* @param req
	* @param page
	* 
	* 
	* @return
	*/
	@RequestMapping(value="page")
	public void page(@RequestParam("token")String sid,
			@ModelAttribute HtStaffPaymentFlowPage page,
			HttpServletRequest request, HttpServletResponse response){
		try {
			HtUser user = getUser(sid);
			page.setBusiId(user.getBusiId());
			Pager<HtStaffPaymentFlow, Long> pageList =htStaffPaymentFlowService.query(page,null);
			Pager<HtStaffPaymentFlowResponseModel, Long> result = new Pager<>();	//返回结果
			BeanUtils.copyProperties(pageList, result);
			List<HtStaffPaymentFlow> list = pageList.getList();
			HtStaffPaymentFlowResponseModel model = null;
			if (null != list && list.size() > 0) {	
				List<HtStaffPaymentFlowResponseModel> listOrder = new ArrayList<>();
				for (HtStaffPaymentFlow htStaffPaymentFlow : list) {
					model = new HtStaffPaymentFlowResponseModel();
					BeanUtils.copyProperties(htStaffPaymentFlow, model);
					String payTypeName = PaymentMethodEnum.getTextByValue(htStaffPaymentFlow.getPaymentType());
					model.setPaymentTypeName(payTypeName);
					listOrder.add(model);
				}	
				result.setList(listOrder);
				
			}
			RespJsonPHandler.respOK(result,response,request);
		} catch (ServiceException e) {
			log.error(e);
			RespJsonPHandler.respError(e.getErrorType(), e.getErrorTitle(), response, request);
		}
	}
	
	
	/** 
	* 【查看】
	* @param req
	* @param dmId
	* @return
	*/
	@RequestMapping(value="input")
	public void input(@RequestParam("token") String sid,@RequestParam("dmId")Long dmId,
			HttpServletRequest request, HttpServletResponse response){
		try {
			HtStaffPaymentFlow vo = htStaffPaymentFlowService.findVo(dmId,null);
			if(vo!=null){
				Result<HtOrder> r = origOrderService.backstageOrderInfo(vo.getOrderId());
				HtOrder order = null;
				if (r.isSuccess() ) {
					order =  r.getCarrier();
				}
				
				JSONObject result = new JSONObject();
				result.put("detailsData", vo);
				result.put("order", order);
				RespJsonPHandler.respOK(result,response,request);	
			}else {
				RespJsonPHandler.respError(ExceptionConstants.ERRORCODE_7, "流水记录不存在", response, request);
			}
			
		} catch (ServiceException e) {
			log.error(e);
			RespJsonPHandler.respError(e.getErrorType(), e.getErrorTitle(), response, request);
		}
	}
}
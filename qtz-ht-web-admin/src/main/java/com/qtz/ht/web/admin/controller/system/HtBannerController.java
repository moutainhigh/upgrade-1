package com.qtz.ht.web.admin.controller.system;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qtz.base.common.ExceptionConstants;
import com.qtz.base.exception.ServiceException;
import com.qtz.base.response.RespJsonPHandler;
import com.qtz.ht.session.spi.user.vo.HtStaff;
import com.qtz.ht.spi.system.page.HtBannerPage;
import com.qtz.ht.spi.system.service.HtBannerService;
import com.qtz.ht.spi.system.vo.HtBanner;
import com.qtz.ht.spi.util.BeanUtils;
import com.qtz.ht.spi.util.ProcessingCheckExceptionUtil;
import com.qtz.ht.web.admin.controller.BaseController;
import com.qtz.ht.web.admin.model.BannerModel;
import com.qtz.ht.web.admin.model.First;
import com.qtz.ht.web.admin.model.Second;

/**
 * <p>Title:HtBannerController</p>
 * <p>Description:横幅管理表Controller类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: 深圳市擎天柱信息技术有限公司</p>
 * @author tanglijun
 * @version v1.0 2016-04-15
 */
@RestController
@RequestMapping("v1.0/banner")
public class HtBannerController extends BaseController {
	/**初始化日志对象*/
	private final static Logger log= Logger.getLogger(HtBannerController.class);
	/**注入横幅管理表Service类*/
	@Resource(name="htBannerServiceImpl")
	private HtBannerService htBannerService; 
	
	/** 
	* 【添加】
	* @param req
	* @param vo
	* @return
	*/
	@RequestMapping(value="add")
	public void add(@RequestParam("token") String sid,@Validated({Second.class})@ModelAttribute BannerModel vo,
			BindingResult result,
			HttpServletRequest request, HttpServletResponse response)
	{
		try {
			if (result.hasErrors()) {
				RespJsonPHandler.respInputError(ExceptionConstants.ERRORCODE_NEGATIVE1,ProcessingCheckExceptionUtil.abnormalConversion(result.getFieldErrors()), response, request);
			}else{
				HtStaff user = getUser(sid);
				HtBanner banner = new HtBanner();
				BeanUtils.copyProperties(vo, banner);
				banner.setCrUserId(user.getDmId());
				banner.setCrtime(System.currentTimeMillis());
				htBannerService.addVo(banner);
				RespJsonPHandler.respOK(response,request);
			}
		} catch (ServiceException e) {
			log.error(e);
			RespJsonPHandler.respError(e.getErrorType(), e.getErrorTitle(), response, request);
		}
	}
	
		/** 
	* 【修改保存】
	* @param req
	* @param vo
	* @return
	*/
	@RequestMapping(value="mod")
	public void mod(@RequestParam("token") String sid,@Validated({First.class})@ModelAttribute BannerModel vo,
			BindingResult result,
			HttpServletRequest request, HttpServletResponse response)
	{
		try {
			if (result.hasErrors()) {
				RespJsonPHandler.respInputError(ExceptionConstants.ERRORCODE_NEGATIVE1,ProcessingCheckExceptionUtil.abnormalConversion(result.getFieldErrors()), response, request);
			}else{
				HtBanner banner = new HtBanner();
				BeanUtils.copyProperties(vo, banner);
				htBannerService.modVoNotNull(banner);
				RespJsonPHandler.respOK(response,request);
			}
			RespJsonPHandler.respOK(response,request);
		} catch (ServiceException e) {
			log.error(e);
			RespJsonPHandler.respError(e.getErrorType(), e.getErrorTitle(), response, request);
		}
	}
	/** 
	* 【分页】
	* @param req
	* @param page
	* @return
	*/
	@RequestMapping(value="page")
	public void page(@RequestParam("token") String sid,HtBannerPage page,HttpServletRequest request, HttpServletResponse response)
	{
		try {
			RespJsonPHandler.respOK(htBannerService.query(page,null),response,request);
		} catch (ServiceException e) {
			log.error(e);
			RespJsonPHandler.respError(e.getErrorType(), e.getErrorTitle(), response, request);
		}
	}
	
	/** 
	* 【编辑】
	* @param req
	* @param id
	* @return
	*/
	@RequestMapping(value="input")
	public void input(@RequestParam("token") String sid,
			@RequestParam("dmId") Long id,
			HttpServletRequest request, HttpServletResponse response)
	{
		try {
			HtBanner vo = htBannerService.findVo(id,null);
			RespJsonPHandler.respOK(vo,response,request);	
		} catch (ServiceException e) {
			log.error(e);
			RespJsonPHandler.respError(e.getErrorType(), e.getErrorTitle(), response, request);
		}
	}
}
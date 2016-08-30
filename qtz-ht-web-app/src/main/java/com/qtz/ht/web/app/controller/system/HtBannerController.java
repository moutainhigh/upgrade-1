
package com.qtz.ht.web.app.controller.system;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qtz.base.exception.ServiceException;
import com.qtz.base.response.RespJsonPHandler;
import com.qtz.base.util.Constants;
import com.qtz.ht.spi.system.service.HtBannerService;
import com.qtz.ht.web.app.controller.BaseController;

/** 
 * ClassName:HtBannerController <br/> 
 * Function: TODO (banner 列表控制类). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2016年8月10日 下午8:08:40 <br/> 
 * @author   yxd 
 * @version   
 * @see       
 */
@RestController
@RequestMapping("v1.0/banner")
public class HtBannerController extends BaseController {
	/**初始化日志对象*/
	private final static Logger log= Logger.getLogger(HtBannerController.class);
	
	@Resource(name="htBannerServiceImpl")
	private HtBannerService htBannerService; 
	
	@RequestMapping(value="list")
	public void list(@RequestParam("versionType")Integer versionType, @RequestParam("clientType")Integer clientType,
			HttpServletRequest request, HttpServletResponse response){
		try {
			RespJsonPHandler.respOK(htBannerService.findSpecifyFieldList(versionType, clientType, Constants.ONE),response,request);
		} catch (ServiceException e) {
			log.error(e);
			RespJsonPHandler.respError(e.getErrorType(), e.getErrorTitle(), response, request);
		}
	}
}
  
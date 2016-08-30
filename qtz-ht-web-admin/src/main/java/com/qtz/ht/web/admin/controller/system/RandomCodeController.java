
package com.qtz.ht.web.admin.controller.system;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.qtz.base.exception.ServiceException;
import com.qtz.base.response.RespJsonPHandler;
import com.qtz.ht.web.admin.annotinter.RandomCodeInter;
import com.qtz.ht.web.admin.controller.BaseController;

/** 
 * ClassName:RandomCodeController <br/> 
 * Function: TODO (). <br/> 
 * Reason:   TODO (). <br/> 
 * Date:     2016年6月14日 下午6:05:08 <br/> 
 * @author   yxd 
 * @version   
 * @see       
 */
@RestController
@RequestMapping("system/randomCode")
public class RandomCodeController extends BaseController {
	/**初始化日志对象*/
//	private final static Logger log= Logger.getLogger(RandomCodeController.class);

	public static ConcurrentHashMap<String, String> RandomCode = new ConcurrentHashMap<String, String>();
	
	/**
	 * 
	 * putRandomCode:(). <br/> 
	 * TODO().<br/> 
	 * 
	 * @author yxd 
	 * @param key
	 * @param value
	 */
	public static void putRandomCode(String key , String value){
		RandomCode.put(key, value);
	}
	
	/**
	 * 
	 * remodeRandomCode:(). <br/> 
	 * TODO().<br/> 
	 * 
	 * @author yxd 
	 * @param key
	 */
	public static void remodeRandomCode(String key){
		RandomCode.remove(key);
	}
	/**
	 * 
	 * getRandomCode:(). <br/> 
	 * TODO().<br/> 
	 * 
	 * @author yxd 
	 * @param sid
	 * @param request
	 * @param response
	 */
	@RandomCodeInter(save=true)
	@RequestMapping(value="page")
	public void getRandomCode(@RequestParam("token") String sid,
			HttpServletRequest request,
			HttpServletResponse response) throws ServiceException{
		String uuid =UUID.randomUUID().toString();
		
		RandomCode.put(sid, uuid);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("uuid", uuid);
		RespJsonPHandler.respOK(jsonObject,response,request);
		
	}
}
  
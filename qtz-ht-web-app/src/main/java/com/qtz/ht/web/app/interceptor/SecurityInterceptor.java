package com.qtz.ht.web.app.interceptor;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.qtz.base.dto.DdmSession;
import com.qtz.base.dto.user.User;
import com.qtz.base.exception.ServiceException;
import com.qtz.base.response.RespHandler;
import com.qtz.base.response.RespMsg;
import com.qtz.base.util.Constants;
import com.qtz.base.util.StringUtil;
import com.qtz.commons.framework.SpringContextHelper;
import com.qtz.ht.session.spi.session.service.SessionService;

/**
 * 
 * <p>Title:SecurityInterceptor</p>
 * <p>Description:(安全拦截)</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
 * @author 涂鑫 - changbo.li
 * @version v1.0 2015年3月11日
 */
public class SecurityInterceptor implements HandlerInterceptor{
	private static Logger log=Logger.getLogger(SecurityInterceptor.class);
	
	private SessionService sessionService = (SessionService) SpringContextHelper.getBean("sessionService");
	
	
	//排除
	private List<String> excludeUrls;

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}
	public List<String> getExcludeUrls() {
		return excludeUrls;
	}
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws ServiceException, IOException{
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());
		if (excludeUrls.contains(url)) {
			return true;
		} else {
			for (String regex : excludeUrls) {
				String subN = StringUtil.subN(url, "/", 2);
				if(!subN.equals("logout") && Pattern.matches(regex, url)){
					return true;
				}
				
			}
			String sid = request.getHeader("token");
			if (StringUtils.isEmpty(sid)) {
//				RespHandler.respError(RespMsg.session_overdue, response);// session
//				return false;
			}else {
				DdmSession appSession = sessionService.getSession(sid);	
				if (appSession == null) {
					RespHandler.respError(RespMsg.session_overdue, response);// session
					return false;
				}
				Object obj=appSession.getSessionObject(Constants.SESSION_USER);
				if(obj==null){
	                   log.info("登录信息  obj:["+obj+"]异常");
	                    return false;
	                }
				if(obj instanceof User){
					User user = (User)obj;
					log.debug("+++++++++++++++++++++++");
					log.debug("拦截到请求  token  :"+sid+", USERID: [ " + user.getDmId()+ " ]"+",NAME: [ "+user.getName()+"]"+ ", IP: " + request.getRemoteAddr() + ", REQUESTURL: "+request.getRequestURL() + ",  USER-AGENT: " + request.getHeader("User-Agent") + ",  SESSIONID: "+appSession.getId() );
					log.debug("+++++++++++++++++++++++");
				}else{
					RespHandler.respError(RespMsg.session_overdue, response);// session
					return false;
				}
			}
			
			return true;
		}
	}
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
		String sid = request.getHeader("token");
		if (!StringUtils.isEmpty(sid)) {
			DdmSession appSession = sessionService.getSession(sid);
			if (appSession != null) {
				sessionService.saveSession(appSession);
			}
		}
	}
}
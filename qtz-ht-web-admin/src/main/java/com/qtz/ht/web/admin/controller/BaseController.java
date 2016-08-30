package com.qtz.ht.web.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.qtz.base.dto.DdmSession;
import com.qtz.base.exception.ExceptionCode;
import com.qtz.base.exception.ServiceException;
import com.qtz.base.response.RespHandler;
import com.qtz.base.response.RespJsonPHandler;
import com.qtz.base.response.RespMsg;
import com.qtz.base.util.Constants;
import com.qtz.ht.session.spi.session.service.SessionService;
import com.qtz.ht.session.spi.user.vo.HtStaff;

@Component
public abstract class BaseController
{

    protected static Logger log = Logger.getLogger(BaseController.class);

    // public static final String REQUEST_DATA = "dm_data";//请求数据
    @Autowired
    protected SessionService sessionService;

    /**
     * 
     * 取得用户id 如果返回为null则表示未登录
     * @param sessionid
     * @return
     * @throws ServiceException
     */
    protected HtStaff getUser(String sid) throws ServiceException
    {
        HtStaff user = null;
        if (!StringUtils.isEmpty(sid))
        {
            DdmSession appSession = sessionService.getSession(sid);
            if (null != appSession)
            {
                Object obj = appSession.getSessionObject(Constants.SESSION_USER);
                if (obj instanceof HtStaff)
                {
                    return (HtStaff) obj;
                }
            }
        }
        return user;
    }

    // @ExceptionHandler
    public void exp(HttpServletRequest request, Exception ex, HttpServletResponse response)
    {
        // 记录日志
        StringBuffer sb = new StringBuffer();
        StackTraceElement[] stackArray = ex.getStackTrace();
        for (int i = 0; i < stackArray.length; i++)
        {
            StackTraceElement element = stackArray[i];
            sb.append(element.toString() + "\n");
        }
        log.error("" + sb.toString() + "" + ex.getMessage(), ex);
        // 根据不同错误转向不同页面
        if (ex instanceof ServiceException)
        {
            ServiceException e = (ServiceException) ex;
            switch (e.getErrorType())
            {
            case ExceptionCode.GOODSCATEGORY_NULL_EXCEPTION:
                RespJsonPHandler.respError(RespMsg.goodsCategory_dont_exist, response, request);
                break;
            case ExceptionCode.PRICE_ERROR:
                RespJsonPHandler.respError(RespMsg.price_error, response, request);
                break;
            case ExceptionCode.USER_NO_LOGIN:
                RespJsonPHandler.respApiLoginError(response, request);
                break;
            case ExceptionCode.DEL_GOODSCATEGORY_EXIST_PRODUCT:
                RespJsonPHandler.respError(RespMsg.goodsCategory_product_error, response, request);
                break;
            case ExceptionCode.USER_NO_AUTHEN:
                RespJsonPHandler.respError(RespMsg.account_no_auth, response, request);
                break;
            case ExceptionCode.SELLER_NO_OPEN_STORE:
                RespJsonPHandler.respError(RespMsg.seller_no_store, response, request);
                break;
            case ExceptionCode.EXIST_BUSINESSLICENSENAME:
                RespJsonPHandler.respError(RespMsg.exist_businesslicensename, response, request);
                break;
            case ExceptionCode.BUSINESSLICENSENAME_LENGTH_GT_30:
                RespJsonPHandler.respError(RespMsg.businessLicenseName_length_gt_30, response, request);
                break;
            case ExceptionCode.BUSINESSLICENSENAME_LENGTH_LT_5:
                RespJsonPHandler.respError(RespMsg.businessLicenseName_length_lt_5, response, request);
                break;
            default:
                RespJsonPHandler.respServerError(response, request);
                break;
            }
            return;
        }
        else
        {
            RespJsonPHandler.respServerError(response, request);
        }
    }

    /**
     * 根据票据，获取用户ID
     * @param sid 票据
     * @param response
     * @return
     * @throws ServiceException
     */
    public Long getUserId(String sid, HttpServletResponse response) throws ServiceException
    {
        HtStaff user = getUser(sid);
        if (user == null)
        {
            RespHandler.respError(RespMsg.user_not_login, response);
            return null;
        }
        return user.getDmId();
    }
}

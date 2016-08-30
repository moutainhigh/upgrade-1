
package com.qtz.ht.web.supplier.controller.wallet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qtz.base.dto.order.PaymentMethodEnum;
import com.qtz.base.dto.user.UserType;
import com.qtz.base.response.RespJsonPHandler;
import com.qtz.ht.web.supplier.controller.BaseController;

/**
 * ClassName:HtPaymentTypeController <br/>
 * Function: TODO (). <br/>
 * Reason: TODO (). <br/>
 * Date: 2016年6月27日 下午5:42:13 <br/>
 * @author yxd
 * @version
 * @see
 */
@RestController
@RequestMapping("v1.0/htPaymentType")
public class HtPaymentTypeController extends BaseController
{
    /**
     * 【分页】
     * @param req
     * @param page
     * @return
     */
    @RequestMapping(value = "getAllHtPaymentType")
    public void getAllHtPaymentType(@RequestParam("token") String sid, HttpServletRequest request,
        HttpServletResponse response)
    {
        RespJsonPHandler.respOK(PaymentMethodEnum.getTypesByUserType(UserType.PERSON.value()), response, request);
    }
}

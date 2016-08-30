package com.qtz.ht.web.app.controller.order;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qtz.base.dto.user.User;
import com.qtz.base.exception.ServiceException;
import com.qtz.base.response.RespHandler;
import com.qtz.ht.order.spi.common.Result;
import com.qtz.ht.order.spi.message.service.MessageService;
import com.qtz.ht.order.spi.message.vo.Message;
import com.qtz.ht.web.app.controller.BaseController;

@RestController
@RequestMapping(value = "/v1.0/message/")
public class MessageController extends BaseController
{

    protected static Logger log = Logger.getLogger(MessageController.class);

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "getMessageByUserId", method = RequestMethod.GET)
    public void getMessageByUserId(@RequestHeader("token") String sid,
        @RequestParam(value = "nowPage", required = false) Integer nowPage, HttpServletResponse response,
        HttpServletRequest request) throws IOException
    {

        try
        {

            User user = getUser(sid);

            Result<Message> result = messageService.getMessageListByUserId(user.getDmId(), nowPage);

            if (result.isSuccess())
            {
                RespHandler.respOK(result.getPager(), result.getPager().getList(), response);
            }
            else
            {
                RespHandler.respError(result.getCode(), result.getFailMessage(), response);
            }

        }
        catch (ServiceException e)
        {
            RespHandler.respError(e.getErrorType(), e.getErrorTitle(), response);
        }
    }

}
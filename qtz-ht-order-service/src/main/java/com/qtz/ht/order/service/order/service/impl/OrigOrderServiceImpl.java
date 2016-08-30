package com.qtz.ht.order.service.order.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.qtz.base.dto.user.User;
import com.qtz.base.exception.ServiceException;
import com.qtz.ht.order.service.order.transactional.HtOrderTransactional;
import com.qtz.ht.order.spi.common.HtOrderEnum;
import com.qtz.ht.order.spi.common.Result;
import com.qtz.ht.order.spi.order.model.PayHtOrderModel;
import com.qtz.ht.order.spi.order.page.HtOrderPage;
import com.qtz.ht.order.spi.order.service.OrigOrderService;
import com.qtz.ht.order.spi.order.vo.HtOrder;
import com.qtz.ht.spi.order.model.OrderModel;
import com.qtz.ppsh.order.spi.dto.OrderPrefix;

/**
 * <p>
 * Title:OrderServiceImpl
 * </p>
 * <p>
 * Description:订单服务实现类
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: 深圳市擎天柱信息科技有限公司
 * </p>
 * 
 * @author 涂鑫 -xin.tu
 * @version v1.0 2015-09-02
 */
@Service("origOrderServiceImpl")
public class OrigOrderServiceImpl implements OrigOrderService
{

    /** 初始化日志对象 */
    private static Logger log = Logger.getLogger(OrigOrderServiceImpl.class);

    @Autowired
    private HtOrderTransactional htOrderTransactional;

    @Override
    public Result<HtOrder> saveSubOrder(Map<Long, Integer> goodsMaps, Long receivingId, User user, String note,
        Integer cliType)
    {

        try
        {

            return htOrderTransactional.saveSubOrder(goodsMaps, receivingId, user, note, cliType);

        }
        catch (ServiceException e)
        {
            log.error(user.getDmId() + e.getErrorMessage() + e);
            return new Result<>(e.getErrorMessage(), e.getErrorType());
        }

    }

    @Override
    public Result<HtOrder> calculatePaymentPrice(Long orderId)
    {

        try
        {

            return htOrderTransactional.calculatePaymentPrice(orderId);

        }
        catch (ServiceException e)
        {
            log.error(orderId + e.getErrorMessage() + e);
            return new Result<>(e.getErrorMessage(), e.getErrorType());
        }
    }

    @Override
    public Result<HtOrder> getHtOrderList(Long userId, Integer status, Integer pageIndex)
    {
        try
        {

            return htOrderTransactional.getHtOrderList(userId, status, pageIndex);

        }
        catch (ServiceException e)
        {
            log.error(userId + e.getErrorMessage() + e);
            return new Result<>(e.getErrorMessage(), e.getErrorType());
        }
    }

    @Override
    public Result<HtOrder> getHtOrderInfo(Long htOrderId)
    {

        try
        {

            return htOrderTransactional.getHtOrderInfo(htOrderId);

        }
        catch (ServiceException e)
        {
            log.error(e);
            return new Result<>("", -1);
        }
    }

    @Override
    public Result<HtOrder> updateCancelOrder(Long orderId, Long persionId)
    {
        try
        {

            return htOrderTransactional.updateCancelOrder(orderId, persionId);

        }
        catch (ServiceException e)
        {
            log.error(orderId + "应订单取消失败" + e);
            return new Result<>(e.getErrorMessage(), e.getErrorType());
        }
    }

    @Override
    public Result<HtOrder> applyRefund(Long userId, Long orderId, Integer whetherGoods, String reason, String goodsImg)
    {
        try
        {

            return htOrderTransactional.applyRefund(userId, orderId, whetherGoods, reason, goodsImg);

        }
        catch (ServiceException e)
        {
            log.error("会员" + userId + "申请" + orderId + "退款失败" + e);
            return new Result<>(e.getErrorMessage(), e.getErrorType());
        }
    }

    @Override
    public Result<HtOrder> shopNotRefund(Long sellerId, Long orderId, String messag, Integer deliver)
    {
        try
        {

            return htOrderTransactional.shopNotRefund(sellerId, orderId, messag);

        }
        catch (ServiceException e)
        {
            log.error(sellerId + "商家不同意退款操作失败");
            return new Result<>(e.getErrorMessage(), e.getErrorType());
        }
    }

    @Override
    public Result<HtOrder> notShippedAgreedRefund(Long sellerId, Long orderId)
    {
        try
        {

            return htOrderTransactional.notShippedAgreedRefund(sellerId, orderId);

        }
        catch (ServiceException e)
        {
            log.error(e);
            return new Result<>(e.getErrorMessage(), e.getErrorType());
        }
    }

    @Override
    public Result<HtOrder> alreadyShippedAgreedRefund(Long sellerId, Long orderId, String address, String tel,
        String consignee)
    {
        try
        {

            return htOrderTransactional.alreadyShippedAgreedRefund(sellerId, orderId, address, tel, consignee);

        }
        catch (ServiceException e)
        {
            log.error(e);
            return new Result<>(e.getErrorMessage(), e.getErrorType());
        }
    }

    @Override
    public Result<HtOrder> adminReturnGoods(Long orderId, String address, String tel, String consignee)
    {
        try
        {

            return htOrderTransactional.adminReturnGoods(orderId, address, tel, consignee);

        }
        catch (ServiceException e)
        {
            log.error(e);
            return new Result<>(e.getErrorMessage(), e.getErrorType());
        }
    }

    @Override
    public Result<HtOrder> adminArbitration(Long orderId, String content)
    {
        try
        {

            return htOrderTransactional.adminArbitration(orderId, content);

        }
        catch (ServiceException e)
        {
            log.error(e);
            return new Result<>(e.getErrorMessage(), e.getErrorType());
        }
    }

    @Override
    public Result<HtOrder> adminRefund(Long orderId)
    {
        try
        {

            return htOrderTransactional.adminRefund(orderId);

        }
        catch (ServiceException e)
        {
            log.error(e);
            return new Result<>(e.getErrorMessage(), e.getErrorType());
        }
    }

    @Override
    public Result<HtOrder> customerDelivery(Long orderId, String express, String expressCode, Long deliverTime)
    {
        try
        {

            return htOrderTransactional.customerDelivery(orderId, express, expressCode, deliverTime);

        }
        catch (ServiceException e)
        {
            log.error(e);
            return new Result<>(e.getErrorMessage(), e.getErrorType());
        }
    }

    @Override
    public Result<HtOrder> shopConfirmOrder(Long sellerId, Long orderId)
    {
        try
        {

            return htOrderTransactional.shopConfirmOrder(sellerId, orderId);

        }
        catch (ServiceException e)
        {
            log.error(e);
            return new Result<>(e.getErrorMessage(), e.getErrorType());
        }
    }

    @Override
    public Result<HtOrder> shopDeliverGoods(Long orderId, String express, String expressCode)
    {
        try
        {

            return htOrderTransactional.shopDeliverGoods(orderId, express, expressCode);

        }
        catch (ServiceException e)
        {
            log.error(e);
            return new Result<>(e.getErrorMessage(), e.getErrorType());
        }
    }

    @Override
    public Result<HtOrder> backstageOrderInfo(Long orderId)
    {
        try
        {

            return htOrderTransactional.backstageOrderInfo(orderId);

        }
        catch (ServiceException e)
        {
            log.error(e);
            return new Result<>(e.getErrorMessage(), e.getErrorType());
        }
    }

    @Override
    public Result<HtOrder> userConfirmReceipt(Long orderId)
    {
        try
        {

            return htOrderTransactional.userConfirmReceipt(orderId);

        }
        catch (ServiceException e)
        {
            log.error(e);
            return new Result<>(e.getErrorMessage(), e.getErrorType());
        }
    }

    @Override
    public Result<HtOrder> getOrderApplyById(Long orderApplyId)
    {
        try
        {

            return htOrderTransactional.getOrderApplyById(orderApplyId);

        }
        catch (ServiceException e)
        {
            log.error(e);
            return new Result<>(e.getErrorMessage(), e.getErrorType());
        }
    }

    @Override
    public Result<HtOrder> getOrderstatusList(Long orderId)
    {
        try
        {

            return htOrderTransactional.getOrderstatusList(orderId);

        }
        catch (ServiceException e)
        {
            log.error(e);
            return new Result<>(e.getErrorMessage(), e.getErrorType());
        }
    }

    @Override
    public PayHtOrderModel queryOrderByIdOrBatchId(Long orderId)
    {
        try
        {

            return htOrderTransactional.queryOrderByIdOrBatchId(orderId);

        }
        catch (ServiceException e)
        {
            log.error(e);
            return null;
        }
    }

    @Override
    public List<HtOrder> processPayCallback(HtOrder order) throws ServiceException
    {
        try
        {
            return htOrderTransactional.processPayCallback(order);
        }
        catch (ServiceException e)
        {
            return null;
        }
    }

    @Override
    public List<Map<String, Object>> findGoodsOrderMap(Map<String, Object> param) throws ServiceException
    {
        try
        {
            return htOrderTransactional.findGoodsOrderMap(param);
        }
        catch (ServiceException e)
        {
            return null;
        }
    }

    @Override
    public HtOrderPage query(HtOrderPage page) throws ServiceException
    {
        try
        {
            return htOrderTransactional.query(page);
        }
        catch (ServiceException e)
        {
            return null;
        }
    }

    @Override
    public List<HtOrder> htOrderByIdList(Long orderId)
    {
        HtOrder order = new HtOrder();

        if (String.valueOf(orderId)
            .substring(HtOrderEnum.interceptState.start.getId(), HtOrderEnum.interceptState.end.getId())
            .equals(OrderPrefix.PP_HT_ORDER + HtOrderEnum.htOrderPrefix.sonPrefix.getId()))
        {
            order.setDmId(orderId);
        }
        else if (String.valueOf(orderId)
            .substring(HtOrderEnum.interceptState.start.getId(), HtOrderEnum.interceptState.end.getId())
            .equals(OrderPrefix.PP_HT_ORDER + HtOrderEnum.htOrderPrefix.batchPrefix.getId()))
        {
            order.setBatchId(orderId);
        }

        try
        {

            return htOrderTransactional.findList(order);

        }
        catch (ServiceException e)
        {
            log.error(e);
        }
        return null;
    }

    @Override
    public Result<HtOrder> replenishmentOrder(Long orderId, String constantKey)
    {

        Result<HtOrder> result = new Result<>();
        try
        {

            return htOrderTransactional.replenishmentOrder(orderId, constantKey);

        }
        catch (ServiceException e)
        {
            log.error(e);
            result.setSuccess(false);
            result.setCode(e.getErrorType());
            result.setFailMessage(e.getErrorMessage());
            return result;
        }
    }

    @Override
    public Result<HtOrder> queryOrderGoodsByOrderId(Long orderId)
    {
        Result<HtOrder> result = new Result<>();

        try
        {

            return htOrderTransactional.queryOrderGoodsByOrderId(orderId);

        }
        catch (ServiceException e)
        {
            log.error(e);
            result.setSuccess(false);
            result.setCode(e.getErrorType());
            result.setFailMessage(e.getErrorMessage());
            return result;
        }
    }

    @Override
    public Result<HtOrder> saveActivityOrder(String orderModel, Long userId, String userName, Integer userType,
        String tel, String idCard, String payPassword)
    {
        Result<HtOrder> result = new Result<>();

        try
        {

            if (userId == null)
            {
                result.setFailMessage("用户信息不为空");
                result.setCode(-1);
                return result;
            }

            if (userName == null)
            {
                result.setFailMessage("用户名不为空");
                result.setCode(-1);
                return result;
            }

            if (idCard == null)
            {
                result.setFailMessage("用户地址信息不为空");
                result.setCode(-1);
                return result;
            }

            if (StringUtils.isBlank(payPassword))
            {
                result.setFailMessage("支付密码不能为空");
                result.setCode(-1);
                return result;
            }

            return htOrderTransactional.saveActivityOrder(JSONObject.parseObject(orderModel, OrderModel.class), userId,
                userName, userType, tel, idCard, payPassword);

        }
        catch (ServiceException e)
        {
            log.error(e);
            result.setSuccess(false);
            result.setCode(e.getErrorType());
            result.setFailMessage(e.getErrorMessage());
            return result;
        }
    }
    

	@Override
	public Result<HtOrder> modifyExpressCore(Long orderId,Long staffCode, String expressName, String expressCore) {
		Result<HtOrder> result = new Result<>();
		
		try {
			
			if(orderId == null){
				result.setFailMessage("订单ID不能为空");
				result.setCode(-1);
				return result;
			}
			
			if(StringUtils.isBlank(expressCore)){
				result.setFailMessage("快递号不能为空");
				result.setCode(-1);
				return result;
			}
			
			if(staffCode == null){
				result.setFailMessage("供应商ID不能为空");
				result.setCode(-1);
				return result;
			}
			
			if(StringUtils.isBlank(expressName)){
				result.setFailMessage("快递名称不能为空");
				result.setCode(-1);
				return result;
			}
			
			return htOrderTransactional.modifyExpressCore(orderId, staffCode, expressName, expressCore);
			
		} catch (ServiceException e) {
			log.error(e);
			result.setSuccess(false);
			result.setCode(e.getErrorType());
			result.setFailMessage(e.getErrorMessage());
			return result;
		}
	}
}

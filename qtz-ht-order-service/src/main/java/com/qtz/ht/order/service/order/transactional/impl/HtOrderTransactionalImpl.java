package com.qtz.ht.order.service.order.transactional.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.qtz.base.common.ExceptionConstants;
import com.qtz.base.common.Pager;
import com.qtz.base.dao.BizDao;
import com.qtz.base.dto.order.PayStatusEnum;
import com.qtz.base.dto.order.PaymentMethodEnum;
import com.qtz.base.dto.user.User;
import com.qtz.base.dto.user.UserType;
import com.qtz.base.enums.Status;
import com.qtz.base.exception.DaoException;
import com.qtz.base.exception.ExceptionCode;
import com.qtz.base.exception.ServiceException;
import com.qtz.base.response.RespCode;
import com.qtz.base.service.impl.BaseServiceImpl;
import com.qtz.base.util.ReconciliationResult;
import com.qtz.commons.math.ArithUtil;
import com.qtz.commons.text.CfgHelper;
import com.qtz.commons.time.DateUtil;
import com.qtz.ht.order.service.order.dao.OrderDao;
import com.qtz.ht.order.service.order.transactional.HtOrderTransactional;
import com.qtz.ht.order.spi.common.HtOrderEnum;
import com.qtz.ht.order.spi.common.HtOrderEnum.htOrderPrefix;
import com.qtz.ht.order.spi.common.HtOrderStatusConstant;
import com.qtz.ht.order.spi.common.MessageConstant;
import com.qtz.ht.order.spi.common.Result;
import com.qtz.ht.order.spi.message.service.MessageService;
import com.qtz.ht.order.spi.message.vo.Message;
import com.qtz.ht.order.spi.order.model.DisProfits;
import com.qtz.ht.order.spi.order.model.PayHtOrderModel;
import com.qtz.ht.order.spi.order.page.HtOrderPage;
import com.qtz.ht.order.spi.order.service.HtOrderApplyService;
import com.qtz.ht.order.spi.order.service.OrderGoodsService;
import com.qtz.ht.order.spi.order.service.OrderLogService;
import com.qtz.ht.order.spi.order.view.HtOrderCalculateView;
import com.qtz.ht.order.spi.order.view.HtOrderGoodsPayView;
import com.qtz.ht.order.spi.order.view.HtOrderGoodsView;
import com.qtz.ht.order.spi.order.view.HtOrderStatusView;
import com.qtz.ht.order.spi.order.view.HtOrderView;
import com.qtz.ht.order.spi.order.vo.HtOrder;
import com.qtz.ht.order.spi.order.vo.HtOrderApply;
import com.qtz.ht.order.spi.order.vo.HtOrderGoods;
import com.qtz.ht.order.spi.order.vo.OrderLog;
import com.qtz.ht.spi.good.vo.HtStaffGoods;
import com.qtz.ht.spi.order.model.OrderModel;
import com.qtz.ht.spi.order.service.HtOrderService;
import com.qtz.id.spi.IdService;
import com.qtz.jpush.dto.JpushDto;
import com.qtz.member.spi.mq.service.ReconciliationMessageService;
import com.qtz.member.spi.user.dto.UserReceivingInfo;
import com.qtz.member.spi.user.service.UserReceivingInfoService;
import com.qtz.member.spi.user.service.UsersService;
import com.qtz.member.spi.user.service.UsersShopService;
import com.qtz.member.spi.userwallet.dto.UserConsumptionFlow;
import com.qtz.member.spi.userwallet.dto.UserWallet;
import com.qtz.member.spi.userwallet.enums.UserWalletCountEnum;
import com.qtz.member.spi.userwallet.service.ReconciliationRecordService;
import com.qtz.member.spi.userwallet.service.SimpleUserWalletService;
import com.qtz.member.spi.userwallet.service.UserConsumptionFlowService;
import com.qtz.member.spi.userwallet.service.UserWalletService;
import com.qtz.msg.spi.JpushService;
import com.qtz.ppsh.order.spi.dto.OrderPrefix;
import com.qtz.system.spi.jpush.dto.CustomMsg;
import com.qtz.system.spi.jpush.model.MsgOutput;
import com.qtz.system.spi.jpush.service.CustomMsgService;
import com.qtz.system.spi.rule.dto.RemissionRule;
import com.qtz.system.spi.rule.service.RemissionRuleService;

@Service("htOrderTransactionalImpl")
public class HtOrderTransactionalImpl extends BaseServiceImpl<HtOrder, Long>implements HtOrderTransactional
{

    /** 初始化日志对象 */
    private static Logger log = Logger.getLogger(HtOrderTransactionalImpl.class);

    private static Lock lock = new ReentrantLock();// 锁对象
    /** 注入订单DAO接口类 */

    @Resource(name = "orderDaoImpl")
    private OrderDao dao;
    @Autowired
    private OrderGoodsService orderGoodsService;
    @Autowired
    private UserReceivingInfoService receivingInfoService;
    @Autowired
    private OrderLogService orderLogService;
    @Autowired
    private UserWalletService userWalletService;
    @Autowired
    private JpushService jpushService;
    @Autowired
    private ReconciliationRecordService reconciliationRecordService;
    @Autowired
    private HtOrderService htOrderServices;
    @Autowired
    private UsersService usersService;
    @Autowired
    private UsersShopService usersShopService;
    @Autowired
    private HtOrderApplyService htOrderApplyService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private SimpleUserWalletService simpleUserWalletService;
    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;
    @Autowired
    private RemissionRuleService remissionRuleService;
    @Autowired
    private UserConsumptionFlowService userConsumptionFlowService;
    @Autowired
    private ReconciliationMessageService reconciliationMessageService;
    @Autowired
	private CustomMsgService customMsgService;

    @Resource(name = "idServiceImpl")
    private IdService idServiceImpl;
    
    private static final int orderTime = 1800;

    /**
     * 【取得】业务DAO对象
     * 
     * @return 业务DAO对象
     */
    @Override
    protected BizDao<HtOrder, java.lang.Long> getDao()
    {
        return dao;
    }

    /**
     * 
     * 【互斥锁】
     * @param orderId
     * @return
     * @throws ServiceException
     * @time:2016年1月14日 下午6:04:49
     * @author 涂鑫
     * @version
     */
    private HtOrder lockOrder(Long orderId) throws ServiceException
    {
        lock.lock();// 得到锁
        synchronized (orderId)
        {
            try
            {
                return dao.getLockOrder(orderId);
            }
            catch (DaoException e)
            {
                log.error(e);
                throw new ServiceException(e);
            }
        }
    }

    /**
     * 订单提交前的校验
     * 
     * @param user
     * @param goodsMaps
     * @param userReceivingInfo
     * @param receivingId
     * @throws ServiceException
     */
    private void orderVerification(User user, Map<Long, Integer> goodsMaps, UserReceivingInfo userReceivingInfo,
        Long receivingId, String note, Result<HtOrder> result) throws ServiceException
    {

        if (note != null && note.length() > 22)
        {
            result.setCode(-1);
            result.setFailMessage("订单备注不能超过22字");
            return;
        }

        if (user.getUserType().intValue() == UserType.BUSINESS.value())
        {

            result.setCode(ExceptionCode.ORDER_SUB_SELLER_ERROR);
            result.setFailMessage("订单提交有误  商家不允许买");
            return;
        }

        if (goodsMaps == null || goodsMaps.isEmpty())
        {

            result.setCode(ExceptionCode.NULL_EXCEPTION);
            result.setFailMessage("商品不能为空");
            return;
        }else{
        	for(Long key : goodsMaps.keySet()){
				
				if(goodsMaps.get(key) > 20){
					
					result.setCode(ExceptionCode.ORDER_SUB_ERROR);
					result.setFailMessage("单个商品不能超过20件");
					
					return;
				}
			}
        }

        UserReceivingInfo uri = receivingInfoService.findVo(receivingId, userReceivingInfo);

        if (uri == null)
        {

            result.setCode(ExceptionCode.NULL_EXCEPTION);
            result.setFailMessage("收货地址null");
            return;
        }

        if (uri.getStatus() != Status.OK.value())
        {

            result.setCode(ExceptionCode.RECEIVINGINFO_STATUS_ERROR);
            result.setFailMessage("收货地址status错误");
            return;
        }

        if (uri.getUserId().longValue() != user.getDmId().longValue())
        {

            result.setCode(ExceptionCode.ORDER_SUB_ERROR);
            result.setFailMessage("订单提交有误,收货人错误");
            return;
        }

        if (StringUtils.isBlank(uri.getPno()))
        {
            result.setCode(ExceptionCode.ORDER_SUB_ERROR);
            result.setFailMessage("订单提交有误,收货人身份证号码不能为空");
            return;
        }

        try
        {
            BeanUtils.copyProperties(userReceivingInfo, uri);
        }
        catch (Exception e)
        {
            result.setCode(ExceptionCode.ORDER_SUB_ERROR);
            result.setFailMessage("订单提交有误,收货人信息错误");
            return;
        }
    }

    /**
     * 子订单商品处理
     * 
     * @param goodsLs 订单对应商品VO类 集合
     * @param goods 商户商品操作记录VO类 集合
     * 
     * @param orderTotal 订单总价格
     * @param orderId 订单Id
     * 
     * @throws ServiceException
     */
    private void subOrderCalculation(List<HtOrderGoods> goodsLs, List<HtStaffGoods> goods, double orderTotal,
        int goodsNumTotal, Long orderId) throws ServiceException
    {
    	log.info("HtOrderTransactionalImpl subOrderCalculation|orderId="+orderId);
        List<HtOrderGoods> add=Lists.newArrayList();
        for (HtStaffGoods gs : goods)
        {

            HtOrderGoods og = new HtOrderGoods();

            double goodsTotalPrice = ArithUtil.mul(gs.getBuyNumber(), gs.getPrice());

            double countMoney = ArithUtil.mul(gs.getBuyNumber(), gs.getCostPrice());

            double totalFinalPrice = ArithUtil.mul(gs.getBuyNumber(), gs.getFinalPrice() != null ? gs.getFinalPrice() : 0d);

            orderTotal += countMoney;

            goodsNumTotal = goodsNumTotal + gs.getBuyNumber();

            if (gs.getStatus().intValue() == 2)
            {

                throw new ServiceException(ExceptionCode.GOODS_DOWN, "商品下架");
            }
            og.set(orderId, gs.getGoodName(), goodsTotalPrice, gs.getDmId(), gs.getPrice(), gs.getCostPrice(),
                countMoney, null, null, gs.getBuyNumber(), 1, 1, null, null, null, null, null, null,
                gs.getMainPicture(), null, null, 1, null, null, gs.getGoodCode(),
                gs.getFinalPrice() != null ? gs.getFinalPrice() : 0d, totalFinalPrice);
            if(og.getDmId()==null||og.getDmId()<1){
                og.setDmId(this.idServiceImpl.generateId());
                add.add(og);
            }else{
                orderGoodsService.modVo(og);
            }
            goodsLs.add(og);
        }
        orderGoodsService.addList(add);
        log.info("HtOrderTransactionalImpl subOrderCalculation|add orderGoodsService success!");
    }

    /**
     * 订单日志记录
     * 
     * @param orders
     * @throws Exception
     */
    private void orderLog(List<HtOrder> orders) throws ServiceException
    {

        log.info("正在记录订单日志...");

        for (HtOrder htOrder : orders)
        {

            OrderLog save = new OrderLog();

            save.setOrderId(htOrder.getDmId());

            save.setStatus(PayStatusEnum.PAY_FAILURE.getId());// 初始订单日志未支付

            save.setTime(htOrder.getCrtime());
            if(save.getDmId()==null||save.getDmId()<1){
                save.setDmId(this.idServiceImpl.generateId());
                orderLogService.addVo(save);
               }else{
                   orderLogService.modVo(save);
               }

        }

    }

    @Override
    public Result<HtOrder> updateCancelOrder(Long orderId, Long persionId) throws ServiceException
    {
        Result<HtOrder> result = new Result<>();

        try
        {

            HtOrder order = lockOrder(orderId.longValue());
            if (order.getVipCode().longValue() != persionId.longValue())
            {

                result.setCode(ExceptionCode.ORDER_USER_FALSENESS);
                result.setFailMessage("订单下单用户不正确");
                return result;
            }
            if (order.getStatus().intValue() == HtOrderEnum.OrderStatus.unpay.getId())
            {
                // 订单未支付取消订单
                HtOrder updateOrder = new HtOrder();
                updateOrder.setDmId(orderId);
                updateOrder.setStatus(HtOrderEnum.OrderStatus.cancel.getId());
                // 删除订单
                // delId(orderId);
                modVoNotNull(updateOrder);
                OrderLog orderLog = new OrderLog();
                orderLog.setOrderId(orderId);
                orderLog.setStatus(HtOrderEnum.OrderStatus.cancel.getId());
                orderLog.setTime(System.currentTimeMillis());
                if(orderLog.getDmId()==null||orderLog.getDmId()<1){
                    orderLog.setDmId(this.idServiceImpl.generateId());
                    orderLogService.addVo(orderLog);
                   }else{
                       orderLogService.modVo(orderLog);
                   }
            }

        }
        finally
        {
            lock.unlock();
        }

        return result;
    }

    @Override
    public Result<HtOrder> applyRefund(Long userId, Long orderId, Integer whetherGoods, String reason, String goodsImg)
        throws ServiceException
    {
        Result<HtOrder> result = new Result<>();

        try
        {

            HtOrder order = lockOrder(orderId.longValue());

            if (!checkNotShippedOrder(result, order, userId))
            {
                return result;
            }
            

            HtOrder htOrder = new HtOrder();

            htOrder.setDmId(order.getDmId());
            htOrder.setStatus(HtOrderEnum.OrderStatus.refund.getId());
            htOrder.setApplyTime(System.currentTimeMillis());

            if (whetherGoods != null && whetherGoods.equals(HtOrderEnum.userDeliverState.not_received.getId())
                && order.getReciptType().intValue() == HtOrderEnum.reciptTypeState.received_goods.getId())
            {
                htOrder.setUserDeliver(HtOrderEnum.userDeliverState.not_received.getId());
            }

            modVoNotNull(htOrder);

            saveOrderLog(HtOrderEnum.OrderStatus.refund.getId(), orderId, reason);

//            for (int i = 0; i < records.size(); i++)
//            {
//                ReconciliationRecord r = records.get(i);
//                r.setOrderStatus(YesOrNoEnum.NO.getValue());// 申请退款中
//                reconciliationRecordService.modVoNotNull(r);
//            }

            HtOrderApply htOrderApply = new HtOrderApply();
            htOrderApply.setReason(reason);
            htOrderApply.setStateExplain(HtOrderEnum.applyState.user_apply_state.getId());
            htOrderApply.setHandleType(HtOrderEnum.applyLaunch.user_launch.getId());
            htOrderApply.setGoodsImg(goodsImg);
            htOrderApply.setOrderId(orderId);
            htOrderApply.setCreateTime(System.currentTimeMillis());
            htOrderApply.setDmId(this.idServiceImpl.generateId());

            htOrderApplyService.userApply(htOrderApply);

            Message message = new Message();
            message.setCreateTime(System.currentTimeMillis());
            message.setContent(MessageConstant.user_apply_constant);
            message.setType(1);
            message.setUserId(userId);
            message.setSourceId(htOrderApply.getDmId());
            message.setDmId(this.idServiceImpl.generateId());
            message.setOrderId(orderId);

            messageService.saveMessage(message);
//            log.info("给供应商发送极光消息：供应商ID|staffCode="+order.getStaffCode());
//            String sid = usersService.getUserLastOperationSid(order.getStaffCode());
//			if(sid== null){
//				sid = usersShopService.getUserLastOperationSid(order.getStaffCode());
//			}
//			
//			User user = this.usersService.getUser(order.getStaffCode());
//			if(user == null){
//				user = this.usersShopService.getUser(order.getStaffCode());
//			}
//	        CustomMsg cm = this.customMsgService.findByCode(RespCode.apply_for_refund);
//	        Map<String, String> extra = new HashMap<String, String>();
//            extra.put("code", RespCode.apply_for_refund);
//            MsgOutput ex = new MsgOutput();
//            ex.setId(orderId + "");
//            extra.put("data", JSONObject.toJSONString(ex));
//            extra.put("message", cm.getMessage());
//	        //发送极光消息
//	        JpushDto jpushDto = new JpushDto(user.getUserType(),user.getPlatForm(),cm.getMessage(),sid,extra,Boolean.valueOf(CfgHelper.getValue("jpush.environment")));
//			jpushService.sendMessage(jpushDto);

        }
        finally
        {
            lock.unlock();
        }
        return result;
    }

    private boolean checkNotShippedOrder(Result<HtOrder> result, HtOrder order, Long userId) throws ServiceException
    {

        if (order == null)
        {

            result.setCode(ExceptionCode.ORDER_INEXISTENCE);
            result.setFailMessage("订单不存在");

            log.debug("订单不存在");

            return false;
        }

        // 如果不是待经发货不能退款
        if (HtOrderEnum.OrderStatus.waitSend.getId() != order.getStatus().intValue())
        {

            result.setCode(ExceptionCode.NO_REFUND);
            result.setFailMessage("订单已完成，请联系客服处理退货");

            log.debug("订单不是待发货状态，请联系客服处理退货");

            return false;
        }

        if (order.getVipCode().longValue() != userId.longValue())
        {

            result.setCode(ExceptionCode.ORDER_USER_FALSENESS);
            result.setFailMessage("订单不存在");

            log.debug("下单用户不正确");

            return false;
        }
        if (order.getStatus().intValue() == HtOrderEnum.OrderStatus.unpay.getId()
            || order.getStatus().intValue() == HtOrderEnum.OrderStatus.cancel.getId()
            || order.getStatus().intValue() == HtOrderEnum.OrderStatus.success.getId())
        {

            result.setCode(ExceptionCode.NO_REFUND);
            result.setFailMessage("不允许退款");

            log.debug("不允许退款");
            return false;
        }

        return true;

    }

    /**
     * 
     * 
     * @param state
     * @param orderId
     * @param message
     * @throws Exception
     */
    private void saveOrderLog(int state, Long orderId, String message) throws ServiceException
    {

        OrderLog saveOrderLog = new OrderLog();
        saveOrderLog.setStatus(state);
        saveOrderLog.setTime(System.currentTimeMillis());
        saveOrderLog.setOrderId(orderId);

        saveOrderLog.setNotes(message);
        if(saveOrderLog.getDmId()==null||saveOrderLog.getDmId()<1){
            saveOrderLog.setDmId(this.idServiceImpl.generateId());
            orderLogService.addVo(saveOrderLog);
           }else{
               orderLogService.modVo(saveOrderLog);
           }

    }

    /**
     * 对同意退货进行订单检查
     * 
     * @param result
     * @param order
     * @param sellerId
     * @return
     */
    private boolean checkAgreedRefund(Result<HtOrder> result, HtOrder order, Long sellerId)
    {
        if (order == null)
        {

            result.setCode(ExceptionCode.ORDER_INEXISTENCE);
            result.setFailMessage("订单不存在");

            log.debug("订单不存在");

            return false;
        }
        if (order.getStaffCode().longValue() != sellerId.longValue())
        {

            result.setCode(ExceptionCode.ORDER_SELLER_ERROR);
            result.setFailMessage("订单不属于商家");

            log.debug("订单不属于商家");

            return false;
        }
        if (order.getStatus().intValue() != HtOrderEnum.OrderStatus.refund.getId())
        {

            result.setCode(ExceptionCode.ORDER_STATUS_ERROR);
            result.setFailMessage("订单状态错误");

            log.debug("订单状态不是申请退款");

            return false;
        }

        return true;
    }

    public List<Map<String, Object>> findSonGoodsOrderMap(Map<String, Object> param) throws ServiceException
    {
        try
        {

            return dao.findSonGoodsOrderMap(param);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new ServiceException(e);
        }

    }

    @Override
    public List<HtOrder> processPayCallback(HtOrder order) throws ServiceException
    {
        log.debug("用户支付成功后，回调悠订单状态 " + order.toString());
        HtOrder htOrder = new HtOrder();

        if (String.valueOf(order.getBatchId())
            .substring(HtOrderEnum.interceptState.start.getId(), HtOrderEnum.interceptState.end.getId())
            .equals(OrderPrefix.PP_HT_ORDER + HtOrderEnum.htOrderPrefix.sonPrefix.getId()))
        {
            htOrder.setDmId(order.getBatchId());
        }
        else if (String.valueOf(order.getBatchId())
            .substring(HtOrderEnum.interceptState.start.getId(), HtOrderEnum.interceptState.end.getId())
            .equals(OrderPrefix.PP_HT_ORDER + HtOrderEnum.htOrderPrefix.batchPrefix.getId()))
        {
            htOrder.setBatchId(order.getBatchId());
        }

        List<HtOrder> htOrderList = findList(htOrder);

        for (HtOrder ho : htOrderList)
        {

            HtOrder orderFor = new HtOrder();

            ho.setPaymentWay(order.getPaymentWay());

            orderFor.setPayTime(System.currentTimeMillis());
            orderFor.setThreeSerialNumber(order.getThreeSerialNumber());
            orderFor.setDmId(ho.getDmId());
            orderFor.setStatus(HtOrderEnum.OrderStatus.waitSend.getId());
            orderFor.setPaymentWay(order.getPaymentWay());
            modVoNotNull(orderFor);

            OrderLog saveOrderLog = new OrderLog();
            saveOrderLog.setStatus(HtOrderEnum.OrderStatus.waitSend.getId());
            saveOrderLog.setTime(System.currentTimeMillis());
            saveOrderLog.setNotes("支付成功");
            saveOrderLog.setOrderId(ho.getDmId());
            if(saveOrderLog.getDmId()==null||saveOrderLog.getDmId()<1){
            	saveOrderLog.setDmId(this.idServiceImpl.generateId());
            	orderLogService.addVo(saveOrderLog);
            }else{
            	orderLogService.modVo(saveOrderLog);
            }
        }

        taskExecutor.execute(new taskExecutorModStock(htOrderList));

        return htOrderList;
    }

    /**
     * 
     * 修改库存方法
     * 
     * @param htOrders
     * @throws ServiceException
     */
    private void handleOrderModel(List<HtOrder> htOrders) throws ServiceException
    {

        List<OrderModel> orderModels = new ArrayList<>();

        for (HtOrder htOrder : htOrders)
        {

            DisProfits dis = new DisProfits();
            double sellMoney = ArithUtil.div(ArithUtil.mul(htOrder.getCountMoney(), dis.getSellerDis()), 10, 2);

            OrderModel orderModel = new OrderModel();

            orderModel.setPaymentMethod(Integer.parseInt(htOrder.getPaymentWay()));
            orderModel.setSellerId(htOrder.getStaffCode());
            orderModel.setPaymentPrice(sellMoney);
            orderModel.setDmId(htOrder.getDmId());

            HtOrderGoods htOrderGoods = new HtOrderGoods();
            htOrderGoods.setOrderId(htOrder.getDmId());

            List<HtOrderGoods> htOrderGoodsList = orderGoodsService.findList(htOrderGoods);

            List<HtStaffGoods> htStaffGoodsList = new ArrayList<>();

            for (HtOrderGoods og : htOrderGoodsList)
            {
                HtStaffGoods htStaffGoods = new HtStaffGoods();
                htStaffGoods.setBuyNumber(og.getGoodsNum());
                htStaffGoods.setDmId(og.getGoodsId());
                htStaffGoodsList.add(htStaffGoods);
            }

            orderModel.setList(htStaffGoodsList);
            orderModels.add(orderModel);
        }

        htOrderServices.modStock(orderModels);
    }

    @Override
    public Result<HtOrder> calculatePaymentPrice(Long orderId) throws ServiceException
    {

        if (orderId == null)
        {
            throw new ServiceException(ExceptionConstants.ERRORCODE_7, "入参错误！");
        }

        HtOrderCalculateView htOrderCalculateView = new HtOrderCalculateView();

        Result<HtOrder> result = new Result<>();

        List<HtOrder> htOrderList = new ArrayList<>();

        try
        {

            if (String.valueOf(orderId)
                .substring(HtOrderEnum.interceptState.start.getId(), HtOrderEnum.interceptState.end.getId())
                .equals(OrderPrefix.PP_HT_ORDER + HtOrderEnum.htOrderPrefix.batchPrefix.getId()))
            {
                HtOrder htOrder = new HtOrder();
                htOrder.setBatchId(orderId);

                List<HtOrder> orderList = getDao().findList(htOrder);

                if (orderList.isEmpty())
                {
                    result.setFailMessage("计算订单失败");
                    return result;
                }

                htOrderList.addAll(orderList);

            }
            else if (String.valueOf(orderId)
                .substring(HtOrderEnum.interceptState.start.getId(), HtOrderEnum.interceptState.end.getId())
                .equals(OrderPrefix.PP_HT_ORDER + HtOrderEnum.htOrderPrefix.sonPrefix.getId()))
            {
                HtOrder htOrder = getDao().findVo(orderId, null);

                if (htOrder == null)
                {
                    result.setFailMessage("计算订单失败");
                    return result;
                }

                htOrderList.add(htOrder);
                // 清空订单补贴优惠信息
                if (null != htOrder.getConstantKey() || null != htOrder.getDeductionPrice())
                {
                    updateOrderById(orderId, null, null, 0d, null, htOrder.getCountMoney());
                }
            }

            Long userId = htOrderList.get(0).getVipCode();

            RemissionRule remissionRule = new RemissionRule();
            remissionRule.setTwoLevelCode(Long.valueOf(CfgHelper.getValue("ht_category_id")));
            remissionRule.setFlag(1);

            List<RemissionRule> remissionRules = remissionRuleService.loadRemissionRuleByWhere(remissionRule);

            User user = usersService.getUser(userId);

            UserWallet userWall = userWalletService.findUserWallet(userId, user.getUserType());

            for (HtOrder order : htOrderList)
            {

                htOrderCalculateView
                    .setOrderPrice(ArithUtil.add(htOrderCalculateView.getOrderPrice(), order.getCountMoney()));

                htOrderCalculateView.setGoodsNum(htOrderCalculateView.getGoodsNum() + order.getGoodsNum());
            }

            calculationRule(remissionRules, htOrderCalculateView.getOrderPrice(), userWall);

            result.getCarrierMap().put("goodsNum", htOrderCalculateView.getGoodsNum());
            result.getCarrierMap().put("orderPrice", htOrderCalculateView.getOrderPrice());
            result.getCarrierMap().put("rule", remissionRules);
            result.getCarrierMap().put("payMoney", htOrderCalculateView.getOrderPrice());// 设置订单支付金额

        }
        catch (DaoException e)
        {
            log.error("HtOrderTransactionAlImpl.calculatePaymentPrice excetpion",e);
            throw new ServiceException(e);
        }

        return result;
    }

    /**
     * 根据订单金额计算订单补贴金额
     * 
     * @param remissionRules
     * @param consumeMoney
     * @param userWall
     */
    private void calculationRule(List<RemissionRule> remissionRules, Double money, UserWallet userWall)
    {

        if (null != remissionRules && !remissionRules.isEmpty())
        {

            Double consumeMoney = 0.00;

            for (RemissionRule rule : remissionRules)
            {

                consumeMoney = ArithUtil.div(ArithUtil.mul(money, rule.getDiscountPercent()), 100, 2);

                if (rule.getConstantKey().equals("CONSUME_SUBSIDY"))
                {
                    if (userWall.getConsumeTotalAmount() == null)
                    {
                        rule.setDeductionPrice(0.00);
                    }
                    else
                    {
                        if (consumeMoney.doubleValue() > userWall.getConsumeTotalAmount().doubleValue())
                        {
                            rule.setDeductionPrice(0.00);
                        }
                        else
                        {
                            rule.setDeductionPrice(consumeMoney);
                        }
                    }

                }
                else if (rule.getConstantKey().equals("HT_SUBSIDY"))
                {

                    if (userWall.getHtsubsidyTotalAmount() == null)
                    {
                        rule.setDeductionPrice(0.00);
                    }
                    else
                    {
                        if (consumeMoney.doubleValue() > userWall.getHtsubsidyTotalAmount().doubleValue())
                        {
                            rule.setDeductionPrice(userWall.getHtsubsidyTotalAmount());
                        }
                        else
                        {
                            rule.setDeductionPrice(consumeMoney);
                        }
                    }
                }
            }
        }
    }

    @Override
    public Result<HtOrder> getHtOrderList(Long userId, Integer status, Integer pageIndex) throws ServiceException
    {

        Result<HtOrder> result = new Result<>();

        User user = usersService.getUser(userId);

        if (user == null)
        {

            user = usersShopService.getUser(userId);
        }

        Pager<HtOrder, Long> pager;

        try
        {

            pager = queryOrderPage(user, status, pageIndex);

            handleOrderGoods(pager);

            result.setPager(pager);
        }
        catch (DaoException e)
        {
            log.error(e);
            throw new ServiceException(e);
        }

        return result;
    }

    /**
     * 查询订单分页信息
     * 
     * @param user
     * @param status
     * @param pageIndex
     * @param orderType
     * @return
     * @throws DaoException
     */
    private Pager<HtOrder, Long> queryOrderPage(User user, Integer status, Integer pageIndex) throws DaoException
    {

        HtOrderPage htOrderPage = new HtOrderPage();
        htOrderPage.setStatus(status);
        htOrderPage.setNowPage(pageIndex);
        htOrderPage.setVipCode(user.getDmId());
        htOrderPage.setOrderField("crtime");
        htOrderPage.setOrderDirection(false);

        return getDao().query(htOrderPage, HtOrder.class);
    }

    /**
     * 处理订单商品
     * 
     * 
     * @param user
     * @throws ServiceException
     */
    private void handleOrderGoods(Pager<HtOrder, Long> pager) throws ServiceException
    {

        JSONArray orderaArray = new JSONArray();

        if (pager != null)
        {

            for (HtOrder htOrder : pager.getList())
            {

                HtOrderGoods htOrderGoods = new HtOrderGoods();
                htOrderGoods.setOrderId(htOrder.getDmId());

                List<HtOrderGoods> list = orderGoodsService.findList(htOrderGoods);

                HtOrderView htOrderView = assignmentOrderView(htOrder, list);

                JSONObject orderJSON = JSONObject.parseObject(JSON.toJSONString(htOrderView));

                orderaArray.add(orderJSON);
                
                orderValidity(htOrder);

            }

            pager.setList2(orderaArray);
        }
    }

    @Override
    public Result<HtOrder> getHtOrderInfo(Long htOrderId) throws ServiceException
    {

        Result<HtOrder> result = new Result<>();

        try
        {

            HtOrder htOrder = getDao().findVo(htOrderId, new HtOrder());

            HtOrderGoods htOrderGoods = new HtOrderGoods();
            htOrderGoods.setOrderId(htOrder.getDmId());

            List<HtOrderGoods> list = orderGoodsService.findList(htOrderGoods);

            result.setCarrierObject(assignmentOrderView(htOrder, list));

        }
        catch (DaoException e)
        {
            log.error(e);
            throw new ServiceException(e);
        }

        return result;
    }

    /**
     * 给订单展示数据赋值
     * 
     * @param htOrder
     * @param htOrderGoods
     * @return
     */
    private HtOrderView assignmentOrderView(HtOrder htOrder, List<HtOrderGoods> htOrderGoods)
    {

        HtOrderView htOrderView = new HtOrderView();
        htOrderView.setBatchId(htOrder.getBatchId());
        htOrderView.setDmId(htOrder.getDmId());
        htOrderView.setPayMoney(htOrder.getPayMoney());
        htOrderView.setStatus(htOrder.getStatus());
        htOrderView.setConsignee(htOrder.getConsignee());
        htOrderView.setCrtime(htOrder.getCrtime());
        htOrderView.setMphoneNo(htOrder.getMphoneNo());
        htOrderView.setNoteMan(htOrder.getNoteMan());
        htOrderView.setPaymentWay(htOrder.getPaymentWay());
        htOrderView.setDetailAddr(htOrder.getDetailAddr());
        htOrderView.setExpress(htOrder.getExpress());
        htOrderView.setExpressCode(htOrder.getExpressCode());
        htOrderView.setCountMoney(htOrder.getCountMoney());

        if (htOrder.getDeductionPrice() == null)
        {
            htOrderView.setDeductionPrice(0.00);
        }
        else
        {
            htOrderView.setDeductionPrice(htOrder.getDeductionPrice());
        }

        if (htOrder.getConstantKey() != null)
        {
            if ("CONSUME_SUBSIDY".equals(htOrder.getConstantKey()))
            {
                htOrderView.setConstantName("可消费补贴");
            }
            else if ("HT_SUBSIDY".equals(htOrder.getConstantKey()))
            {
                htOrderView.setConstantName("海淘补贴");
            }
        }

        for (HtOrderGoods orderGoods : htOrderGoods)
        {

            HtOrderGoodsView htOrderGoodsView = new HtOrderGoodsView();
            htOrderGoodsView.setMainPicture(orderGoods.getGoodImg());
            htOrderGoodsView.setGoodName(orderGoods.getGoodsName());
            htOrderGoodsView.setGoodPrice(orderGoods.getSaleMoney());
            htOrderGoodsView.setGoodNumber(orderGoods.getGoodsNum());
            htOrderGoodsView.setGoodSpec("");
            htOrderView.getHtOrderGoodsList().add(htOrderGoodsView);
            htOrderView.setGoodsNum(htOrderView.getGoodsNum() + orderGoods.getGoodsNum());
        }
        return htOrderView;
    }

    @Override
    public Result<HtOrder> customerDelivery(Long orderId, String express, String expressCode, Long deliverTime)
        throws ServiceException
    {

        Result<HtOrder> result = new Result<>();

        HtOrder htOrder = new HtOrder();
        htOrder.setDmId(orderId);
        htOrder.setReciptType(HtOrderEnum.reciptTypeState.return_receipt.getId());
        htOrder.setUserDeliver(HtOrderEnum.userDeliverState.deliver.getId());

        modVoNotNull(htOrder);

        HtOrderApply htOrderApply = new HtOrderApply();
        htOrderApply.setExpress(express);
        htOrderApply.setExpressCode(expressCode);
        htOrderApply.setDeliverTime(deliverTime);
        htOrderApply.setHandleType(HtOrderEnum.applyLaunch.user_launch.getId());
        htOrderApply.setStateExplain(HtOrderEnum.applyState.user_deliver_state.getId());
        htOrderApply.setOrderId(orderId);
        htOrderApply.setCreateTime(System.currentTimeMillis());

        htOrderApplyService.userReplyApply(htOrderApply);

        Message message = new Message();
        message.setOrderId(orderId);

        messageService.modVo(message);

        return result;
    }

    @Override
    public Result<HtOrder> shopConfirmOrder(Long sellerId, Long orderId) throws ServiceException
    {

        Result<HtOrder> result = new Result<>();

        try
        {
            HtOrder order = lockOrder(orderId.longValue());

            if (order == null)
            {

                result.setCode(ExceptionCode.ORDER_INEXISTENCE);
                result.setFailMessage("订单不存在");

                log.debug("订单不存在");

                return result;
            }
            if (order.getStaffCode().longValue() != sellerId.longValue())
            {

                result.setCode(ExceptionCode.ORDER_SELLER_ERROR);
                result.setFailMessage("订单不属于商家");

                log.debug("订单不属于商家");

                return result;
            }

            Map<String, String> extra = new HashMap<String, String>();
            MsgOutput ex = new MsgOutput();
            ex.setId(orderId + "");
            extra.put("data", JSONObject.toJSONString(ex));

            if (HtOrderEnum.OrderStatus.refund.getId() != order.getStatus().intValue())
            { // 检查订单是否还处理对账中，若存在可退款，若不存在不允许退款
                result.setCode(ExceptionCode.ORDER_STATUS_ERROR);
                result.setFailMessage("订单状态错误");
                log.debug("订单状态不是申请退款");
                return result;
            }

            notAlreadyRefund(orderId, order);
            
            String sid = usersService.getUserLastOperationSid(order.getStaffCode());
			if(sid== null){
				sid = usersShopService.getUserLastOperationSid(order.getStaffCode());
			}
			
			User user = this.usersService.getUser(order.getStaffCode());
			if(user == null){
				user = this.usersShopService.getUser(order.getStaffCode());
			}
	        CustomMsg cm = this.customMsgService.findByCode(RespCode.agree_to_refund);
	        extra.put("message", cm.getMessage());
	        //发送极光消息
	        JpushDto jpushDto = new JpushDto(user.getUserType(),user.getPlatForm(),cm.getMessage(),sid,extra,Boolean.valueOf(CfgHelper.getValue("jpush.environment")));
			jpushService.sendMessage(jpushDto);
        }
        finally
        {
            lock.unlock();
        }

        return result;
    }

    /**
     * 退款时修改商品库存
     * 
     * @param orderModels
     * @param htOrder
     * @throws ServiceException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    private void modifyStock(HtOrder htOrder) throws ServiceException
    {

        List<OrderModel> list = new ArrayList<>();
        List<HtStaffGoods> htStaffGoodsList = new ArrayList<>();

        OrderModel orderModel = new OrderModel();

        orderModel.setDmId(htOrder.getDmId());
        orderModel.setOrderPrice(htOrder.getPayMoney());
        orderModel.setPaymentMethod(Integer.valueOf(htOrder.getPaymentWay()));
        orderModel.setSellerId(htOrder.getStaffCode());
        orderModel.setSellerName(htOrder.getStaffName());

        HtOrderGoods htOrderGoods = new HtOrderGoods();
        htOrderGoods.setOrderId(htOrder.getDmId());

        List<HtOrderGoods> orderGoodsList = orderGoodsService.findList(htOrderGoods);

        for (HtOrderGoods og : orderGoodsList)
        {

            HtStaffGoods htStaffGoods = new HtStaffGoods();

            htStaffGoods.setDmId(og.getGoodsId());
            htStaffGoods.setGoodName(og.getGoodsName());
            htStaffGoods.setPrice(og.getSaleMoney());
            htStaffGoods.setBuyNumber(og.getGoodsNum());

            htStaffGoodsList.add(htStaffGoods);
        }

        orderModel.setList(htStaffGoodsList);

        list.add(orderModel);

        htOrderServices.addStock(list);
    }

    @Override
    public HtOrderPage query(HtOrderPage page) throws ServiceException
    {
        page = (HtOrderPage) super.query(page, null);
        if (null != page.getStaffCode() && null != page.getList())
        {
            HtOrderGoods g = null;
            for (HtOrder order : page.getList())
            {
                g = new HtOrderGoods();
                g.setOrderId(order.getDmId());
                //此代码看了无用的查询 所以注释掉  （查询了但没有用多余耗性能）
                //List<HtOrderGoods> htOrderGoods = orderGoodsService.findList(g);

                order.setHtOrderGoodsList(orderGoodsService.findList(g));
            }
        }

        return page;
    }

    @Override
    public Result<HtOrder> adminReturnGoods(Long orderId, String address, String tel, String consignee)
        throws ServiceException
    {

        Result<HtOrder> result = new Result<>();

        HtOrderApply htOrderApply = new HtOrderApply();

        htOrderApply.setShopAddress(address);
        htOrderApply.setShopTel(tel);
        htOrderApply.setShopConsignee(consignee);
        htOrderApply.setHandleType(HtOrderEnum.applyLaunch.customer_service.getId());
        htOrderApply.setStateExplain(HtOrderEnum.applyState.admin_arbitration.getId());
        htOrderApply.setDmId(this.idServiceImpl.generateId());
        htOrderApply.setOrderId(orderId);
        htOrderApply.setCreateTime(System.currentTimeMillis());
        if(htOrderApply.getDmId()==null||htOrderApply.getDmId()<1){
            htOrderApply.setDmId(this.idServiceImpl.generateId());
        }
        htOrderApplyService.addVo(htOrderApply);
        return result;
    }

    @Override
    public Result<HtOrder> adminArbitration(Long orderId, String content) throws ServiceException
    {

        Result<HtOrder> result = new Result<>();

        HtOrderApply htOrderApply = new HtOrderApply();

        htOrderApply.setReason(content);
        htOrderApply.setStateExplain(HtOrderEnum.applyState.admin_arbitration.getId());
        htOrderApply.setHandleType(HtOrderEnum.applyLaunch.customer_service.getId());
        htOrderApply.setCreateTime(System.currentTimeMillis());
        htOrderApply.setDmId(this.idServiceImpl.generateId());
        htOrderApply.setOrderId(orderId);
        
        htOrderApplyService.addVo(htOrderApply);

        return result;
    }

    @Override
    public Result<HtOrder> adminRefund(Long orderId) throws ServiceException
    {

        Result<HtOrder> result = new Result<>();

        try
        {

            HtOrder order = lockOrder(orderId.longValue());

            if (order.getStatus().intValue() != HtOrderEnum.OrderStatus.refund.getId())
            {

                result.setCode(ExceptionCode.ORDER_STATUS_ERROR);
                result.setFailMessage("订单状态错误");

                log.debug("订单状态不是申请退款");

                return result;
            }

//            if (HtOrderEnum.OrderStatus.refund.getId() != order.getStatus().intValue())
//            { // 检查订单是否还处理对账中，若存在可退款，若不存在不允许退款
//                log.debug("订单已完成，不能退款");
//
//                result.setCode(ExceptionCode.ORDERFINISHED_REJECTREIM);
//                result.setFailMessage("订单已完成，不能退款");
//
//                return result;
//            }

            HtOrder htOrder = new HtOrder();
            htOrder.setDmId(orderId);
            htOrder.setStatus(HtOrderEnum.OrderStatus.cancel.getId());

            modVoNotNull(htOrder);

            saveOrderLog(HtOrderEnum.OrderStatus.cancel.getId(), orderId, "同意退款"); // 同意退款

            this.userWalletService.saveAccBackMoney(orderId + "", order.getVipCode());

            modifyStock(htOrder);

        }
        finally
        {
            lock.unlock();
        }

        return result;
    }

    @Override
    public Result<HtOrder> shopDeliverGoods(Long orderId, String express, String expressCode) throws ServiceException
    {

        Result<HtOrder> result = new Result<>();

        List<OrderModel> orderModels = new ArrayList<>();

        try
        {
            HtOrder htOrder = getDao().findVo(orderId, new HtOrder());

            if (htOrder == null)
            {
                result.setCode(-1);
                result.setFailMessage("订单不存在");
                return result;
            }

            if (htOrder.getStatus().intValue() != HtOrderEnum.OrderStatus.waitSend.getId())
            {
                result.setCode(-1);
                result.setFailMessage("该订单已经发货");
                return result;
            }

            DisProfits dis = new DisProfits();
            double sellMoney = ArithUtil.div(ArithUtil.mul(htOrder.getCountMoney(), dis.getSellerDis()), 10, 2);

            OrderModel orderModel = new OrderModel();

            orderModel.setPaymentMethod(Integer.parseInt(htOrder.getPaymentWay()));
            orderModel.setSellerId(htOrder.getStaffCode());
            orderModel.setPaymentPrice(sellMoney);
            orderModel.setDmId(htOrder.getDmId());
            orderModels.add(orderModel);

            HtOrder order = new HtOrder();

            order.setDmId(orderId);
            order.setExpress(express);
            order.setExpressCode(expressCode);
            order.setDeliveryTime(System.currentTimeMillis());
            order.setStatus(HtOrderEnum.OrderStatus.waitTake.getId());
            order.setReciptType(HtOrderEnum.reciptTypeState.received_goods.getId());

            modVoNotNull(order);

            saveOrderLog(HtOrderEnum.OrderStatus.waitTake.getId(), orderId, "商家发货");

            htOrderServices.addReconciliation(orderModels);
            
         // 多线程 进行
            taskExecutor.execute(new taskExecutorOrder(htOrder));

        }
        catch (DaoException e)
        {
            log.error(e);
            throw new ServiceException();
        }

        return result;
    }

    @Override
    public Result<HtOrder> backstageOrderInfo(Long orderId) throws ServiceException
    {

        Result<HtOrder> result = new Result<>();

        try
        {
            HtOrder htOrder = getDao().findVo(orderId, new HtOrder());

            if (htOrder == null)
            {
                result.setFailMessage("该订单不存在");
                return result;
            }

            HtOrderGoods htOrderGoods = new HtOrderGoods();
            htOrderGoods.setOrderId(orderId);

            List<HtOrderGoods> orderGoods = orderGoodsService.findList(htOrderGoods);

            if (orderGoods != null)
            {
                htOrder.setHtOrderGoodsList(orderGoods);
            }

            HtOrderApply htOrderApply = new HtOrderApply();
            htOrderApply.setOrderId(orderId);

            List<HtOrderApply> orderApplies = htOrderApplyService.findList(htOrderApply);

            if (orderApplies != null)
            {
                htOrder.setHtOrderApplieList(orderApplies);
            }

            result.setCarrier(htOrder);

        }
        catch (DaoException e)
        {
            log.error(e);
            throw new ServiceException(e);
        }

        return result;
    }

    @Override
    public Result<HtOrder> shopNotRefund(Long sellerId, Long orderId, String message) throws ServiceException
    {

        Result<HtOrder> result = new Result<>();

        try
        {

            HtOrder order = lockOrder(orderId.longValue());

            if (!checkAgreedRefund(result, order, sellerId))
            {

                return result;
            }

            Map<String, String> extra = new HashMap<String, String>();
            MsgOutput ex = new MsgOutput();
            ex.setId(orderId + "");
            extra.put("data", JSONObject.toJSONString(ex));

            HtOrder updateOrder = new HtOrder();
            updateOrder.setDmId(orderId);

            if (order.getReciptType().intValue() == HtOrderEnum.reciptTypeState.not_received.getId())
            {

                updateOrder.setStatus(HtOrderEnum.OrderStatus.waitSend.getId());

            }
            else if (order.getReciptType().intValue() == HtOrderEnum.reciptTypeState.received_goods.getId())
            {

                updateOrder.setStatus(HtOrderEnum.OrderStatus.waitTake.getId());
            }

            updateOrder.setUserDeliver(HtOrderEnum.userDeliverState.not_deliver.getId());

            modVoNotNull(updateOrder);

            HtOrderApply htOrderApply = new HtOrderApply();
            htOrderApply.setReason(message);
            htOrderApply.setOrderId(orderId);
            htOrderApply.setHandleType(HtOrderEnum.applyLaunch.shop_launch.getId());
            htOrderApply.setStateExplain(HtOrderEnum.applyState.shop_refuse_state.getId());
            htOrderApply.setCreateTime(System.currentTimeMillis());

            htOrderApplyService.shopReplyApply(htOrderApply);

            Message messages = new Message();
            messages.setCreateTime(System.currentTimeMillis());
            messages.setContent(message);
            messages.setDmId(this.idServiceImpl.generateId());
            messages.setType(1);
            messages.setUserId(order.getVipCode());
            messages.setSourceId(htOrderApply.getDmId());
            messages.setOrderId(orderId);

            messageService.saveMessage(messages);

            saveOrderLog(HtOrderEnum.OrderStatus.not_refund.getId(), orderId, message);

            extra.put("code", RespCode.no_agree_to_refund); // 自定义消息
            
           
//            String sid = usersService.getUserLastOperationSid(order.getStaffCode());
//			if(sid== null){
//				sid = usersShopService.getUserLastOperationSid(order.getStaffCode());
//			}
//			
//			User user = this.usersService.getUser(order.getStaffCode());
//			if(user == null){
//				user = this.usersShopService.getUser(order.getStaffCode());
//			}
//	        CustomMsg cm = this.customMsgService.findByCode(RespCode.no_agree_to_refund);
//	        extra.put("message", cm.getMessage());
//	        //发送极光消息
//	        JpushDto jpushDto = new JpushDto(user.getUserType(),user.getPlatForm(),cm.getMessage(),sid,extra,Boolean.valueOf(CfgHelper.getValue("jpush.environment")));
//			jpushService.sendMessage(jpushDto);
            
        }
        finally
        {
            lock.unlock();
        }

        return result;
    }

    @Override
    public Result<HtOrder> notShippedAgreedRefund(Long sellerId, Long orderId) throws ServiceException
    {
        Result<HtOrder> result = new Result<>();

        try
        {

            HtOrder order = lockOrder(orderId.longValue());

            if (!checkAgreedRefund(result, order, sellerId))
            {

                return result;
            }

            Map<String, String> extra = new HashMap<String, String>();
            MsgOutput ex = new MsgOutput();
            ex.setId(orderId + "");
            extra.put("data", JSONObject.toJSONString(ex));

//            if (HtOrderEnum.OrderStatus.waitSend.getId() != order.getStatus().intValue())
//            { // 检查订单是否还处理对账中，若存在可退款，若不存在不允许退款
//                log.debug("订单已完成，不能退款");
//
//                result.setCode(ExceptionCode.ORDERFINISHED_REJECTREIM);
//                result.setFailMessage("订单已完成，不能退款");
//
//                return result;
//            }

            HtOrder htOrder = new HtOrder();

            htOrder.setAgreeTime(System.currentTimeMillis());
            htOrder.setStatus(HtOrderEnum.OrderStatus.cancel.getId());
            htOrder.setDmId(orderId);

            modVoNotNull(htOrder);

            saveOrderLog(HtOrderEnum.OrderStatus.agree_refund.getId(), orderId, "同意退款"); // 同意退款

            saveOrderLog(HtOrderEnum.OrderStatus.cancel.getId(), orderId, "同意退款"); // 同意退款

            simpleUserWalletService.createAccBackMoney(String.valueOf(orderId), order.getVipCode(), Integer.parseInt(order.getPaymentWay()), order.getPayMoney(), order.getDeductionPrice(), order.getConstantKey());

            /* this.userWalletService.saveAccBackMoney(orderId + "", order.getVipCode()); */

            modifyStock(order);

            extra.put("code", RespCode.agree_to_refund); // 自定义消息
            
            String sid = usersService.getUserLastOperationSid(order.getStaffCode());
			if(sid== null){
				sid = usersShopService.getUserLastOperationSid(order.getStaffCode());
			}
			
			User user = this.usersService.getUser(order.getStaffCode());
			if(user == null){
				user = this.usersShopService.getUser(order.getStaffCode());
			}
	        CustomMsg cm = this.customMsgService.findByCode(RespCode.agree_to_refund);
	        extra.put("message", cm.getMessage());
	        //发送极光消息
	        JpushDto jpushDto = new JpushDto(user.getUserType(),user.getPlatForm(),cm.getMessage(),sid,extra,Boolean.valueOf(CfgHelper.getValue("jpush.environment")));
			jpushService.sendMessage(jpushDto);
        }
        finally
        {
            lock.unlock();
        }

        return result;
    }

    @Override
    public Result<HtOrder> alreadyShippedAgreedRefund(Long sellerId, Long orderId, String address, String tel,
        String consignee) throws ServiceException
    {

        Result<HtOrder> result = new Result<>();

        try
        {
            HtOrder order = lockOrder(orderId.longValue());

            if (!checkAgreedRefund(result, order, sellerId))
            {

                return result;
            }
            

//            if (HtOrderEnum.OrderStatus.waitSend.getId() != order.getStatus().intValue())
//            { // 检查订单是否还处理对账中，若存在可退款，若不存在不允许退款
//                log.debug("订单已发货，不能退款");
//
//                result.setCode(ExceptionCode.ORDERFINISHED_REJECTREIM);
//                result.setFailMessage("订单已发货，不能退款");
//
//                return result;
//            }
            log.info("是否发货：received="+order.getReciptType().intValue()+",用户是否收货:deliver="+order.getUserDeliver().intValue());
            // 这里有多种情况 1 商家发货会员收到货退款，2商家发货会员未收到货退款，3商家未发货直接退款
            if (order.getReciptType().intValue() == HtOrderEnum.reciptTypeState.received_goods.getId())
            {

                if (order.getUserDeliver().intValue() == HtOrderEnum.userDeliverState.not_received.getId())
                {
                    // 2商家发货会员未收到货退款
                    notAlreadyRefund(orderId, order);

                }
                else
                {
                    if (address == null)
                    {
                        result.setCode(-1);
                        result.setFailMessage("你已经发货地址信息不能为空");
                        return result;
                    }

                    if (tel == null)
                    {
                        result.setCode(-1);
                        result.setFailMessage("你已经发货电话信息不能为空");
                        return result;
                    }
                    // 1 商家发货会员收到货退款
                    alreadyRefund(sellerId, orderId, address, tel, consignee, order);
                }

            }
            else if (order.getReciptType().intValue() == HtOrderEnum.reciptTypeState.not_received.getId())
            {
                // 3商家未发货直接退款
                notAlreadyRefund(orderId, order);
            }

//            extra.put("code", RespCode.agree_to_refund); // 自定义消息
//            String sid = usersService.getUserLastOperationSid(order.getStaffCode());
//			if(sid== null){
//				sid = usersShopService.getUserLastOperationSid(order.getStaffCode());
//			}
//			
//			User user = this.usersService.getUser(order.getStaffCode());
//			if(user == null){
//				user = this.usersShopService.getUser(order.getStaffCode());
//			}
//	        CustomMsg cm = this.customMsgService.findByCode(RespCode.agree_to_refund);
//	        extra.put("message", cm.getMessage());
//	        //发送极光消息
//	        JpushDto jpushDto = new JpushDto(user.getUserType(),user.getPlatForm(),cm.getMessage(),sid,extra,Boolean.valueOf(CfgHelper.getValue("jpush.environment")));
//			jpushService.sendMessage(jpushDto);
        }
        finally
        {

            lock.unlock();
        }
        return result;
    }

    /**
     * 
     * 已发货同意退款
     * 
     * @param sellerId
     * @param orderId
     * @param address
     * @param tel
     * @param consignee
     * @param order
     * @throws ServiceException
     */
    private void alreadyRefund(Long sellerId, Long orderId, String address, String tel, String consignee, HtOrder order)
        throws ServiceException
    {

        HtOrder htOrder = new HtOrder();
        htOrder.setAgreeTime(System.currentTimeMillis());
        htOrder.setStatus(HtOrderEnum.OrderStatus.agree_refund.getId());
        htOrder.setDmId(orderId);

        modVoNotNull(htOrder);

        HtOrderApply htOrderApply = new HtOrderApply();
        htOrderApply.setShopAddress(address);
        htOrderApply.setShopConsignee(consignee);
        htOrderApply.setOrderId(orderId);
        htOrderApply.setShopTel(tel);
        htOrderApply.setHandleType(HtOrderEnum.applyLaunch.shop_launch.getId());
        htOrderApply.setStateExplain(HtOrderEnum.applyState.shop_agree_state.getId());
        htOrderApply.setCreateTime(System.currentTimeMillis());

        htOrderApplyService.shopReplyApply(htOrderApply);

        Message messages = new Message();
        messages.setCreateTime(System.currentTimeMillis());
        messages.setContent(MessageConstant.agree_apply_constant);
        messages.setType(1);
        messages.setState(HtOrderEnum.OrderStatus.agree_refund.getId());
        messages.setUserId(order.getVipCode());
        messages.setSourceId(htOrderApply.getDmId());
        messages.setDmId(this.idServiceImpl.generateId());
        messages.setOrderId(orderId);

        messageService.saveMessage(messages);

        saveOrderLog(HtOrderEnum.OrderStatus.agree_refund.getId(), orderId, "商家同意退款");
    }

    /**
     * 未发货同意退款
     * 
     * @param orderId
     * @param order
     * @throws ServiceException
     */
    private void notAlreadyRefund(Long orderId, HtOrder order) throws ServiceException
    {

        HtOrder htOrder = new HtOrder();

        htOrder.setAgreeTime(System.currentTimeMillis());
        htOrder.setStatus(HtOrderEnum.OrderStatus.cancel.getId());
        htOrder.setDmId(orderId);

        modVoNotNull(htOrder);

        saveOrderLog(HtOrderEnum.OrderStatus.agree_refund.getId(), orderId, "同意退款"); // 同意退款

        simpleUserWalletService.createAccBackMoney(String.valueOf(orderId), order.getVipCode(), Integer.parseInt(order.getPaymentWay()), order.getPayMoney(), order.getDeductionPrice(), order.getConstantKey());

        modifyStock(order);

        saveOrderLog(HtOrderEnum.OrderStatus.cancel.getId(), orderId, "商家已退款，订单取消");

        Message message = new Message();
        message.setOrderId(orderId);
        messageService.modVo(message);
    }

    @Override
    public PayHtOrderModel queryOrderByIdOrBatchId(Long orderId) throws ServiceException
    {
        PayHtOrderModel payHtOrderModel = new PayHtOrderModel();

        String prefix = String.valueOf(orderId).substring(0, 3);

        try
        {

            if (prefix.equals(OrderPrefix.PP_HT_ORDER + htOrderPrefix.sonPrefix.getId()))
            {

                HtOrder htOrder = getDao().findVo(orderId, null);

                payHtOrderModel.setStatus(htOrder.getStatus());
                payHtOrderModel.setCrtime(htOrder.getCrtime());
                payHtOrderModel.setGoodsNum(htOrder.getGoodsNum());
                payHtOrderModel.setPayMoney(htOrder.getPayMoney());
                payHtOrderModel.setStaffCode(htOrder.getStaffCode());
                payHtOrderModel.setStaffName(htOrder.getStaffName());
                payHtOrderModel.setVipCode(htOrder.getVipCode());

            }
            else if (prefix.equals(OrderPrefix.PP_HT_ORDER + htOrderPrefix.batchPrefix.getId()))
            {

                HtOrder order = new HtOrder();
                order.setBatchId(orderId);

                List<HtOrder> list = getDao().findList(order);

                if (list.size() != 0)
                {

                    payHtOrderModel.setCrtime(list.get(0).getCrtime());
                    payHtOrderModel.setStaffCode(list.get(0).getStaffCode());
                    payHtOrderModel.setStaffName(list.get(0).getStaffName());
                    payHtOrderModel.setVipCode(list.get(0).getVipCode());
                    payHtOrderModel.setStatus(list.get(0).getStatus());
                    payHtOrderModel.setPayMoney(new Double(0.0));

                    for (HtOrder ht : list)
                    {
                        if (ht.getStatus().intValue() == HtOrderEnum.OrderStatus.unpay.getId())
                        {
                            payHtOrderModel.setGoodsNum(payHtOrderModel.getGoodsNum() + ht.getGoodsNum());
                            payHtOrderModel.setPayMoney(ArithUtil.add(ht.getPayMoney(), payHtOrderModel.getPayMoney()));

                        }

                    }
                }
            }

        }
        catch (DaoException e)
        {
            log.error(e);
            throw new ServiceException(e);
        }

        return payHtOrderModel;
    }

    @Override
    public Result<HtOrder> getOrderApplyById(Long orderApplyId) throws ServiceException
    {
        Result<HtOrder> result = new Result<>();

        HtOrderApply htOrderApply = htOrderApplyService.findVo(orderApplyId, new HtOrderApply());

        result.setCarrierObject(htOrderApply);

        return result;
    }

    @Override
    public Result<HtOrder> userConfirmReceipt(Long orderId) throws ServiceException
    {

        Result<HtOrder> result = new Result<>();

        try
        {
            HtOrder order = lockOrder(orderId.longValue());

            order.setStatus(HtOrderEnum.OrderStatus.success.getId());

            order.setCompleteTime(System.currentTimeMillis());

            modVoNotNull(order);

            saveOrderLog(HtOrderEnum.OrderStatus.success.getId(), orderId, "您已确认收货,订单已经完成");

        }
        finally
        {
            lock.unlock();
        }

        return result;
    }

    @Override
    public Result<HtOrder> getOrderstatusList(Long orderId) throws ServiceException
    {
        Result<HtOrder> result = new Result<>();

        List<OrderLog> list = orderLogService.findByOrderId(orderId);

        List<HtOrderStatusView> listViews = new ArrayList<>();

        for (OrderLog orderLog : list)
        {

            if (orderLog.getStatus().equals(HtOrderEnum.OrderStatus.waitSend.getId()))
            {

                listViews.add(handleHtOrderStatusView(orderLog, HtOrderStatusConstant.already_payment));

            }
            else if (orderLog.getStatus().equals(HtOrderEnum.OrderStatus.waitTake.getId()))
            {

                listViews.add(handleHtOrderStatusView(orderLog, HtOrderStatusConstant.already_shipped));

            }
            else if (orderLog.getStatus().equals(HtOrderEnum.OrderStatus.success.getId()))
            {

                listViews.add(handleHtOrderStatusView(orderLog, HtOrderStatusConstant.order_complete));

            }
            else if (orderLog.getStatus().equals(HtOrderEnum.OrderStatus.refund.getId()))
            {

                listViews.add(handleHtOrderStatusView(orderLog, HtOrderStatusConstant.order_refund));

            }
            else if (orderLog.getStatus().equals(HtOrderEnum.OrderStatus.agree_refund.getId()))
            {

                listViews.add(handleHtOrderStatusView(orderLog, HtOrderStatusConstant.agree_refund));

            }
            else if (orderLog.getStatus().equals(HtOrderEnum.OrderStatus.not_refund.getId()))
            {

                listViews.add(handleHtOrderStatusView(orderLog, HtOrderStatusConstant.not_refund));
            }
        }

        result.setCarrierObject(listViews);

        return result;
    }

    private HtOrderStatusView handleHtOrderStatusView(OrderLog orderLog, String title)
    {

        HtOrderStatusView view = new HtOrderStatusView();

        view.setOrderId(orderLog.getOrderId());
        view.setStatus(orderLog.getStatus());
        view.setTime(orderLog.getTime());
        view.setNote(orderLog.getNotes());
        view.setTitle(title);

        return view;
    }

    @Override
    public Result<HtOrder> saveSubOrder(Map<Long, Integer> goodsMaps, Long receivingId, User user, String note,
        Integer cliType) throws ServiceException
    {

        log.info("HtOrderTransactionalImpl saveSubOrder|params:goodsMaps="+goodsMaps);

        Result<HtOrder> result = new Result<>();

        UserReceivingInfo userReceivingInfo = new UserReceivingInfo();

        this.orderVerification(user, goodsMaps, userReceivingInfo, receivingId, note, result);

        if (!result.isSuccess())
            return result;

        List<OrderModel> model = this.htOrderServices.calculateOrder(goodsMaps);
        
        

        Long batchId = Long.parseLong(OrderPrefix.PP_HT_ORDER + htOrderPrefix.batchPrefix.getId() + this.idServiceImpl.generateId());
        log.info("HtOrderTransactionalImpl saveSubOrder|batchId="+batchId + "model.size="+model.size());
        if (model != null && model.size() > 0)
        {
            double orderTotal = 0.0;

            int goodsNumTotal = 0;

            List<HtOrder> orders = new ArrayList<HtOrder>();
            
            for (OrderModel m : model)
            {

                List<HtStaffGoods> goods = m.getList();
                HtOrder order = new HtOrder();
                List<HtOrderGoods> goodsLs = new ArrayList<HtOrderGoods>();
                Long orderId = Long
                    .parseLong(OrderPrefix.PP_HT_ORDER + htOrderPrefix.sonPrefix.getId() + this.idServiceImpl.generateId());

                if (goods != null)
                {
                    this.subOrderCalculation(goodsLs, goods, orderTotal, goodsNumTotal, orderId);
                }

                DisProfits dis = new DisProfits();
                double sellMoney = ArithUtil.div(ArithUtil.mul(m.getPaymentPrice(), dis.getSellerDis()), 10, 2);

                order.set(orderId, batchId, m.getSellerId(), m.getSellerName(), user.getDmId(), user.getNickname(),
                    sellMoney, null, null, m.getOrderPrice(), m.getPaymentPrice(), null, null, null, 1,
                    System.currentTimeMillis(), null, null, null, userReceivingInfo.getName(), null, null, null, null,
                    userReceivingInfo.getAddress(), userReceivingInfo.getHouseNumber(), userReceivingInfo.getPhone(),
                    null, null, note, null, HtOrderEnum.OrderStatus.unpay.getId(), null, null,
                    cliType == null ? null : cliType.intValue(), note, goodsNumTotal, userReceivingInfo.getPno(),
                    StringUtils.abbreviateMiddle(userReceivingInfo.getPno(), "********", 17), CfgHelper.getValue("ht_category_id"),
                    m.getOrderSumfinalPrice());

                orders.add(order);
                m.setDmId(orderId);
            }
            try
            {

                getDao().addList(orders);
                this.orderLog(orders);

            }
            catch (DaoException e)
            {
            	log.error("HtOrderTransactionalImpl saveSubOrder exception|error:",e);
                e.setErrorMessage("下单失败");
                e.setErrorType(-1);
                throw new ServiceException(e);
            }
            result.setCarrierObject(batchId);
            log.info("HtOrderTransactionalImpl saveSubOrder|result="+result);

        }
        else
        {
            result = new Result<>("商品错误，订单计算失败", -1);
            result.setSuccess(false);
        }
        return result;

    }

    @Override
    public List<Map<String, Object>> findGoodsOrderMap(Map<String, Object> param) throws ServiceException
    {

        try
        {
            return dao.findGoodsOrderMap(param);
        }
        catch (DaoException e)
        {
            log.error(e);
            throw new ServiceException(e);
        }
    }

    private class taskExecutorOrder implements Runnable
    {
        private HtOrder htOrder;

        public taskExecutorOrder(HtOrder htOrder)
        {

            this.htOrder = htOrder;
        }

        @Override
        public void run()
        {
            try
            {

            	simpleUserWalletService.createProrate(htOrder.getDmId(), htOrder.getCountMoney(),
                    htOrder.getStaffCode(), htOrder.getVipCode(), System.currentTimeMillis(),
                    Integer.parseInt(htOrder.getPaymentWay()), htOrder.getPayMoney());
            	
            }
            catch (ServiceException e)
            {
                log.error(e);
            }
        }
    }

    private class taskExecutorModStock implements Runnable
    {

        private List<HtOrder> htOrders;

        public taskExecutorModStock(List<HtOrder> htOrders)
        {
            this.htOrders = htOrders;
        }

        @Override
        public void run()
        {
            try
            {
                handleOrderModel(htOrders);
            }
            catch (ServiceException e)
            {
                log.error(e);
            }
        }
    }

    @Override
    public Result<HtOrder> replenishmentOrder(Long orderId, String constantKey) throws ServiceException
    {

        Result<HtOrder> result = new Result<>();

        Double deductionPrice = 0d;
        Integer discountPercent = 0;

        HtOrderCalculateView htOrderCalculateView = new HtOrderCalculateView();

        if (constantKey != null)
        {
            Result<HtOrder> resultCalculate = this.calculatePaymentPrice(orderId);

            @SuppressWarnings("unchecked")
            List<RemissionRule> remissionRules = (List<RemissionRule>) resultCalculate.getCarrierMap().get("rule");

            for (RemissionRule remissionRule : remissionRules)
            {

                if (remissionRule.getConstantKey().equals(constantKey))
                {
                    deductionPrice = remissionRule.getDeductionPrice();
                    discountPercent = remissionRule.getDiscountPercent();
                }
            }
        }

        try
        {
            if (String.valueOf(orderId)
                .substring(HtOrderEnum.interceptState.start.getId(), HtOrderEnum.interceptState.end.getId())
                .equals(OrderPrefix.PP_HT_ORDER + HtOrderEnum.htOrderPrefix.batchPrefix.getId()))
            {
                HtOrder htOrder = new HtOrder();
                htOrder.setBatchId(orderId);

                List<HtOrder> htOrders = getDao().findList(htOrder);

                if (constantKey == null || deductionPrice.doubleValue() <= 0)
                {
                    for (HtOrder order : htOrders)
                    {
                        updateOrderById(orderId, constantKey, null, 0d, null, order.getCountMoney());
                        htOrderCalculateView
                            .setOrderPrice(ArithUtil.add(htOrderCalculateView.getOrderPrice(), order.getCountMoney()));
                    }

                    result.getCarrierMap().put("orderPrice", htOrderCalculateView.getOrderPrice());
                    result.getCarrierMap().put("paymentPrice", htOrderCalculateView.getOrderPrice());

                    return result;
                }

                calculationBatchOrder(orderId, constantKey, deductionPrice, discountPercent, result, htOrders,
                    htOrderCalculateView);

            }
            else if (String.valueOf(orderId)
                .substring(HtOrderEnum.interceptState.start.getId(), HtOrderEnum.interceptState.end.getId())
                .equals(OrderPrefix.PP_HT_ORDER + HtOrderEnum.htOrderPrefix.sonPrefix.getId()))
            {

                HtOrder order = getDao().findVo(orderId, new HtOrder());

                HtOrder htOrder = new HtOrder();
                htOrder.setDmId(order.getDmId());

                if (constantKey == null || deductionPrice.doubleValue() <= 0)
                {
                    updateOrderById(orderId, constantKey, null, deductionPrice, discountPercent, order.getCountMoney());

                    htOrderCalculateView
                        .setOrderPrice(ArithUtil.add(htOrderCalculateView.getOrderPrice(), order.getCountMoney()));
                    result.getCarrierMap().put("orderPrice", htOrderCalculateView.getOrderPrice());
                    result.getCarrierMap().put("paymentPrice", htOrderCalculateView.getOrderPrice());
                    return result;
                }

                htOrder.setConstantKey(constantKey);
                htOrder.setDiscountPercent(discountPercent);
                htOrder.setDeductionPrice(ArithUtil.div(ArithUtil.mul(order.getCountMoney(), discountPercent), 100, 2));
                htOrder.setPayMoney(ArithUtil.sub(order.getCountMoney(), htOrder.getDeductionPrice()));
                modVoNotNull(htOrder);

                htOrderCalculateView
                    .setOrderPrice(ArithUtil.add(htOrderCalculateView.getOrderPrice(), order.getCountMoney()));

                result.getCarrierMap().put("orderPrice", htOrderCalculateView.getOrderPrice());

                htOrderCalculateView.setOrderPrice(ArithUtil.sub(htOrderCalculateView.getOrderPrice(), deductionPrice));

                result.getCarrierMap().put("paymentPrice", htOrderCalculateView.getOrderPrice());
            }

        }
        catch (DaoException e)
        {
            log.error(e);
            e.setErrorMessage("保存补贴消费失败");
            throw new ServiceException(e);
        }

        return result;
    }

    /**
     * 用于清空补贴信息
     * 
     * @param orderId
     * @param constantKey
     * @param constantName
     * @param deductionPrice
     * @param discountPercent
     * @param payMoney
     * @throws DaoException
     */
    private void updateOrderById(Long orderId, String constantKey, String constantName, Double deductionPrice,
        Integer discountPercent, Double payMoney) throws DaoException
    {

        Map<String, Object> map = new HashMap<>();
        map.put("dmId", orderId);
        map.put("constantKey", constantKey);
        map.put("constantName", constantName);
        map.put("deductionPrice", deductionPrice);
        map.put("discountPercent", discountPercent);
        map.put("payMoney", payMoney);

        dao.updateOrderById(map);
    }

    /**
     * 计算批量订单
     * 
     * @param orderId
     * @param constantKey
     * @param deductionPrice
     * @param discountPercent
     * @param result
     * @param htOrders
     * @param htOrderCalculateView
     * @throws ServiceException
     */
    private void calculationBatchOrder(Long orderId, String constantKey, Double deductionPrice, Integer discountPercent,
        Result<HtOrder> result, List<HtOrder> htOrders, HtOrderCalculateView htOrderCalculateView)
            throws ServiceException
    {
        Double calculation = deductionPrice;

        if ("CONSUME_SUBSIDY".equals(constantKey))
        {

            for (HtOrder order : htOrders)
            {

                HtOrder htOrder = new HtOrder();
                htOrder.setDmId(order.getDmId());

                Double orderCalculation = ArithUtil.div(ArithUtil.mul(order.getCountMoney(), discountPercent), 100, 2);

                htOrder.setPayMoney(ArithUtil.sub(order.getCountMoney(), orderCalculation));
                htOrder.setDeductionPrice(orderCalculation);
                htOrder.setConstantKey(constantKey);
                htOrder.setDiscountPercent(discountPercent);

                modVoNotNull(htOrder);

                htOrderCalculateView
                    .setOrderPrice(ArithUtil.add(htOrderCalculateView.getOrderPrice(), order.getCountMoney()));
            }

            result.getCarrierMap().put("orderPrice", htOrderCalculateView.getOrderPrice());

            htOrderCalculateView.setOrderPrice(ArithUtil.sub(htOrderCalculateView.getOrderPrice(), deductionPrice));

            result.getCarrierMap().put("paymentPrice", htOrderCalculateView.getOrderPrice());

        }
        else
        {
            for (HtOrder order : htOrders)
            {

                HtOrder htOrder = new HtOrder();
                htOrder.setDmId(order.getDmId());
                htOrder.setPayMoney(order.getCountMoney());
                htOrder.setDeductionPrice(0.00);
                if (!calculation.equals(0.00))
                {

                    if (calculation.doubleValue() >= order.getCountMoney().doubleValue())
                    {

                        htOrder.setPayMoney(0.0d);
                        calculation = ArithUtil.sub(calculation, order.getCountMoney());
                        htOrder.setDeductionPrice(order.getCountMoney());

                    }
                    else
                    {
                        htOrder.setPayMoney(ArithUtil.sub(order.getCountMoney(), calculation));
                        htOrder.setDeductionPrice(calculation);
                        calculation = 0.00;
                    }

                    htOrder.setConstantKey(constantKey);
                    htOrder.setDiscountPercent(discountPercent);

                }

                modVoNotNull(htOrder);

                htOrderCalculateView
                    .setOrderPrice(ArithUtil.add(htOrderCalculateView.getOrderPrice(), order.getCountMoney()));
            }

            result.getCarrierMap().put("orderPrice", htOrderCalculateView.getOrderPrice());

            htOrderCalculateView.setOrderPrice(ArithUtil.sub(htOrderCalculateView.getOrderPrice(), deductionPrice));

            result.getCarrierMap().put("paymentPrice", htOrderCalculateView.getOrderPrice());
        }
    }

    @Override
    public Result<HtOrder> queryOrderGoodsByOrderId(Long orderId) throws ServiceException
    {

        Result<HtOrder> result = new Result<>();

        HtOrderGoods htOrderGoods = new HtOrderGoods();
        htOrderGoods.setOrderId(orderId);

        List<HtOrderGoodsPayView> listOrderGoods = new ArrayList<>();

        List<HtOrderGoods> list = orderGoodsService.findList(htOrderGoods);

        for (HtOrderGoods goods : list)
        {
            HtOrderGoodsPayView htOrderGoodsPayView = new HtOrderGoodsPayView();

            htOrderGoodsPayView.setDmId(goods.getDmId());
            htOrderGoodsPayView.setGoodsName(goods.getGoodsName());
            htOrderGoodsPayView.setGoodsNum(goods.getGoodsNum());
            htOrderGoodsPayView.setGoodsPrice(goods.getSaleMoney());
            htOrderGoodsPayView.setGoodsTotalPrice(goods.getGoodsTotalPrice());

            listOrderGoods.add(htOrderGoodsPayView);
        }

        result.setCarrierObject(listOrderGoods);

        return result;
    }

    @Override
    public Result<HtOrder> saveActivityOrder(OrderModel orderModel, Long userId, String userName, Integer userType,
        String tel, String idCard, String payPassword) throws ServiceException
    {

        Result<HtOrder> result = new Result<>();

        HtOrder htOrder = new HtOrder();

        UserWallet userWallet = userWalletService.findUserWallet(userId, userType);

        paymentCheck(result, userWallet, payPassword, orderModel.getPaymentPrice());

        if (!result.isSuccess())
        {
            return result;
        }

        if (!result.isSuccess())
        {
            return result;
        }

        Long orderId = Long
            .parseLong(OrderPrefix.PP_HT_ORDER + htOrderPrefix.sonPrefix.getId() + this.idServiceImpl.generateId());

        htOrder.set(orderId,
            Long.parseLong(OrderPrefix.PP_HT_ORDER + htOrderPrefix.batchPrefix.getId() + this.idServiceImpl.generateId()),
            orderModel.getSellerId(), orderModel.getSellerName(), userId, userName, orderModel.getOrderPrice(), null,
            null, orderModel.getOrderPrice(), orderModel.getPaymentPrice(),
            String.valueOf(PaymentMethodEnum.HTSUBSIDY.getValue()), null, null, 1, System.currentTimeMillis(), null,
            null, null, userName, null, null, null, null, "胖胖海淘", "胖胖海淘", tel, null, null, null, null,
            HtOrderEnum.OrderStatus.waitTake.getId(), null, null, null, null, 1, idCard,
            StringUtils.abbreviateMiddle(idCard, "********", 17), CfgHelper.getValue("ht_category_id"), orderModel.getOrderSumfinalPrice());
        if(htOrder.getDmId()==null||htOrder.getDmId()<1){
            htOrder.setDmId(idServiceImpl.generateId());
        }
        super.addVo(htOrder);

        for (HtStaffGoods gs : orderModel.getList())
        {

            HtOrderGoods og = new HtOrderGoods();

            og.set(orderId, gs.getGoodName(), gs.getPrice(), gs.getDmId(), gs.getPrice(), gs.getCostPrice(),
                gs.getCostPrice(), null, null, gs.getBuyNumber(), 1, 1, null, null, null, null, null, null,
                gs.getMainPicture(), null, null, 1, null, null, gs.getGoodCode(),
                gs.getFinalPrice() != null ? gs.getFinalPrice() : 0d,
                gs.getFinalPrice() != null ? gs.getFinalPrice() : 0d);
            if(og.getDmId()==null||og.getDmId()<1){
                og.setDmId(idServiceImpl.generateId());
            }
            orderGoodsService.addVo(og);
        }

        UserWallet vo = new UserWallet();
        vo.setHtsubsidyTotalAmount(ArithUtil.sub(0, orderModel.getPaymentPrice()));
        vo.setDmId(userWallet.getDmId());

        userWalletService.modWalletMoney(vo);

        UserConsumptionFlow userConsumptionFlow = new UserConsumptionFlow(htOrder.getVipCode(), htOrder.getDmId() + "",
            htOrder.getPayMoney(), PaymentMethodEnum.HTSUBSIDY.getValue(), System.currentTimeMillis());
        userConsumptionFlow.setStatisticsDate(new Date());
        if(userConsumptionFlow.getDmId()==null||userConsumptionFlow.getDmId()<1){
            userConsumptionFlow.setDmId(idServiceImpl.generateId());
        }
        userConsumptionFlowService.addVo(userConsumptionFlow);

        saveOrderLog(HtOrderEnum.OrderStatus.waitTake.getId(), orderId, "");

        // 给海淘发送金额流水信息
        result.setCarrierObject(modifyInventory(htOrder));

        ReconciliationResult r = new ReconciliationResult();
        r.setSourceType(UserWalletCountEnum.CONSUMPTION_HTSUBSIDY);
        r.setAmount(orderModel.getPaymentPrice());
        r.setUserId(userId);
        r.setUserType(userType);
        r.setPaymentMethod(PaymentMethodEnum.HTSUBSIDY.getValue());
        r.setReleaseDate(DateUtil.getTimeInSeconds());
        reconciliationMessageService.sendCountChange(r);

        return result;
    }

    /**
     * 支付验校
     * 
     * @param result
     * @param userWallet
     * @param payPassword
     */
    private void paymentCheck(Result<HtOrder> result, UserWallet userWallet, String payPassword, Double payMoney)
    {

        if (userWallet == null)
        {
            result.setFailMessage("你未开通钱包,暂不能支付");
            result.setCode(-1);
            return;
        }

        if (null == userWallet.getPayPwd())
        {
            result.setFailMessage("你还没有设置支付密码,暂不能支付");
            result.setCode(-1);
            return;
        }

        if (!userWallet.getPayPwd().equals(payPassword))
        {
            result.setFailMessage("你的支付密码有误,暂不能支付");
            result.setCode(-1);
            return;
        }

        if (userWallet.getHtsubsidyTotalAmount().doubleValue() < payMoney)
        {
            result.setFailMessage("你的海淘补贴金额不足,暂不能支付");
            result.setCode(-1);
            return;
        }

    }

    /**
     * 给海淘发送金额信息
     * 
     * @param htOrder
     * @throws ServiceException
     */
    private OrderModel modifyInventory(HtOrder htOrder) throws ServiceException
    {

        DisProfits dis = new DisProfits();
        double sellMoney = ArithUtil.div(ArithUtil.mul(htOrder.getCountMoney(), dis.getSellerDis()), 10, 2);

        OrderModel orderModel = new OrderModel();

        orderModel.setPaymentMethod(Integer.parseInt(htOrder.getPaymentWay()));
        orderModel.setSellerId(htOrder.getStaffCode());
        orderModel.setPaymentPrice(sellMoney);
        orderModel.setDmId(htOrder.getDmId());

        return orderModel;
    }
    
    /**
	 * 
	 * 根据订单时间修改订单状态
	 * 
	 * @param htOrder
	 * @param orderIdList
	 * @throws ServiceException 
	 */
	private void orderValidity(HtOrder htOrder) throws ServiceException{
		
		if(htOrder.getStatus().intValue() == 1 && (htOrder.getCrtime().longValue() - System.currentTimeMillis()) > orderTime ){
			htOrder.setStatus(6);
			
			try {
				dao.updateOrderStatusById(htOrder.getDmId());
				
				saveOrderLog(1, htOrder.getDmId(), "订单超时关闭");
				
				HtOrderApply htOrderApply = new HtOrderApply();
				htOrderApply.setReason("你的订单超时未支付,被系统自动关闭");
				htOrderApply.setOrderId(htOrder.getDmId());
				htOrderApply.setHandleType(HtOrderEnum.applyLaunch.customer_service.getId());
				htOrderApply.setStateExplain(HtOrderEnum.applyState.admin_arbitration.getId());
				htOrderApply.setCreateTime(System.currentTimeMillis());
				
				htOrderApplyService.shopReplyApply(htOrderApply);
				
				Message messages = new Message();
				messages.setCreateTime(System.currentTimeMillis());
				messages.setContent(MessageConstant.close_apply_constant);
				messages.setType(1);
				messages.setState(HtOrderEnum.OrderStatus.cancel.getId());
				messages.setUserId(htOrder.getVipCode());
				messages.setSourceId(htOrderApply.getDmId());
				messages.setDmId(this.idServiceImpl.generateId());
				messages.setOrderId(htOrder.getDmId());
				
				messageService.saveMessage(messages);
				
			} catch (DaoException e) {
				log.error(e);
				throw new ServiceException(e);
			}
		}
	}
	
	
	@Override
	public Result<HtOrder> modifyExpressCore(Long orderId,Long staffCode, String expressName, String expressCore) throws ServiceException {
		
		Result<HtOrder> result = new Result<>();
		
		try {
			
			int resltIn = dao.modifyExpressCore(orderId, staffCode, expressName, expressCore);
			
			if(resltIn == 0){
				result.setFailMessage("修改快递号失败");
			}
			
		} catch (DaoException e) {
			log.error(e);
			e.setErrorMessage("修改快递号失败");
			throw new ServiceException(e);
		}
		
		return result;
	}

}

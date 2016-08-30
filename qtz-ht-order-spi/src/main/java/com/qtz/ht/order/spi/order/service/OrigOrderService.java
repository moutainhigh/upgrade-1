package com.qtz.ht.order.spi.order.service;

import java.util.List;
import java.util.Map;

import com.qtz.base.dto.user.User;
import com.qtz.base.exception.ServiceException;
import com.qtz.ht.order.spi.common.Result;
import com.qtz.ht.order.spi.order.model.PayHtOrderModel;
import com.qtz.ht.order.spi.order.page.HtOrderPage;
import com.qtz.ht.order.spi.order.vo.HtOrder;
/**
 * <p>Title:OrderService</p>
 * <p>Description:订单服务接口类</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
 * @author 涂鑫 -xin.tu
 * @version v1.0 2015-09-02
 */
public interface OrigOrderService{
	/**
	 *【提交订单】
	 * 
	 * @param goodsMaps 商品map集合 Key：商品ID value ： 商品数量
	 * @param receivingId 会员地址ID
	 * @param user 会员
	 * @param note 备注
	 * @param cliType 平台来源  安卓  IOS
	 * @return
	 */
	public Result<HtOrder> saveSubOrder(Map<Long,Integer> goodsMaps,Long receivingId,User user,String note,Integer cliType);
	
	/**
	  * 
	  * 【计算支付价格】						
	  * @param orderId					订单id
	  * @throws ServiceException  
	  * @time:2015年9月2日 下午3:35:04
	  * @author 涂鑫
	  * @version
	 */
	public Result<HtOrder> calculatePaymentPrice(Long orderId);
	
	/**
	  * 
	  * 【获取订单】
	  * @param userId					订单用户id
	  * @param status 					订单状态
	  * @return
	  * @throws ServiceException  
	  * @time:2015年9月8日 上午11:52:10
	  * @author 涂鑫
	  * @version
	 */
	public Result<HtOrder> getHtOrderList(Long userId,Integer status,Integer pageIndex); 
	/**
	 * （前端获得订单详情）获得订单详情
	 * 
	 * @param htOrderId
	 * @return
	 * @throws ServiceException
	 */
	public Result<HtOrder> getHtOrderInfo(Long htOrderId);
	/**
	 * 
	  * 【取消订单】
	  * 
	  * @param orderId					订单id
	  * @param persionId				请求个人用户
	  * @param platform					平台
	  * @throws ServiceException  
	  * @time:2015年9月17日 下午3:06:30
	  * @author 涂鑫
	  * @version
	 */
	public Result<HtOrder> updateCancelOrder(Long orderId,Long persionId);
	
	/**
	 * 
	 * 【申请退款】
	 * @param userId				申请个人用户id
	 * @param orderId				订单id
	 * @param whetherGoods         1 未发货退款 2 未收货退款  3 已收货退款退款
	 * @param reason				退款理由
	 * @param goodsImg
	 * @return
	 */
	public Result<HtOrder> applyRefund(Long userId,Long orderId,Integer whetherGoods, String reason, String goodsImg);
	/**
	 * 商家不同意退款
	 * 
	 * @param sellerId 商家ID
	 * @param orderId　订单ID
	 * @param messag 退款理由
	 * @param deliver 是否发货
	 * @return
	 * @throws ServiceException
	 */
	public Result<HtOrder> shopNotRefund(Long sellerId, Long orderId, String messag, Integer deliver);
	/**
	 * 未发货同意退款
	 * 
	 * @param sellerId 商家ID
	 * @param orderId　订单ID
	 * @return
	 */
	public Result<HtOrder> notShippedAgreedRefund(Long sellerId, Long orderId);
	/**
	 * 已发货同意退款
	 * 
	 * @param sellerId　商家ID
	 * @param orderId　订单ID
	 * @param address　地址
	 * @param tel　　电话
	 * @param consignee　收货人
	 * @return
	 */
	public Result<HtOrder> alreadyShippedAgreedRefund(Long sellerId, Long orderId,String address, String tel, String consignee);
	/**
	 * 【管理员操作 ： 退货】
	 * 
	 * @param orderId　订单ID
	 * @param address　收货地址
	 * @param tel　收货电话
	 * @param consignee　收货人
	 * @return
	 * @throws ServiceException
	 */
	public Result<HtOrder> adminReturnGoods(Long orderId,String address, String tel, String consignee);
	/**
	 * 【管理员仲裁操作】
	 * 
	 * @param content 仲裁内容
	 * @param orderId　订单ID
	 * @return
	 * @throws ServiceException
	 */
	public Result<HtOrder> adminArbitration(Long orderId, String content);
	/**
	 * 【管理员退款操作】
	 * 
	 * @param orderId　订单ID
	 * @return
	 * @throws ServiceException
	 */
	public  Result<HtOrder> adminRefund(Long orderId);
	/**
	 * 用户发货
	 * 
	 * @param express 快速公司
	 * @param expressCode 快递号
	 * @param deliverTime 发货时间
	 * @return
	 * @throws ServiceException
	 */
	public Result<HtOrder> customerDelivery(Long orderId, String express, String expressCode, Long deliverTime);
	
	/**
	 * 
	 * 商家收货后确认后 退款
	 * 
	 * @param sellerId 商家ID
	 * @param orderId 订单ID
	 * @return
	 * @throws ServiceException
	 */
	public Result<HtOrder> shopConfirmOrder(Long sellerId, Long orderId);
	/**
	 * 供应商发货
	 * 
	 * @param orderId 订单ID
	 * @param express　快递公司
	 * @param expressCode　快递编号
	 * @return
	 * @throws ServiceException
	 */
	public Result<HtOrder> shopDeliverGoods(Long orderId, String express, String expressCode);
	/**
	 * （后台获得订单详情）获得订单详情
	 * 
	 * @param orderId 订单ID
	 * @return
	 * @throws ServiceException
	 */
	public Result<HtOrder> backstageOrderInfo(Long orderId);
	/**
	 * 用户确认收货
	 * 
	 * @param orderId
	 * @return
	 */
	public Result<HtOrder> userConfirmReceipt(Long orderId);
	/**
	 * 
	 * 
	 * @param orderApplyId
	 * @return
	 */
	public Result<HtOrder> getOrderApplyById(Long orderApplyId);
	
	/**
	 * 获得订单状态集
	 * 
	 * @param orderId
	 * @return
	 */
	public Result<HtOrder> getOrderstatusList(Long orderId);
	/**
	 * 根据订单ID获得海淘订单（用于海淘支付回调校验）
	 * 
	 * @param orderId
	 * @return
	 */
	public PayHtOrderModel queryOrderByIdOrBatchId(Long orderId);
	/**
	 * 处理支付成功回调
	 * 1,通知海淘接口
	 * 2,自动接单处理:添加交易对账中记录(退款操作需要关联)[高大上的名字是钱包划账]
	 * @param order
	 */
	public List<HtOrder> processPayCallback(HtOrder order)throws ServiceException;
	
	/**
	 * 获得商品订单映射
	 * @param param
	 * @return
	 * @throws ServiceException
	 */
	public List<Map<String, Object>> findGoodsOrderMap(Map<String, Object> param) throws ServiceException;
	
	/**
	* 【管理后台及供应商分页查看】
	* @param page
	* @return
	* @throws ServiceException  
	*/
	HtOrderPage query(HtOrderPage page) throws ServiceException;
	/**
	 * 根据订单ID(有批量订单ID查询有可能有多个子订单)查询订单集合
	 * 
	 * @param htOrderId
	 * @return
	 */
	public List<HtOrder> htOrderByIdList(Long htOrderId);
	/**
	 * 用于前端选择补贴时更改订单信息
	 * 
	 * @param orderId 订单ID
	 * @param constantKey　对应补贴KEY时
	 * @param constantName　补贴名称
	 * @param deductionPrice　补贴价格
	 * @param discountPercent　补贴折扣率
	 * @return
	 */
	public Result<HtOrder> replenishmentOrder(Long orderId, String constantKey);
	/**
	 * 根据订单ID查询订单商品
	 * 
	 * @param orderId
	 * @return
	 */
	public Result<HtOrder> queryOrderGoodsByOrderId(Long orderId);
	/**
	 * 保存活动订单
	 * 
	 * @param orderModel 订单模型
	 * @param userId 会员ID
	 * @param userName 会员名
	 * @param userType 会员类型（商家，会员）
	 * @param receivingId 地址信息
	 * @param payPassword 支付密码
	 * @return
	 */
	public Result<HtOrder> saveActivityOrder(String orderModel, Long userId, String userName,Integer userType,String tel, String idCard, String payPassword);
	/**
	 * 修改订单快递编号
	 * 
	 * @param orderId 订单ID
	 * @param staffCode 供应ID
	 * @param expressName 快递名称
	 * @param expressCore 快递号
	 * @return
	 */
	public Result<HtOrder> modifyExpressCore(Long orderId,Long staffCode, String expressName, String expressCore);
	
}
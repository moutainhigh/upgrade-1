package com.qtz.ht.order.spi.order.count.service;


import java.util.List;
import java.util.Map;

import com.qtz.base.common.Pager;
import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.BaseService;
import com.qtz.ht.order.spi.order.count.page.OrderCountPage;
import com.qtz.ht.order.spi.order.count.vo.OrderCount;
/**
 * <p>Title:OrderCountService</p>
 * <p>Description:订单统计服务接口类</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
 * @author 涂鑫 -xin.tu
 * @version v1.0 2015-12-10
 */
public interface OrderCountService extends BaseService<com.qtz.ht.order.spi.order.count.vo.OrderCount,java.lang.Long> {
  
  /**
   * 
    * 【添加队列统计任务】
    * @throws ServiceException  
    * @time:2015年12月10日 下午4:42:19
    * @author 涂鑫
    * @version
   */
  public void addQueueCountTask(OrderCount orderCount)throws ServiceException; 
  /**
   * 
    * 【执行订单统计任务】
    * @return  
    * @time:2015年12月11日 上午11:47:24
    * @author 涂鑫
    * @version
   */
  public OrderCount  saveRunQueueCountTask()throws ServiceException;
  
  /**
   * 
    * 【代理区域】
    * @param Time
    * @param regionId
    * @return
    * @throws ServiceException  
    * @time:2015年12月12日 下午8:28:00
    * @author 涂鑫
    * @version
   */
  public Double findAgentProfit(long Time,long regionId)throws ServiceException;
  
  /**
   * 
    * 【查询统计】
    * @param sellerPhone			商家手机号码
    * @param userPhone				购买用户手机号码
    * @param agentPhone				代理商手机号码
    * @param startTime				开始时间
    * @param endTime				结束时间
    * @return
    * @throws ServiceException  
    * @time:2015年12月15日 下午9:21:54
    * @author 涂鑫
    * @version
   */
  public Pager<OrderCount, Long> queryCounts(String sellerPhone,String userPhone,String agentPhone,Long startTime,Long endTime) throws ServiceException;
  /**
   * 
    * 【查询日订单统计】
    * @return
    * @throws ServiceException  
    * @time:2015年12月17日 下午8:30:01
    * @author 涂鑫
    * @version
   */
  public Map<String, Object> queryDayOrderCounts(String sellerPhone,String userPhone,String agentPhone,Long startTime,Long endTime,OrderCountPage orderCountPage) throws ServiceException;

  /**
   * 
   * 【条件查询】
   * @return
   * @throws ServiceException  
   * @time:2016年01月28日
   * @author 聂恒
   * @version
   */
  public List<OrderCount> findListByTime(Map<String, Long> map)throws ServiceException;
  
}
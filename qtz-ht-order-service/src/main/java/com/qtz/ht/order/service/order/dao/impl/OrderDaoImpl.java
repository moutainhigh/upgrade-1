package com.qtz.ht.order.service.order.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qtz.base.dao.impl.MyBaitsDaoImpl;
import com.qtz.base.exception.DaoException;
import com.qtz.base.util.Global;
import com.qtz.ht.order.service.order.dao.OrderDao;
import com.qtz.ht.order.spi.order.vo.HtOrder;

/**
 * <p>
 * Title:OrderDaoImpl
 * </p>
 * <p>
 * Description:订单DAO实现类
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: 深圳市擎天柱信息科技有限公司
 * </p>
 * @author 涂鑫 -xin.tu
 * @version v1.0 2015-09-02
 */
@Repository("orderDaoImpl")
public class OrderDaoImpl extends MyBaitsDaoImpl<HtOrder,Long> implements OrderDao
{
    /** MYBatis命名空间名 */
    private static String preName = OrderDao.class.getName();

    /**
     * 【取得】MYBatis命名空间名
     * @return MYBatis命名空间名
     */
    @Override
    protected String getPreName()
    {
        return preName;
    }

    @Override
    public List<HtOrder> queryTransactionClose(Map<String, Object> map) throws DaoException
    {
        return getMyBaitsTemplate().findList(getPreName(), "queryTransactionClose", map);
    }

    @Override
    public List<HtOrder> findOrderClose(Long ctime) throws DaoException
    {
        return getMyBaitsTemplate().findList(getPreName(), "queryCloseOrder", ctime);
    }

    @Override
    public void updateCancelOrderCoupon(Long orderId, Double payPrice) throws DaoException
    {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("orderId", orderId);
        parameter.put("payPrice", payPrice);
        getMyBaitsTemplate().getSqlSession().update(getPreName() + Global.SPLIT_DIAN + "updateCancelOrderCoupon",
            parameter);
    }

    @Override
    public List<HtOrder> querySellerCummer(Map<String, Object> map) throws DaoException
    {
        return getMyBaitsTemplate().findList(getPreName(), "querySellerCummer", map);
    }

    @Override
    public List<Map<Object, Object>> queryCountOrderMonth(Long userId, String month, int pageIndex, int pageSize)
        throws DaoException
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", userId);
        map.put("month", month);
        map.put("pageIndex", (pageIndex - 1) * pageSize);
        map.put("pageSize", pageSize);
        return getMyBaitsTemplate().findList(getPreName(), "queryCountOrderMonth", map);
    }

    // 改造
    @Override
    public HtOrder getLockOrder(Long orderId) throws DaoException
    {
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("orderId", orderId);
        return getMyBaitsTemplate().getSqlSession().selectOne(getPreName() + Global.SPLIT_DIAN + "getLockOrder",
            parameter);
    }

    @Override
    public List<HtOrder> queryTempOrder() throws DaoException
    {
        return getMyBaitsTemplate().getSqlSession().selectList(getPreName() + Global.SPLIT_DIAN + "queryTempOrder");
    }

    @Override
    public List<Map<String, Object>> getOrdersToExport(Map<String, Object> param) throws DaoException
    {
        return getMyBaitsTemplate().getSqlSession().selectList(getPreName() + Global.SPLIT_DIAN + "getOrdersToExport",
            param);
    }

    @Override
    public List<Map<String, Object>> findGoodsOrderMap(Map<String, Object> param) throws DaoException
    {
        // TODO Auto-generated method stub
        return getMyBaitsTemplate().getSqlSession().selectList(getPreName() + Global.SPLIT_DIAN + "findGoodsOrderMap",
            param);
    }

    @Override
    public List<Map<String, Object>> findSonGoodsOrderMap(Map<String, Object> param) throws DaoException
    {
        // TODO Auto-generated method stub
        return getMyBaitsTemplate().getSqlSession()
            .selectList(getPreName() + Global.SPLIT_DIAN + "findSonGoodsOrderMap", param);
    }

    @Override
    public int physicalIntervention(Integer intervention, Integer status, Long applyTime) throws DaoException
    {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("intervention", intervention);
        param.put("applyTime", applyTime);
        param.put("status", status);

        return getMyBaitsTemplate().getSqlSession().update(getPreName() + Global.SPLIT_DIAN + "physicalIntervention",
            param);
    }

    @Override
    public int automaticReceipt(Long checkTime, Integer status, Integer completeStatus) throws DaoException
    {

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("completeStatus", completeStatus);
        param.put("status", status);
        param.put("checkTime", checkTime);

        return getMyBaitsTemplate().getSqlSession().update(getPreName() + Global.SPLIT_DIAN + "automaticReceipt",
            param);
    }

    @Override
    public int updateOrderById(Map<String, Object> param) throws DaoException
    {
        // TODO Auto-generated method stub
        return getMyBaitsTemplate().getSqlSession().update(getPreName() + Global.SPLIT_DIAN + "updateOrderById", param);
    }
    
    @Override
	public int modifyExpressCore(Long orderId,Long staffCode, String expressName, String expressCore) throws DaoException {
		
		Map<String, Object> param = new HashMap<>();
		param.put("orderId", orderId);
		param.put("expressCore", expressCore);
		param.put("expressName", expressName);
		param.put("staffCode", staffCode);
		param.put("status", 4);
		
		return getMyBaitsTemplate().getSqlSession().update(getPreName()+Global.SPLIT_DIAN+"modifyExpressCore", param);
	}
	@Override
	public int updateOrderStatusById(Long orderId) throws DaoException {
		
		Map<String, Object> param = new HashMap<>();
		param.put("orderId", orderId);
		param.put("status", 1);

		return getMyBaitsTemplate().getSqlSession().update(getPreName()+Global.SPLIT_DIAN+"updateOrderStatusById", param);
	}
}
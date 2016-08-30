package com.qtz.ht.order.service.order.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qtz.base.dao.impl.MyBaitsDaoImpl;
import com.qtz.base.exception.DaoException;
import com.qtz.base.util.Global;
import com.qtz.ht.order.service.order.dao.SupermarketOrderDao;
import com.qtz.ht.order.spi.order.vo.SupermarketOrder;

/**
 * 
 * 
 * @author zxm
 *
 */
@Repository("supermarketOrderDaoImpl")
public class SupermarketOrderDaoImpl extends MyBaitsDaoImpl<SupermarketOrder, Long> implements SupermarketOrderDao
{

    /** MYBatis命名空间名 */
    private static String preName = SupermarketOrderDao.class.getName();

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
    public int physicalIntervention(Integer intervention, Integer orderStatus, Long applyTime) throws DaoException
    {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("intervention", intervention);
        param.put("applyTime", applyTime);
        param.put("orderStatus", orderStatus);

        return getMyBaitsTemplate().getSqlSession().update(getPreName() + Global.SPLIT_DIAN + "physicalIntervention",
            param);
    }

    @Override
    public List<SupermarketOrder> querySupermarkerByOrderId(SupermarketOrder supermarketOrder) throws DaoException
    {

        return getMyBaitsTemplate().getSqlSession()
            .selectList(getPreName() + Global.SPLIT_DIAN + "querySupermarkerByOrderId", supermarketOrder);
    }

    @Override
    public int updateOrderById(Map<String, Object> param) throws DaoException
    {
        return getMyBaitsTemplate().getSqlSession().update(getPreName() + Global.SPLIT_DIAN + "updateOrderById", param);
    }

    /*
     * @Override public SupermarketOrder querySupermarketOrderByStorageId(Long storageId) throws DaoException {
     * Map<String, Object> param = new HashMap<>(); param.put("storageId", storageId);
     * 
     * return (SupermarketOrder)
     * getMyBaitsTemplate().getSqlSession().selectList(getPreName()+Global.SPLIT_DIAN+"querySupermarketOrderByStorageId"
     * ,param); }
     */

}

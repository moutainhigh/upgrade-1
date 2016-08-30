package com.qtz.ht.order.service.order.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qtz.base.dao.impl.MyBaitsDaoImpl;
import com.qtz.base.exception.DaoException;
import com.qtz.base.util.Global;
import com.qtz.ht.order.service.order.dao.SupermarketOrderApplyDao;
import com.qtz.ht.order.spi.order.vo.SupermarketOrderApply;

@Repository("supermarketOrderApplyDaoImpl")
public class SupermarketOrderApplyDaoImpl extends MyBaitsDaoImpl<SupermarketOrderApply, Long>
    implements SupermarketOrderApplyDao
{

    /** MYBatis命名空间名 */
    private static String preName = SupermarketOrderApplyDao.class.getName();

    @Override
    protected String getPreName()
    {

        return preName;
    }

    @Override
    public Integer getOrderApplyCount(SupermarketOrderApply orderApply) throws DaoException
    {
        return getMyBaitsTemplate().getSqlSession().selectOne(getPreName() + Global.SPLIT_DIAN + "getOrderApplyCount",
            orderApply);
    }

    @Override
    public List<SupermarketOrderApply> getOrderApplyList(Long orderId) throws DaoException
    {
        return getMyBaitsTemplate().getSqlSession().selectList(getPreName() + Global.SPLIT_DIAN + "getOrderApplyList",
            orderId);

    }

}

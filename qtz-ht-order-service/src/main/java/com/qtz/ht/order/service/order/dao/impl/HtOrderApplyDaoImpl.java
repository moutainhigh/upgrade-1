package com.qtz.ht.order.service.order.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qtz.base.dao.impl.MyBaitsDaoImpl;
import com.qtz.base.exception.DaoException;
import com.qtz.base.util.Global;
import com.qtz.ht.order.service.order.dao.HtOrderApplyDao;
import com.qtz.ht.order.spi.order.vo.HtOrderApply;

@Repository("htOrderApplyDaoImpl")
public class HtOrderApplyDaoImpl extends MyBaitsDaoImpl<HtOrderApply, Long> implements HtOrderApplyDao
{

    private static String preName = HtOrderApplyDao.class.getName();

    @Override
    protected String getPreName()
    {

        return preName;
    }

    @Override
    public HtOrderApply getShopApply(Long orderApplyId) throws DaoException
    {

        Map<String, Object> param = new HashMap<>();
        param.put("orderApplyId", orderApplyId);

        return (HtOrderApply) getMyBaitsTemplate().getSqlSession()
            .selectList(getPreName() + Global.SPLIT_DIAN + "getShopApply", param);
    }

    @Override
    public List<HtOrderApply> getOrderApplyList(Long orderId) throws DaoException
    {

        Map<String, Object> param = new HashMap<>();
        param.put("orderId", orderId);

        return getMyBaitsTemplate().getSqlSession().selectList(getPreName() + Global.SPLIT_DIAN + "getOrderApplyList",
            param);
    }

}

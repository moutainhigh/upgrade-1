package com.qtz.ht.order.service.order.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.qtz.base.dao.BizDao;
import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.impl.BaseServiceImpl;
import com.qtz.ht.order.service.order.dao.HtOrderApplyDao;
import com.qtz.ht.order.spi.common.HtOrderEnum;
import com.qtz.ht.order.spi.common.Result;
import com.qtz.ht.order.spi.order.service.HtOrderApplyService;
import com.qtz.ht.order.spi.order.vo.HtOrderApply;
import com.qtz.id.spi.IdService;

@Service("htOrderApplyServiceImpl")
public class HtOrderApplyServiceImpl extends BaseServiceImpl<HtOrderApply, Long> implements HtOrderApplyService
{

    /** 初始化日志对象 */
    private static Logger log = Logger.getLogger(HtOrderApplyServiceImpl.class);

    @Resource(name = "htOrderApplyDaoImpl")
    private HtOrderApplyDao htOrderApplyDao;
    
    @Resource(name = "idServiceImpl")
    private IdService idServiceImpl;
    
    @Override
    protected BizDao<HtOrderApply, Long> getDao()
    {

        return htOrderApplyDao;
    }

    @Override
    public void userApply(HtOrderApply htOrderApply) throws ServiceException
    {
        try
        {

            if (htOrderApply != null)
            {

                htOrderApply.setHandleType(HtOrderEnum.applyLaunch.user_launch.getId());
                if(htOrderApply.getDmId()==null||htOrderApply.getDmId()<1){
                    htOrderApply.setDmId(this.idServiceImpl.generateId());
                }
                getDao().addVo(htOrderApply);
            }

        }
        catch (Exception e)
        {
            // TODO: handle exception
        }

    }

    @Override
    public void shopReplyApply(HtOrderApply htOrderApply) throws ServiceException
    {

        try
        {
            // TODO: 待完成

            htOrderApply.setDmId(this.idServiceImpl.generateId());

            getDao().addVo(htOrderApply);

        }
        catch (Exception e)
        {
            // TODO: handle exception
        }

    }

    @Override
    public void userReplyApply(HtOrderApply htOrderApply) throws ServiceException
    {
        try
        {
            // TODO: 待完成

            htOrderApply.setDmId(this.idServiceImpl.generateId());

            getDao().addVo(htOrderApply);

        }
        catch (Exception e)
        {
            // TODO: handle exception
        }

    }

    @Override
    public Result<HtOrderApply> getShopApplyById(Long orderApplyId)
    {

        Result<HtOrderApply> result = new Result<>();

        try
        {

            HtOrderApply htOrderApply = htOrderApplyDao.getShopApply(orderApplyId);

            result.setCarrier(htOrderApply);

        }
        catch (Exception e)
        {
        	log.error("HtOrderApplyServiceImpl getShopApplyById exception|orderApplyId="+orderApplyId,e);
            result.setFailMessage("");
        }

        return result;
    }

    @Override
    public Result<HtOrderApply> getOrderApplyList(Long orderId)
    {
        Result<HtOrderApply> result = new Result<>();

        try
        {

            List<HtOrderApply> list = htOrderApplyDao.getOrderApplyList(orderId);

            result.getCarrierList().addAll(list);

        }
        catch (Exception e)
        {
        	log.error("HtOrderApplyServiceImpl getOrderApplyList exception|orderId="+orderId,e);
            result.setFailMessage("");
        }

        return result;
    }

}

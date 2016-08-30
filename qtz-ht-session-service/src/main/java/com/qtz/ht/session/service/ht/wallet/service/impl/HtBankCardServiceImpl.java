package com.qtz.ht.session.service.ht.wallet.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.qtz.base.dao.BizDao;
import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.impl.BaseServiceImpl;
import com.qtz.ht.session.service.ht.wallet.dao.HtBankCardDao;
import com.qtz.ht.session.spi.wallet.service.HtBankCardService;
import com.qtz.ht.session.spi.wallet.vo.HtBankCard;
import com.qtz.id.spi.IdService;
import com.qtz.member.spi.user.dto.Region;
import com.qtz.member.spi.user.service.RegionService;

/**
 * <p>
 * Title:HtBankCardServiceImpl
 * </p>
 * <p>
 * Description:商户银行卡信息表服务实现类
 * </p>
 * <p>
 * Copyright: Copyright (c) 2016
 * </p>
 * <p>
 * Company: 深圳擎天柱信息技术有限公司
 * </p>
 * @author 唐礼军 - 1309025893@qq.com
 * @version v1.0 2016-06-21
 */
@Service("htBankCardServiceImpl")
public class HtBankCardServiceImpl extends BaseServiceImpl<HtBankCard, Long>
    implements HtBankCardService
{
    /** 注入商户银行卡信息表DAO接口类 */
    @Resource(name = "htBankCardDaoImpl")
    private HtBankCardDao dao;

    @Resource(name = "regionServiceImpl")
    private RegionService regionService;
	@Resource(name = "idServiceImpl")
	private IdService idService;

    /**
     * 【取得】业务DAO对象
     * @return 业务DAO对象
     */
    @Override
    protected BizDao<HtBankCard, Long> getDao()
    {
        return dao;
    }

	@Override
	public HtBankCard addVo(HtBankCard vo) throws ServiceException {
			if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		return super.addVo(vo);
	}

	@Override
	public void addList(List<HtBankCard> list) throws ServiceException {
		for (HtBankCard vo : list) {
				if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		}
		super.addList(list);
	}

    @Override
    public JSONObject getText(HtBankCard bank) throws ServiceException
    {
        JSONObject result = new JSONObject();
        Region r = null;
        if (null != bank.getAccountProvince())
        {
            r = this.regionService.findRegions(bank.getAccountProvince());
            result.put(HtBankCard.BANK_PROVINCE_TEXT, r.getName());
        }
        if (null != bank.getAccountCity())
        {
            r = this.regionService.findRegions(bank.getAccountCity());
            result.put(HtBankCard.BANK_CITY_TEXT, r.getName());
        }

        return result;
    }
}
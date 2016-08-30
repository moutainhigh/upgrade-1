package com.qtz.ht.session.service.ht.user.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qtz.base.common.ExceptionConstants;
import com.qtz.base.dao.BizDao;
import com.qtz.base.dto.user.UserType;
import com.qtz.base.exception.DaoException;
import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.impl.BaseServiceImpl;
import com.qtz.base.util.Constants;
import com.qtz.base.util.StringUtil;
import com.qtz.commons.encript.SHA256Encryption;
import com.qtz.ht.session.service.ht.user.dao.HtBusinessDao;
import com.qtz.ht.session.spi.user.service.HtBusinessLogService;
import com.qtz.ht.session.spi.user.service.HtBusinessService;
import com.qtz.ht.session.spi.user.service.HtStaffService;
import com.qtz.ht.session.spi.user.service.HtUserService;
import com.qtz.ht.session.spi.user.vo.HtBusiness;
import com.qtz.ht.session.spi.user.vo.HtBusinessLog;
import com.qtz.ht.session.spi.user.vo.HtStaff;
import com.qtz.ht.session.spi.user.vo.HtUser;
import com.qtz.ht.session.spi.util.ComparativeAttributeValue;
import com.qtz.ht.session.spi.wallet.service.HtBankCardService;
import com.qtz.ht.session.spi.wallet.service.HtWalletService;
import com.qtz.ht.session.spi.wallet.vo.HtBankCard;
import com.qtz.ht.session.spi.wallet.vo.HtWallet;
import com.qtz.ht.spi.enums.OperationActionEnum;
import com.qtz.id.spi.IdService;
import com.qtz.member.spi.user.dto.Region;
import com.qtz.member.spi.user.service.RegionService;

/**
 * <p>
 * Title:HtBusinessServiceImpl
 * </p>
 * <p>
 * Description:商户信息服务实现类
 * </p>
 * <p>
 * Copyright: Copyright (c) 2016
 * </p>
 * <p>
 * Company: 深圳市好实再商贸有限公司
 * </p>
 * @author tanglijun
 * @version v1.0 2016-01-25
 */
@Service("htBusinessServiceImpl")
public class HtBusinessServiceImpl extends BaseServiceImpl<HtBusiness, Long> implements HtBusinessService
{
    /** 注入商户信息DAO接口类 */
    @Resource(name = "htBusinessDaoImpl")
    private HtBusinessDao dao;
    @Resource(name = "htUserServiceImpl")
    private HtUserService htUserService;
    @Resource(name = "htBankCardServiceImpl")
    private HtBankCardService htBankCardService;
    @Resource(name = "htBusinessLogServiceImpl")
    private HtBusinessLogService htBusinessLogService;
    @Resource(name = "htStaffServiceImpl")
    private HtStaffService htStaffService;
    @Resource(name = "regionServiceImpl")
    private RegionService regionService;
    @Resource(name = "htWalletServiceImpl")
    private HtWalletService htWalletService;
    @Resource(name = "idServiceImpl")
	private IdService idService;

    /**
     * 【取得】业务DAO对象
     * @return 业务DAO对象
     */
    @Override
    protected BizDao<HtBusiness, Long> getDao()
    {
        return dao;
    }

	@Override
	public HtBusiness addVo(HtBusiness vo) throws ServiceException {
			if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		return super.addVo(vo);
	}

	@Override
	public void addList(List<HtBusiness> list) throws ServiceException {
		for (HtBusiness vo : list) {
				if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		}
		super.addList(list);
	}

    public HtBusiness addOrMod(Long operatorId, HtBusiness vo, HtUser user, HtBankCard bank) throws ServiceException
    {
        if (StringUtil.isEmpty(vo) || StringUtil.isEmpty(user))
        {
            throw new ServiceException(ExceptionConstants.ERRORCODE_7, "入参错误 ( " + vo.toString() + user.toString() + ")");
        }
        if (StringUtil.isEmpty(vo.getDmId()))
        {
            // 验证手机是否已添加
            if (this.checkMob(vo.getMobilePhone()))
            {
                // 保存商户信息
                vo.setSimpleName(vo.getFullName());
                vo.setCrtime(System.currentTimeMillis());
                vo.setIsFrozen(Constants.TWO);// 默认不屏蔽
                vo.setIsShield(Constants.TWO);// 默认不冻结
                HtBusiness b = this.addVo(vo);
                // 创建默认用户
                user.setAccount(vo.getMobilePhone());
                user.setBusiId(b.getDmId());
                user.setUserType(UserType.BUSINESS.value());
                user.setSex(Constants.THREE);
                user.setPassword(SHA256Encryption.encodeToSHA256(user.getPassword()));
                user.setRealName(vo.getMercName());
                user.setCrtime(vo.getCrtime());
                user.setCrname(operatorId);
                htUserService.addVo(user);

                // 添加银行卡
                bank.setBusiId(b.getDmId());
                bank.setCrUser(operatorId);
                bank.setCrTime(vo.getCrtime());
                bank.setCardholder(bank.getAccountType() == 0 ? b.getSimpleName() : b.getLegalPerson());
                htBankCardService.addVo(bank);

                // 开通钱包
                HtWallet wallet = new HtWallet(b.getDmId(), 0d, 0d, 0d, 0d, user.getPassword(),
                    UserType.BUSINESS.value(), operatorId, System.currentTimeMillis(), operatorId,
                    System.currentTimeMillis());
                this.htWalletService.addVo(wallet);
            }
        }
        else
        {
            super.modVoNotNull(vo);
        }
        return vo;
    }

    private boolean checkMob(String mobilePhone) throws ServiceException
    {
        HtBusiness q = new HtBusiness();
        q.setMobilePhone(mobilePhone);
        List<HtBusiness> list = super.findList(q);
        if (null == list || list.size() == 0)
        {
            return true;
        }
        else
        {
            throw new ServiceException(ExceptionConstants.ERRORCODE_18, "手机已经注册");
        }
    }

    @Override
    public void modMerchantInfo(Long userId, HtBusiness vo, HtUser user, HtBankCard bank) throws ServiceException
    {
        HtBusiness old_b = super.findVo(vo.getDmId(), null);
        HtUser old_u = this.htUserService.findVo(user.getDmId(), null);
        HtBankCard old_c = this.htBankCardService.findVo(bank.getDmId(), null);
        List<String> list = new ArrayList<>();
        list.addAll(ComparativeAttributeValue.compare(old_b, vo));
        list.addAll(ComparativeAttributeValue.compare(old_u, user));
        list.addAll(ComparativeAttributeValue.compare(old_c, bank));
        // 防止误修改密码
        user.setPassword(null);
        user.setBusiId(vo.getDmId());

        super.modVoNotNull(vo);
        this.htUserService.modVoNotNull(user);
        this.htBankCardService.modVoNotNull(bank);
        if (list.size() > 0)
        {
            HtBusinessLog log = new HtBusinessLog();
            log.setBusiId(vo.getDmId());
            log.setOperatAction(OperationActionEnum.edit.getValue());
            log.setOperateContent(OperationActionEnum.edit.getText());
            JSONArray json = new JSONArray();
            json.addAll(list);
            log.setOperatExplain(json.toJSONString());
            log.setOperaTime(System.currentTimeMillis());
            HtStaff staff = htStaffService.findVo(userId, null);
            log.setOperatorId(userId);
            log.setOperatorName(staff.getName());
            log.setOperaType(UserType.PPUSER.value());
            this.htBusinessLogService.addVo(log);
        }
    }

    @Override
    public JSONObject getText(HtBusiness vo) throws ServiceException
    {
        JSONObject result = new JSONObject();
        Region r = null;
        if (null != vo.getLegalProvince())
        {
            r = this.regionService.findRegions(vo.getLegalProvince());
            if (null != r)
            {
                result.put(HtBusiness.LEGAL_PROVINCE_TEXT, r.getName());
            }
        }
        if (null != vo.getLegalCity())
        {
            r = this.regionService.findRegions(vo.getLegalCity());
            if (null != r)
            {
                result.put(HtBusiness.LEGAL_CITY_TEXT, r.getName());
            }
        }
        if (null != vo.getLegalCounty())
        {
            r = this.regionService.findRegions(vo.getLegalCounty());
            if (null != r)
            {
                result.put(HtBusiness.LEGAL_COUNTY_TEXT, r.getName());
            }
        }
        if (null != vo.getLegalTown())
        {
            r = this.regionService.findRegions(vo.getLegalTown());
            if (null != r)
            {
                result.put(HtBusiness.LEGAL_TOWN_TEXT, r.getName());
            }
        }
        if (null != vo.getMercProvince())
        {
            r = this.regionService.findRegions(vo.getMercProvince());
            if (null != r)
            {
                result.put(HtBusiness.MERC_PROVINCE_TEXT, r.getName());
            }
        }
        if (null != vo.getMercCity())
        {
            r = this.regionService.findRegions(vo.getMercCity());
            if (null != r)
            {
                result.put(HtBusiness.MERC_CITY_TEXT, r.getName());
            }
        }
        if (null != vo.getMercCounty())
        {
            r = this.regionService.findRegions(vo.getMercCounty());
            if (null != r)
            {
                result.put(HtBusiness.MERC_COUNTY_TEXT, r.getName());
            }
        }
        if (null != vo.getMercTown())
        {
            r = this.regionService.findRegions(vo.getMercTown());
            if (null != r)
            {
                result.put(HtBusiness.MERC_TOWN_TEXT, r.getName());
            }
        }
        return result;
    }

    @Override
    public List<HtBusiness> findListByBusinessesId(Set<Long> idS) throws ServiceException
    {
        List<HtBusiness> list = null;
        if (null != idS && !idS.isEmpty())
        {
            try
            {
                list = dao.findListByBusinessesId(idS);
            }
            catch (DaoException e)
            {
                throw new ServiceException(ExceptionConstants.ERRORCODE_7, "查询失败", e);
            }
        }
        return list;
    }

}
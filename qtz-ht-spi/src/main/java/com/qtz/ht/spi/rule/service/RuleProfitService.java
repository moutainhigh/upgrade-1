package com.qtz.ht.spi.rule.service;
import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.BaseService;
import com.qtz.ht.spi.rule.vo.RuleProfit;
/**
 * <p>Title:RuleProfitService</p>
 * <p>Description:利润分配规则服务接口类</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 深圳市好实再商贸有限公司</p>
 * @author 李昌波 - changbo.li
 * @version v1.0 2015-09-23
 */
public interface RuleProfitService extends BaseService<com.qtz.ht.spi.rule.vo.RuleProfit,Long> {
	/**
	 * 
	* 【code 查询规则】(这里用一句话描述这个方法的作用)
	* @param code
	* @return
	* @throws ServiceException
	 */
	RuleProfit findByCode(String code) throws ServiceException;
}
package com.qtz.ht.service.good.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qtz.base.dao.BizDao;
import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.impl.BaseServiceImpl;
import com.qtz.ht.service.good.dao.HtGoodCateDao;
import com.qtz.ht.spi.good.service.HtGoodCateService;
import com.qtz.ht.spi.good.vo.HtGoodCate;
import com.qtz.id.spi.IdService;

/**
 * <p>Title:HtGoodCateServiceImpl</p>
 * <p>Description:商户商品分类服务实现类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
 * @author tanglijun
 * @version v1.0 2016-04-11
 */
@Service("htGoodCateServiceImpl")
public class HtGoodCateServiceImpl extends BaseServiceImpl<HtGoodCate,Long> implements HtGoodCateService  {
	/**注入商户商品分类DAO接口类*/
	@Resource(name="htGoodCateDaoImpl")
    private HtGoodCateDao dao;
	@Resource(name = "idServiceImpl")
	private IdService idService;
    
	/** 
	* 【取得】业务DAO对象
	* @return 	业务DAO对象  
	*/
	@Override
	protected BizDao<HtGoodCate,Long> getDao() {
		return dao;
	}

	@Override
	public HtGoodCate addVo(HtGoodCate vo) throws ServiceException {
			if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		return super.addVo(vo);
	}

	@Override
	public void addList(List<HtGoodCate> list) throws ServiceException {
		for (HtGoodCate vo : list) {
				if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		}
		super.addList(list);
	}
}
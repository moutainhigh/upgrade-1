package com.qtz.ht.service.system.service.impl;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qtz.base.dao.BizDao;
import com.qtz.base.exception.ServiceException;
import com.qtz.base.service.impl.BaseServiceImpl;
import com.qtz.ht.service.system.dao.HtFloorGoodsDao;
import com.qtz.ht.spi.system.service.HtFloorGoodsService;
import com.qtz.ht.spi.system.vo.HtFloorGoods;
import com.qtz.id.spi.IdService;

/**
 * <p>Title:HtFloorGoodsServiceImpl</p>
 * <p>Description:楼层关联商品服务实现类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
 * @author tanglijun
 * @version v1.0 2016-08-08
 */
@Service("htFloorGoodsServiceImpl")
public class HtFloorGoodsServiceImpl extends BaseServiceImpl<HtFloorGoods,Long> implements HtFloorGoodsService  {
	
	/**注入楼层关联商品DAO接口类*/
	@Resource(name="htFloorGoodsDaoImpl")
    private HtFloorGoodsDao dao;
	@Resource(name = "idServiceImpl")
	private IdService idService;
    
	/** 
	* 【取得】业务DAO对象
	* @return 	业务DAO对象  
	*/
	@Override
	protected BizDao<HtFloorGoods,Long> getDao() {
		return dao;
	}

	@Override
	public HtFloorGoods addVo(HtFloorGoods vo) throws ServiceException {
			if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		return super.addVo(vo);
	}

	@Override
	public void addList(List<HtFloorGoods> list) throws ServiceException {
		for (HtFloorGoods vo : list) {
				if (null == vo.getDmId()) vo.setDmId(idService.generateId());
		}
		super.addList(list);
	}
}
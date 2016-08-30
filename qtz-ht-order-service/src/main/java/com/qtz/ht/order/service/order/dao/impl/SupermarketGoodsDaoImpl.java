package com.qtz.ht.order.service.order.dao.impl;

import org.springframework.stereotype.Repository;

import com.qtz.base.dao.impl.MyBaitsDaoImpl;
import com.qtz.ht.order.service.order.dao.SupermarketGoodsDao;
import com.qtz.ht.order.spi.order.vo.SupermarketGoods;

@Repository("supermarketGoodsDaoImpl")
public class SupermarketGoodsDaoImpl extends MyBaitsDaoImpl<SupermarketGoods, Long> implements SupermarketGoodsDao {

	/**MYBatis命名空间名*/
	private static String preName = SupermarketGoodsDao.class.getName();
	
	/** 
	* 【取得】MYBatis命名空间名
	* @return  	MYBatis命名空间名
	*/
	@Override
	protected String getPreName() {
		return preName;
	}

}

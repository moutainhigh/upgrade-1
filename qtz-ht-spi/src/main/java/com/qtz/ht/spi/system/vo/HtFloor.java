package com.qtz.ht.spi.system.vo;
import java.util.List;

import com.qtz.base.dto.VO;

/**
 * <p>Title:HtFloor</p>
 * <p>Description:楼层管理表VO类</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: 深圳市擎天柱信息科技有限公司</p>
 * @author tanglijun
 * @version v1.0 2016-08-09
 */
public class HtFloor extends VO<Long> implements java.io.Serializable {
	
	/**类的版本号*/
	private static final long serialVersionUID = 1785397440235520L;

	
	/**楼层商品关联*/
	private List<HtFloorGoods> floorGoods;
		return floorGoods;
	}
	public void setFloorGoods(List<HtFloorGoods> floorGoods) {
		this.floorGoods = floorGoods;
	}
	public String toString() {
}
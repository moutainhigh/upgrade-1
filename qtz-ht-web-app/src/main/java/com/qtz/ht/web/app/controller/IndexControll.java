package com.qtz.ht.web.app.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.qtz.base.exception.ServiceException;
import com.qtz.base.response.RespJsonPHandler;
import com.qtz.base.util.Constants;
import com.qtz.ht.spi.good.service.HtStaffGoodsService;
import com.qtz.ht.spi.good.vo.HtStaffGoods;
import com.qtz.ht.spi.system.service.HtBannerService;


/**
 * <p>Title:MainControll</p>
 * <p>Description:(管理页面主界面)</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: 深圳市爱免费信息科技有限公司</p>
 * @author 唐礼军 - tanlijun
 * @version v1.0 2016-1-28
 */
@RestController
@RequestMapping(value="/")
public class IndexControll extends BaseController {
	
	/**
	 * 商品信息服务
	 */
	@Resource(name="htStaffGoodsServiceImpl")
	private HtStaffGoodsService htStaffGoodsService;
	
	
	@Resource(name="htBannerServiceImpl")
	private HtBannerService htBannerService; 
	
	/**
	* 【海淘首页】
	* @param versionType
	* 					版本类型  1：商家，2：个人
	* @param clientType
	* 					客户端类型(1：安卓,2：IOS,3:所有)
	* @param response
	* @param request
	* @throws IOException  
	*/
	@RequestMapping(value="index")
	public void index(@RequestParam("versionType")Integer versionType, @RequestParam("clientType")Integer clientType,
			HttpServletResponse response,HttpServletRequest request) throws IOException {
		try {
			JSONObject result = new JSONObject();
			result.put("bannerS", this.htBannerService.findSpecifyFieldList(versionType, clientType, Constants.ONE));
			result.put("goodS", this.htStaffGoodsService.findSpecifyFieldList(Constants.ONE));
			RespJsonPHandler.respOK(result, response, request);
		} catch (ServiceException e) {
			log.error(e.getErrorTitle(), e);
			RespJsonPHandler.respError(e.getErrorType(), e.getErrorTitle(), response,request);
		}
	}
	/**
	* 【活动页获取商品列表】
	* @param response
	* @param request
	* @throws IOException  
	*/
	@RequestMapping(value="v1.0/getPanicBuyingGoodsList")
	public void getPanicBuyingGoodsList(
			HttpServletResponse response,HttpServletRequest request) throws IOException {
		try {
			List<HtStaffGoods> list = this.htStaffGoodsService.getPanicBuyingGoodsList(Constants.ONE);
			List<HtStaffGoods> oneCars = null;
			List<HtStaffGoods> twoCars = null;
			if (null != list && list.size() > 4) {
				oneCars = list.subList(0, 4);
				twoCars = list.subList(4, list.size());
			}else{
				oneCars = list;
			}
			JSONObject result = new JSONObject();
			result.put("oneCars", oneCars);
			result.put("twoCars", twoCars);
			RespJsonPHandler.respOK(result, response, request);
		} catch (ServiceException e) {
			log.error(e.getErrorTitle(), e);
			RespJsonPHandler.respError(e.getErrorType(), e.getErrorTitle(), response,request);
		}
	}
	
	
	/**
	 * 返回上架时间排在前面的5条记录
	 * findShelvesTop5List:(). <br/> 
	 * TODO().<br/> 
	 * 
	 * @author yxd 
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping(value="findShelvesTop5List")
	public void findShelvesTop5List(HttpServletResponse response,HttpServletRequest request) throws IOException {
		try {
			JSONObject result = new JSONObject();
			result.put("goodS", this.htStaffGoodsService.findShelvesTop5List());
			RespJsonPHandler.respOK(result, response, request);
		
		} catch (ServiceException e) {
			log.error(e.getErrorTitle(), e);
			RespJsonPHandler.respError(e.getErrorType(), e.getErrorTitle(), response,request);
		}
	}
	
}

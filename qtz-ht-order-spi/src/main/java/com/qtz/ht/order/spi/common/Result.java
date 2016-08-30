package com.qtz.ht.order.spi.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.qtz.base.common.Pager;
import com.qtz.base.dto.VO;
/**
 * 服务调用信息载体类
 * 
 * @author Administrator
 *
 * @param <T>
 */
public class Result<T extends VO<Long>> implements Serializable{

	private static final long serialVersionUID = 7732916225236093369L;
	/**
	 * 服务调用是否成功  默认 ：true 失败 :false 
	 * 
	 * 获取结果之前先根据之字段判断服务调用是否成功
	 */
	private boolean  success = true;
	/**
	 * 服务调用失败时，失败原因
	 * 
	 */
	private String failMessage;
	/**
	 * 服务调用失败时，错误编码
	 */
	private int code;
	/**
	 * 信息载体模板
	 * 
	 */
	private T carrier;
	/**
	 * 信息载体模板集合
	 * 
	 */
	private List<T> carrierList;
	/**
	 * 其它类型的信息载体
	 */
	private Object carrierObject;
	/**
	 * 信息载体模板分页
	 */
	private Pager<T, Long> pager;
	/**
	 * map信息载体模板
	 */
	private Map<String, Object> carrierMap = new HashMap<>();
	
	public Result(){
		
	}
	
	public Result(String failMessage, int code) {
		this.failMessage = failMessage;
		this.code = code;
		this.success = false;
	}
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getFailMessage() {
		return failMessage;
	}

	public void setFailMessage(String failMessage) {
		this.success = false;
		this.failMessage = failMessage;
		
		if(code == 0){
			code = 1;
		}
	}

	public T getCarrier() {
		return carrier;
	}

	public void setCarrier(T carrier) {
		this.carrier = carrier;
	}

	public List<T> getCarrierList() {
		return carrierList;
	}

	public void setCarrierList(List<T> carrierList) {
		this.carrierList = carrierList;
	}

	public Object getCarrierObject() {
		return carrierObject;
	}

	public void setCarrierObject(Object carrierObject) {
		this.carrierObject = carrierObject;
	}

	public Pager<T, Long> getPager() {
		return pager;
	}

	public void setPager(Pager<T, Long> pager) {
		this.pager = pager;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Map<String, Object> getCarrierMap() {
		return carrierMap;
	}

	public void setCarrierMap(Map<String, Object> carrierMap) {
		this.carrierMap = carrierMap;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}

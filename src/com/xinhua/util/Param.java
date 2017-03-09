package com.xinhua.util;

/**
* interfacename:Param
* Version information:1.1
* Date:2012-05-14 10:44
* Creator:liuyanan
*/

public class Param {

	private String paramName;	//参数名称
	
	private Object paramValue;	//参数值
	
	private String operator;	//连接符(如：=,like,in)
	
	public Param() {}

	public Param(String paramName,String operator,Object paramValue) {
		this.paramName = paramName;
		this.paramValue = paramValue;
		this.operator = operator;
	}
	
	/**
	 * 获得参数名称
	 */
	public String getParamName() {
		return paramName;
	}

	/**
	 * 设置参数名称
	 * @param paramName
	 */
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	/**
	 * 获得参数值
	 */
	public Object getParamValue() {
		return paramValue;
	}

	/**
	 * 设置参数值
	 * @param paramValue
	 */
	public void setParamValue(Object paramValue) {
		this.paramValue = paramValue;
	}
	
	/**
	 * 获得连接符
	 */
	public String getOperator() {
		return operator;
	}

	/**
	 * 设置连接符
	 * @param operator
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}
}

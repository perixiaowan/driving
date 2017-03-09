package com.xinhua.log.service;

import java.util.List;
import java.util.Map;

import com.xinhua.util.Param;

@SuppressWarnings("all")
public interface LogService{

	/**
	 * 
	 * @param objName 要查询的类(表)
	 * @param params Vector参数Param对象集合
	 * @param orders Map排序 	
	 * @param start int 起始数
	 * @param count	int 页大小
	 * @return
	 */
	public abstract Object getCollection(String objName, List<Param> params, Map orders,int start, int count, String[] objectMap)throws Exception;
}

package com.xinhua.util.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.xinhua.util.Param;

/**
* interfacename:UtilService
* Version information:1.1
* Date:2012-05-14 10:26
* Creator:liuyanan
*/

@SuppressWarnings("all")
public interface UtilService{
	
	/**
	 * 保存
	 * @param obj	实体类对
	 * @throws Exception
	 */
	public abstract void save(Object obj) throws Exception;
	
	/**
	 * 修改
	 * @param obj	实体类对
	 * @throws Exception
	 */
	public abstract void update(Object obj) throws Exception;
	/**
	 * 修改
	 * @param obj	实体类对
	 * @throws Exception
	 */
	public abstract void merge(Object obj) throws Exception;
	
	/**
	 * 按条件更新
	 * @param hql
	 * @throws Exception
	 */
	public void updateAll(String hql) throws Exception;
	
	/**
	 * 删除
	 * @param obj 实体类对
	 * @throws Exception
	 */
	public abstract void delete(Object obj) throws Exception;
	
	/**
	 * 按条件删除
	 * @param hql
	 * @throws Exception
	 */
	public void deleteAll(String hql) throws Exception;
	
	/**
	 * 根据ID查询对象get
	 * @param classes
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public abstract Object getObjectById(Class classes,int id) throws Exception;
	
	/**
	 * 根据ID查询对象load
	 * @param classes
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public abstract Object loadObjectById(Class classes,int id) throws Exception;
	
	/**
	 * 用hql语句查询对象
	 * @param hql
	 * @return
	 */
	public abstract Object getHqlObject(String hql)throws Exception;
	
	/**
	 * 查询所有
	 * @param hql
	 * @return
	 * @throws Exception
	 */
	public abstract Collection getHqlAll(String hql) throws Exception;
	
	/**
	 * 用hql语句分页查询
	 * @param hql
	 * @param start 起始页码
	 * @param count 每页个数
	 * @return
	 */		
	public abstract Collection getHqlQuery(String hql,int start,int count)throws Exception;
	
	/**
	 * 查询集合大小
	 * @param hql
	 * @return
	 */		
	public Integer getHqlCount(String hql)throws Exception;
	/**
	 * 已过时
	 * @param objName 要查询的类(表)
	 * @param params Vector参数Param对象集合
	 * @param orders Map排序 	
	 * @param start int 起始数
	 * @param count	int 页大小
	 * @return
	 */
	@Deprecated
	public abstract Object getCollection(String objName, List<Param> params, Map orders,int start, int count, String[] objectMap)throws Exception;
	
	/**
	 * 
	 * @param objName 要查询的类(表)
	 * @param params Vector参数Param对象集合
	 * @param orders 排序 	
	 * @param start int 起始数
	 * @param count	int 页大小
	 * @return
	 */
	public abstract Object getCollection(String objName, List<Param> params, String orders,int start, int count, String[] objectMap)throws Exception;
	
	/**
	 * 查询所有集合，不分页
	 * @param objName 要查询的类(表)
	 * @param params Vector参数Param对象集合
	 * @param orders 排序 	
	 * @return
	 */
	public Object getCollectionAll(String select,String objName, List<Param> params, String orders, String[] objectMap) throws Exception;

	
	/**
	 * 获取电、水或天然气的最新数据
	 * @param groups 
	 * @param hql
	 * @return Object
	 * @throws Exception
	 */
	public Object getDataObject(String objName, List<Param> params, String orders, String groups, int start, int count,String[] objectMap) throws Exception;
}


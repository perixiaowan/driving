package com.xinhua.util.dao;

import java.util.Collection;

/**
* interfacename:UtilDao
* Version information:1.1
* Date:2012-05-14 10:01
* Creator:liuyanan
*/

@SuppressWarnings("all")

public interface UtilDao{
	
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
	 * 查询总记录数
	 * @param hql
	 * @return int
	 * @throws Exception
	 */
	public abstract int getHqlCount(String hql) throws Exception;
	
	/**
	 * 获取电、水或天然气的最新数据
	 * @param hql
	 * @return Object
	 * @throws Exception
	 */
	public abstract Object getDataObject(String hql, int start, int count) throws Exception;
}

package com.xinhua.util.dao.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xinhua.util.Loggers;
import com.xinhua.util.dao.UtilDao;

/**
* interfacename:UtilDaoImpl
* Version information:1.1
* Date:2012-05-14 10:01
* Creator:liuyanan                                                                                                                                                                                         
*/

@SuppressWarnings("all")
@Transactional
@Repository("utilDao")
public class UtilDaoImpl implements UtilDao{
	
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/**
	 * 保存
	 * @param obj	实体类
	 * @throws Exception
	 */
	public void save(Object obj) throws Exception{
		hibernateTemplate.save(obj);
	}

	/**
	 * 修改
	 * @param obj	实体类对
	 * @throws Exception
	 */
	@Transactional
	public void update(Object obj) throws Exception{
		hibernateTemplate.update(obj);
	}
	
	public void merge(Object obj) throws Exception {
		hibernateTemplate.merge(obj);
		
	}

	/**
	 * 按条件更新
	 * @param hql
	 * @throws Exception
	 */
	public void updateAll(String hql) throws Exception{
		Session session = null;
		try {
			session = this.hibernateTemplate.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.executeUpdate();
		}catch (RuntimeException e) {
			Loggers.error("------UtilDaoImpl updateAll 更新对象错误:"+e.getMessage());
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.clear();
				session.close();
			}
		}
	}
	
	/**
	 * 删除
	 * @param obj 实体类对
	 * @throws Exception
	 */
	@Transactional
	public void delete(Object obj) throws Exception{
		hibernateTemplate.delete(obj);
	}
	
	/**
	 * 按条件删除
	 * @param hql
	 * @throws Exception
	 */
	public void deleteAll(String hql) throws Exception{
		Session session = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.executeUpdate();
		} catch (RuntimeException e) {
			Loggers.error("------UtilDaoImpl deleteAll 删除对象错误:"+e.getMessage());
			e.printStackTrace();
		}finally {
			if (session != null && session.isOpen()) {
				session.clear();
				session.close();
			}
		}
	}
	
	/**
	 * 根据ID查询对象get
	 * @param classes
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Object getObjectById(Class classes,int id) throws Exception{
		return this.getHibernateTemplate().get(classes, id);
	}
	
	/**
	 * 根据ID查询对象load
	 * @param classes
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Object loadObjectById(Class classes,int id) throws Exception{
		return hibernateTemplate.load(classes, id);
	}
	
	/**
	 * 用hql语句查询对象
	 * @param hql
	 * @return
	 */
	public Object getHqlObject(String hql)throws Exception{
		try {
			List list = hibernateTemplate.find(hql);
			if(list != null && list.size()>0){
				Object obj = list.get(0);
				return obj;
			}
		} catch (RuntimeException e) {
			Loggers.error("------UtilDaoImpl getHqlObject 查询对象错误:"+e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 查询所有
	 * @param hql
	 * @return
	 * @throws Exception
	 */
	public Collection getHqlAll(String hql) throws Exception{
		return hibernateTemplate.find(hql);
	}
	
	/**
	 * 用hql语句分页查询
	 * @param hql
	 * @param start 起始页码
	 * @param count 每页个数
	 * @return
	 */		
	public Collection getHqlQuery(String hql,int start,int count)throws Exception{
		Session session = null;
		try {
			session = hibernateTemplate.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			query.setFirstResult(start);
			query.setMaxResults(count);
			return query.list();
		} catch (RuntimeException e) {
			Loggers.error("------UtilDaoImpl getHqlQuery 查询对象错误: "+e.getMessage());
			e.printStackTrace();
		}finally{
			if (session != null && session.isOpen()) {
				session.clear();
				session.close();
			}
		}
		return null;
	}
	
	/**
	 * 查询总记录数
	 * @param hql
	 * @return int
	 * @throws Exception
	 */
	public int getHqlCount(String hql) throws Exception {
		
		Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
	
		Query query = session.createQuery(hql);
		List list = query.list();
		//List list = this.getHibernateTemplate().find(hql);
		if (null != list && list.size() > 0) {
			if(null != list.get(0)){
				return Integer.parseInt(String.valueOf(list.get(0)));
			}
		}
		return 0;
	}
	
	public Object getDataObject(String hql, int start, int count) throws Exception {
		Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(1);
		List list = query.list();
		if(null!=list && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
}
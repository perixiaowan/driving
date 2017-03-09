package com.xinhua.util.service.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.xinhua.util.Param;
import com.xinhua.util.dao.UtilDao;
import com.xinhua.util.service.UtilService;

/**
* interfacename:UtilServiceImpl
* Version information:1.1
* Date:2012-05-14 10:44
* Creator:liuyanan
*/

@SuppressWarnings("all")
@Service("utilService")
public class UtilServiceImpl implements UtilService {
	
	private UtilDao utilDao;

	public UtilDao getUtilDao() {
		return utilDao;
	}
	
	@Resource(name="utilDao")
	public void setUtilDao(UtilDao utilDao) {
		this.utilDao = utilDao;
	}
	
	/**
	 * 保存
	 * @param obj	实体类对
	 * @throws Exception
	 */
	public void save(Object obj) throws Exception {
		this.utilDao.save(obj);
	}

	/**
	 * 修改
	 * @param obj	实体类对
	 * @throws Exception
	 */
	public void update(Object obj) throws Exception {
		this.utilDao.update(obj);
	}
	
	/**
	 * 按条件更新
	 * @param hql
	 * @throws Exception
	 */
	public void updateAll(String hql) throws Exception {
		this.utilDao.updateAll(hql);
	}

	/**
	 * 删除
	 * @param obj 实体类对
	 * @throws Exception
	 */
	public void delete(Object obj) throws Exception {
		this.utilDao.delete(obj);
	}

	/**
	 * 按条件删除
	 * @param hql
	 * @throws Exception
	 */
	public void deleteAll(String hql) throws Exception {
		this.utilDao.deleteAll(hql);
	}

	/**
	 * 根据ID查询对象get
	 * @param classes
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Object getObjectById(Class classes, int id) throws Exception {
		return this.utilDao.getObjectById(classes, id);
	}
	
	/**
	 * 根据ID查询对象load
	 * @param classes
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Object loadObjectById(Class classes, int id) throws Exception {
		return this.utilDao.loadObjectById(classes, id);
	}
	
	/**
	 * 用hql语句查询对象
	 * @param hql
	 * @return
	 */
	public Object getHqlObject(String hql) throws Exception {
		return this.utilDao.getHqlObject(hql);
	}
	
	/**
	 * 查询所有
	 * @param hql
	 * @return
	 * @throws Exception
	 */
	public Collection getHqlAll(String hql) throws Exception {
		return this.utilDao.getHqlAll(hql);
	}

	/**
	 * 用hql语句分页查询
	 * @param hql
	 * @param start 起始页码
	 * @param count 每页个数
	 * @return
	 */		
	public Collection getHqlQuery(String hql,int start,int count)throws Exception{
		return utilDao.getHqlQuery(hql,start,count);
	}
	
	/**
	 * 查询集合大小
	 * @param hql
	 * @return
	 */		
	public Integer getHqlCount(String hql)throws Exception{
		return utilDao.getHqlCount(hql);
	}
	/**
	 * 方法过时
	 * @param objName 要查询的类(表)
	 * @param params Vector参数Param对象集合
	 * @param orders Map排序 	
	 * @param start int 起始数
	 * @param count	int 页大小
	 * @return
	 */
	public Object getCollection(String objName, List<Param> params, Map orders, int start, int count, String[] objectMap) throws Exception {
		Session session = null;
		Query query = null;
			// 组合检索语句
		String strSQL = null;
		StringBuffer strBuff = new StringBuffer();
		if(count == 0){
			strBuff.append("select count(*) from ");
		}else{
			strBuff.append("from ");
		}	
		strBuff.append(objName + " d");
		if(count != 0){
			if(objectMap != null){
				for(int i=0;i<objectMap.length;i++){
					strBuff.append(" left join fetch d.");
					strBuff.append(objectMap[i]);
				}
			}
		}
		//strBuff.append(" where d.isDele=0");
		if (params != null && params.size() > 0) {
			for (Param param : params) {
				strBuff.append(" and d.");
				strBuff.append(param.getParamName());
				if (param.getOperator().trim().equals("in")) {
					strBuff.append(" " + param.getOperator() + "(");
					strBuff.append(param.getParamValue());
					strBuff.append(")");
				} else if (param.getOperator().trim().equals("like")) {
					strBuff.append(" " + param.getOperator());
					strBuff.append(" '%" + param.getParamValue() + "%'");
				} else if (param.getOperator().trim().equals("between")) {
					strBuff.append(" " + param.getOperator());
					String str = (String)param.getParamValue();
					String date[] = str.split(",");	// 2000-01-01,2000-02-02
					strBuff.append(" " + date[0] + "  00:00:00" + " and "
							+ date[1] + " 23:59:59");
				} else if (param.getOperator().trim().equals("=")) {
					strBuff.append(param.getOperator());
					if ("class java.lang.Integer".equals(param
							.getParamValue().getClass().toString())) {
						strBuff.append(param.getParamValue());
					} else {
						strBuff.append("'" + param.getParamValue() + "'");
					}
				}else if (param.getOperator().trim().equals("!=")) {
					strBuff.append(param.getOperator());
					if ("class java.lang.Integer".equals(param
							.getParamValue().getClass().toString())) {
						strBuff.append(param.getParamValue());
					} else {
						strBuff.append("'" + param.getParamValue() + "'");
					}
				} else {
					strBuff.append(param.getOperator());
					strBuff.append("'" + param.getParamValue() + "'");
				}
			}
		}
		if (orders != null && !orders.isEmpty()) {
			strBuff.append(" order by ");
			for (Iterator it = orders.keySet().iterator(); it.hasNext();) {
				String orderName = (String) it.next();
				strBuff.append("d.");
				strBuff.append(orderName);
				strBuff.append(" ");
				strBuff.append((String) orders.get(orderName));
				strBuff.append(",");
			}
			strBuff.setLength(strBuff.length() - 1);
		}
		strSQL = new String(strBuff);
		if(count>0){
			return this.utilDao.getHqlQuery(strSQL, start, count);
		}else if (count == 0) {
			return this.utilDao.getHqlCount(strSQL);
		}else if (count == -1) {
			return this.utilDao.getHqlAll(strSQL);
		}
		return null; 
	}
	
	/**
	 * 
	 * @param objName 要查询的类(表)
	 * @param params Vector参数Param对象集合
	 * @param orders 排序 	
	 * @param start int 起始数
	 * @param count	int 页大小
	 * @return
	 */
	public Object getCollection(String objName, List<Param> params, String orders, int start, int count, String[] objectMap) throws Exception {
		Session session = null;
		Query query = null;
			// 组合检索语句
		String strSQL = null;
		StringBuffer strBuff = new StringBuffer();
		if(count == 0){
			strBuff.append("select count(*) from ");
		}else{
			strBuff.append("from ");
		}	
		strBuff.append(objName + " d");
		if(count != 0){
			if(objectMap != null){
				for(int i=0;i<objectMap.length;i++){
					strBuff.append(" left join fetch d.");
					strBuff.append(objectMap[i]);
				}
			}
		}
		strBuff.append(" where d.isDele=0");
		if (params != null && params.size() > 0) {
			for (Param param : params) {
				strBuff.append(" and d.");
				strBuff.append(param.getParamName());
				if (param.getOperator().trim().equals("in")) {
					strBuff.append(" " + param.getOperator() + "(");
					strBuff.append(param.getParamValue());
					strBuff.append(")");
				} else if (param.getOperator().trim().equals("like")) {
					strBuff.append(" " + param.getOperator());
					strBuff.append(" '%" + param.getParamValue() + "%'");
				} else if (param.getOperator().trim().equals("between")) {
					strBuff.append(" " + param.getOperator());
					String str = (String)param.getParamValue();
					String date[] = str.split(",");	// 2000-01-01,2000-02-02
					strBuff.append(" '" + date[0] + "  00:00:00" + "' and '"
							+ date[1] + " 23:59:59'");
				} else if (param.getOperator().trim().equals("=")) {
					strBuff.append(param.getOperator());
					if ("class java.lang.Integer".equals(param
							.getParamValue().getClass().toString())) {
						strBuff.append(param.getParamValue());
					} else {
						strBuff.append("'" + param.getParamValue() + "'");
					}
				}else if (param.getOperator().trim().equals("!=")) {
					strBuff.append(param.getOperator());
					if ("class java.lang.Integer".equals(param
							.getParamValue().getClass().toString())) {
						strBuff.append(param.getParamValue());
					} else {
						strBuff.append("'" + param.getParamValue() + "'");
					}
				} else {
					strBuff.append(param.getOperator());
					strBuff.append("'" + param.getParamValue() + "'");
				}
			}
		}
		if (orders != null && !"".equals(orders)) {
			strBuff.append(" order by ");
			strBuff.append(orders);
		}
		strSQL = new String(strBuff);
		if(count>0){
			return this.utilDao.getHqlQuery(strSQL, start, count);
		}else if (count == 0) {
			return this.utilDao.getHqlCount(strSQL);
		}
		return null; 
	}
	
	/**
	 * 查询所有集合，不分页
	 * @param objName 要查询的类(表)
	 * @param params Vector参数Param对象集合
	 * @param orders 排序 	
	 * @param start int 起始数
	 * @param count	int 页大小
	 * @return
	 */
	public Object getCollectionAll(String select,String objName, List<Param> params, String orders, String[] objectMap) throws Exception {
		Session session = null;
		Query query = null;
			// 组合检索语句
		String strSQL = null;
		StringBuffer strBuff = new StringBuffer();
		if (select != null && !"".equals(select)){
			strBuff.append(select);
			strBuff.append(" from ");
			strBuff.append(objName + " d");
			if(objectMap != null){
				for(int i=0;i<objectMap.length;i++){
					strBuff.append(" left join d.");
					strBuff.append(objectMap[i]);
				}
			}
		} else {
			strBuff.append(" from ");
			strBuff.append(objName + " d");
			if(objectMap != null){
				for(int i=0;i<objectMap.length;i++){
					strBuff.append(" left join fetch d.");
					strBuff.append(objectMap[i]);
				}
			}
		}
		
		strBuff.append(" where d.isDele=0");
		if (params != null && params.size() > 0) {
			for (Param param : params) {
				strBuff.append(" and d.");
				strBuff.append(param.getParamName());
				if (param.getOperator().trim().equals("in")) {
					strBuff.append(" " + param.getOperator() + "(");
					strBuff.append(param.getParamValue());
					strBuff.append(")");
				} else if (param.getOperator().trim().equals("like")) {
					strBuff.append(" " + param.getOperator());
					strBuff.append(" '%" + param.getParamValue() + "%'");
				} else if (param.getOperator().trim().equals("between")) {
					strBuff.append(" " + param.getOperator());
					String str = (String)param.getParamValue();
					String date[] = str.split(",");	// 2000-01-01,2000-02-02
					strBuff.append(" " + date[0] + "  00:00:00" + " and "
							+ date[1] + " 23:59:59");
				} else if (param.getOperator().trim().equals("=")) {
					strBuff.append(param.getOperator());
					if ("class java.lang.Integer".equals(param
							.getParamValue().getClass().toString())) {
						strBuff.append(param.getParamValue());
					} else {
						strBuff.append("'" + param.getParamValue() + "'");
					}
				}else if (param.getOperator().trim().equals("!=")) {
					strBuff.append(param.getOperator());
					if ("class java.lang.Integer".equals(param
							.getParamValue().getClass().toString())) {
						strBuff.append(param.getParamValue());
					} else {
						strBuff.append("'" + param.getParamValue() + "'");
					}
				} else {
					strBuff.append(param.getOperator());
					strBuff.append("'" + param.getParamValue() + "'");
				}
			}
		}
		if (orders != null && !"".equals(orders)) {
			strBuff.append(" order by ");
			strBuff.append(orders);
		}
		strSQL = new String(strBuff);
		return this.utilDao.getHqlAll(strSQL);
	}

	public void merge(Object obj) throws Exception {
		utilDao.merge(obj);
		
	}

	public Object getDataObject(String objName, List<Param> params, String orders, String groups, int start, int count,String[] objectMap) throws Exception {
		String strSQL = null;
		//strSQL = "SELECT * FROM (SELECT * FROM `t_electric` ORDER BY `create_time` DESC) `temp`  GROUP BY component_code ORDER BY `create_time` DESC";
		strSQL="from TElectric group by componentCode order by createTime desc";
		/*		StringBuffer strBuff = new StringBuffer();
		if (objName != null && !"".equals(objName)){
			strBuff.append("select * from (select * from " + objName + " d where d.isDele=0  order by " +  orders + ")  temp ");
			if(objectMap != null){
				for(int i=0;i<objectMap.length;i++){
					strBuff.append(" left join temp.");
					strBuff.append(objectMap[i]);
				}
			}
		} else {
			return null;
		}
		strBuff.append(" group by temp.componentCode order by " + orders);
		strSQL = new String(strBuff);*/
		if(count>0){
			return this.utilDao.getDataObject(strSQL, start, count);
		}else if (count == 0) {
			return this.utilDao.getHqlCount(strSQL);
		}
		//return utilDao.getDataObject(strSQL);
		return null;
	}


	
	
}

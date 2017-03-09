package com.xinhua.log.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.xinhua.log.service.LogService;
import com.xinhua.util.Param;
import com.xinhua.util.dao.UtilDao;

@SuppressWarnings("all")
@Service("logService")
public class LogServiceImpl implements LogService {
	
	private UtilDao utilDao;

	public UtilDao getUtilDao() {
		return utilDao;
	}
	
	@Resource(name="utilDao")
	public void setUtilDao(UtilDao utilDao) {
		this.utilDao = utilDao;
	}
	
	/**
	 * 
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
		strBuff.append(" where 1=1");
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
					strBuff.append(" '%" + param.getParamValue() + "%' ");
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
		}
		return null; 
	}
}

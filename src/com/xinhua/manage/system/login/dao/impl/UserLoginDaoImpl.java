package com.xinhua.manage.system.login.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.xinhua.manage.system.login.dao.UserLoginDao;
import com.xinhua.manage.system.user.model.TDrivingUser;
import com.xinhua.util.Loggers;


@SuppressWarnings("all")
@Repository("userLoginDao")
public class UserLoginDaoImpl implements UserLoginDao {
	
	
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public TDrivingUser userLogin(String userName, String userPassword)
			throws Exception {
		List<TDrivingUser> userList = null;
		TDrivingUser user = null;
		String hql = "";
		try {
			if(userName != null && userPassword != null){
				hql = "from TDrivingUser user left join fetch user.TDrivingUserGroup where user.userName = '"+userName+"' and user.isDele=0";
				userList = hibernateTemplate.find(hql);
				if(userList != null && userList.size() > 0){
					for(int i=0;i<userList.size();i++){
						user = userList.get(i);
						
						if(userPassword.trim().equals(user.getUserPassword().trim())){
							return user;
						}else{
							return null;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Loggers.error("------UserLoginDaoImpl userLogin 错误:"+e.getMessage());
		}
		return null;
		
		
	}
	

}

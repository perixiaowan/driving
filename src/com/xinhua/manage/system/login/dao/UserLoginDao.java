package com.xinhua.manage.system.login.dao;

import com.xinhua.manage.system.user.model.TDrivingUser;

public interface UserLoginDao {
	
	/**
	 * 根据用户和密码获取对象
	 * @param username
	 * @param userpassword
	 * @return
	 * @throws Exception 
	 */
	public TDrivingUser userLogin(String userName, String userPassword) throws Exception;
	
}	



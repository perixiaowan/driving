package com.xinhua.manage.system.login.service;


import com.xinhua.manage.system.user.model.TDrivingUser;

public interface UserLoginService {
	/**
	 * 根据用户和密码获取对象
	 * @param userName
	 * @param userRealPassword
	 * @return
	 * @throws Exception 
	 */
	public TDrivingUser userLogin(String userName, String userPassword) throws Exception;
	
}

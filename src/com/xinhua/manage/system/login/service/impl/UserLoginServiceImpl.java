package com.xinhua.manage.system.login.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xinhua.manage.system.login.dao.UserLoginDao;
import com.xinhua.manage.system.login.service.UserLoginService;
import com.xinhua.manage.system.user.model.TDrivingUser;


@SuppressWarnings("all")
@Service("userLoginService")
public class UserLoginServiceImpl implements UserLoginService {

	private UserLoginDao userLoginDao;
	
	public UserLoginDao getUserLoginDao() {
		return userLoginDao;
	}
	

	@Resource(name="userLoginDao")
	public void setUserLoginDao(UserLoginDao userLoginDao) {
		this.userLoginDao = userLoginDao;
	}

	
	public TDrivingUser userLogin(String userName, String userPassword)
			throws Exception {
		// TODO Auto-generated method stub
		return this.userLoginDao.userLogin(userName,userPassword);
	}

	

	


}

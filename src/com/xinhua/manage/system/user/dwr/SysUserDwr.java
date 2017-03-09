package com.xinhua.manage.system.user.dwr;

import java.util.List;

import com.xinhua.manage.system.user.model.TDrivingUser;
import com.xinhua.util.Dwr;
import com.xinhua.util.service.UtilService;

@SuppressWarnings("unchecked")
public class SysUserDwr extends Dwr{
	UtilService utilService = (UtilService) super.getBean("utilService");
	
	/**
	 * 用户名唯一验证
	 * @throws Exception 
	 */
	public String checkOnly(String username) throws Exception{
		if(username != null && !"".equals(username)){
			List<TDrivingUser> userList = (List<TDrivingUser>) utilService.getHqlAll("from SysUser where isDele = 0 and userName = '"+username+"'");
			if(userList != null && userList.size()>0){
				return "1";
			}
		}
		return "0";
	}
	
}

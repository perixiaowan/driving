package com.xinhua.util.action;

import javax.annotation.Resource;

import com.xinhua.manage.system.user.model.TDrivingUser;
import com.xinhua.util.ContextPvd;
import com.xinhua.util.Page;
import com.xinhua.util.service.UtilService;
import com.opensymphony.xwork2.ActionSupport;

public class UtilBaseAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	protected String ids;	//页面传递的id，用于修改、查看、删除操作使用
	
	protected String tip;	//提示信息1成功，2失败
	
	protected Page page;	//分页
	
	protected String str_size;	//偏移量
	
	protected String str_num;	//第几页
	
	protected ContextPvd contextPvd;
	
	protected UtilService utilService;
	
	protected TDrivingUser user;	
	
	
	
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getStr_size() {
		return str_size;
	}

	public void setStr_size(String str_size) {
		this.str_size = str_size;
	}

	public String getStr_num() {
		return str_num;
	}

	public void setStr_num(String str_num) {
		this.str_num = str_num;
	}

	public UtilService getUtilService() {
		return utilService;
	}
	
	public ContextPvd getContextPvd() {
		return contextPvd;
	}
	@Resource(name="contextPvd")
	public void setContextPvd(ContextPvd contextPvd) {
		this.contextPvd = contextPvd;
	}

	@Resource(name="utilService")
	public void setUtilService(UtilService utilService) {
		this.utilService = utilService;
	}



	public TDrivingUser getUser() {
		return user;
	}

	public void setUser(TDrivingUser user) {
		this.user = user;
	}
}

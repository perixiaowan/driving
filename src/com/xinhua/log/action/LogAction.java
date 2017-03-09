package com.xinhua.log.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.xinhua.log.model.Reslog;
import com.xinhua.log.service.LogService;
import com.xinhua.util.Loggers;
import com.xinhua.util.Page;
import com.xinhua.util.Param;

import com.xinhua.util.action.UtilBaseAction;

@ParentPackage("managerPackage")
@Namespace("/log")
@Action("log")
@Results({
		@Result(name = "log_list", location = "/system/log/log_list.jsp"),
		@Result(name = "reslog_look", location = "/system/log/log_look.jsp")
		})
@SuppressWarnings("all")
public class LogAction extends UtilBaseAction {
	private List<Reslog> logList;
	private LogService logService;
	private String userName;
	private String logType;
	private Reslog reslog;
	
	public Reslog getReslog() {
		return reslog;
	}

	public void setReslog(Reslog reslog) {
		this.reslog = reslog;
	}

	public LogService getLogService() {
		return logService;
	}

	@Resource(name="logService")
	public void setLogService(LogService logService) {
		this.logService = logService;
	}

	public List<Reslog> getLogList() {
		return logList;
	}

	public void setLogList(List<Reslog> logList) {
		this.logList = logList;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	/**
	 * 日志列表方法
	 * @return
	 */
	public String logList() {
		try {
			int size = 10; // 单页记录条数

			int num = 1;// 当前页数

			int rowCount = 0;// 记录总数

			if (str_num != null && !"".equals(str_num)) {
				num = Integer.parseInt(str_num);
			}

			if (null != this.str_size && !"".equals(this.str_size)) {
				size = Integer.parseInt(this.str_size);
			}

			List<Param> params = new ArrayList<Param>();
			
			Map<String, String> orderMap = new HashMap<String, String>();
			
			orderMap.put("createTime", "desc");//按createTime升序排列

			if (userName != null && !"".equals(userName)) {
				Param param1 = new Param("userId.userName","like", userName.trim());
				params.add(param1);
			}
			
			if (logType != null && !"".equals(logType)) {
				Param param2 = new Param("type","=", logType);
				params.add(param2);
			}
			
			
			String[] objectMap = {"userId"};

			rowCount = (Integer) logService.getCollection("Reslog", params, orderMap, 0, 0,objectMap);

			Page page = new Page(size, num, rowCount);

			this.setPage(page);

			logList = (List<Reslog>) logService.getCollection("Reslog", params, orderMap, page.getStartRow(),page.getSize(), objectMap);

			return "log_list";
		} catch (Exception e) {
			Loggers.error("------LogAction类logList方法错误："+ e.getMessage());
			e.printStackTrace();
		}
		return ERROR;
	}
	
	
}
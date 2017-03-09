package com.xinhua.util.filter;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class DeclareFilter extends AbstractInterceptor {
	
private static final long serialVersionUID = 1L;
	
	private String tip;
	
	public String getTip() {
		return tip;
	}
	
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
/*		UnitInfo user = (UnitInfo) session.getAttribute(Util.SECCION_CLIENT_USER);
		if (user == null) {
			this.setTip("您长时间没有操作，请重新登录！");
			return "logout";
		} else {
			return invocation.invoke();
		}*/
		return invocation.invoke();
	}
}

package com.xinhua.util.filter;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.xinhua.util.ContextPvd;

public class ManagerFilter extends AbstractInterceptor {
	
private static final long serialVersionUID = 1L;
	
	private String tip;
	private ContextPvd contextPvd;
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public ContextPvd getContextPvd() {
		return contextPvd;
	}
	public void setContextPvd(ContextPvd contextPvd) {
		this.contextPvd = contextPvd;
	}
	
	public String intercept(ActionInvocation invocation) throws Exception {
		return null;
	}
	public String logOut(){
		
		return "";
	}
	
}

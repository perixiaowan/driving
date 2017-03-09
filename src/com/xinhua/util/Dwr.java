package com.xinhua.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
* interfacename:ContextPvd
* Version information:1.1
* Date:2012-05-14 13:41
* Creator:
*/

public class Dwr{
	/**
	 * 获取上下文环境
	 * @return
	 */
	private WebContext getWebContext() {
		return WebContextFactory.get();
	}
	
	/**
	 * 获取session
	 * @return
	 */
	public HttpSession getSession() {
		return getWebContext().getSession();
	}
	
	/**
	 * 获取Request
	 * @return
	 */
	public HttpServletRequest getHttpServletRequest() {
		return getWebContext().getHttpServletRequest();
	}
	
	/**
	 * 获取Response
	 * @return
	 */
	public HttpServletResponse getHttpServletResponse() {
		return getWebContext().getHttpServletResponse();
	}
	
	/**
	 * 写入sesion
	 * @param name
	 * @param objct
	 */
	public void setSession(String name,Object objct){
		getSession().setAttribute(name, objct);
	}
	
	/**
	 * 写入清除sesion
	 * @param name
	 */
	public void deleteSession(String name){
		getSession().removeAttribute(name);
	}
	
	/**
	 * 获取 getApplicationContext
	 * @return
	 */
	public ApplicationContext getApplicationContext(){
		return WebApplicationContextUtils.getWebApplicationContext(getWebContext().getServletContext());
	}
	
	/**
	 * 获取 spring 注入
	 * @param key
	 * @return
	 */
	public Object getBean(String key){
		return getApplicationContext().getBean(key);
	}
}
package com.xinhua.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Repository;

import com.xinhua.manage.system.user.model.TDrivingUser;



/**
* interfacename:ContextPvdImpl
* Version information:1.1
* Date:2012-05-14 11:27
* Creator:liuyanan
*/

@SuppressWarnings("all")
@Repository("contextPvd")
public class ContextPvdImpl implements ContextPvd {
	
	/**
	 * 获得系统绝对路径 如：F:\webapps\CmsSys
	 * @param path	可以传入空串
	 * @return
	 */
	public String getAppRealPath(String path) {
		return ServletActionContext.getServletContext().getRealPath(path);
	}

	/**
	 * 获得应用绝对根路径
	 * @return
	 */
	public String getAppRoot() {
		return getAppRealPath("/");
	}

	/**
	 * 获得系统根路径 如：/CmsSys
	 * @return
	 */
	public String getAppCxtPath() {
		return ServletActionContext.getRequest().getContextPath();
	}

	/**
	 * 获得应用端口号
	 * @return
	 */
	public int getServerPort() {
		return ServletActionContext.getRequest().getServerPort();
	}

	/**
	 * 退出
	 * @return
	 */
	public void logout() {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}

	/**
	 * 获得访问者IP
	 * @return
	 */
	public String getRemoteIp() {
		return ServletActionContext.getRequest().getRemoteAddr();
	}
	
	/**
	 * 获得访问者端口
	 * @return
	 */
	public int getRemotePort() {
		return ServletActionContext.getRequest().getRemotePort();
	}
	
	/**
	 * 获得访问者URL
	 * @return
	 */
	public String getRequestURL() {
		return ServletActionContext.getRequest().getRequestURL().toString();
	}

	/**
	 * 获得访问者浏览器
	 * @return
	 */
	public String getRequestBrowser() {
		String userAgent = getRequestUserAgent();
		String[] agents = userAgent.split(";");
		if (agents.length > 1) {
			return agents[1].trim();
		} else {
			return null;
		}
	}

	/**
	 * 获得访问者操作系统
	 * @return
	 */
	public String getRequestOs() {
		String userAgent = getRequestUserAgent();
		String[] agents = userAgent.split(";");
		if (agents.length > 2) {
			return agents[2].trim();
		} else {
			return null;
		}
	}
	
	/**
	 * 从Request的Attribute中获取值
	 * @param key
	 * @return
	 */
	public Object getRequestAttr(String key) {
		return ServletActionContext.getRequest().getAttribute(key);
	}
	
	/**
	 * 设置Request的Attribute值
	 * @param key
	 * @param value
	 * @return
	 */
	public void setRequestAttr(String key, Object value) {
		ServletActionContext.getRequest().setAttribute(key, value);
	}
	
	/**
	 * 从session中获得值
	 * @param key
	 * @return
	 */
	public Object getSessionAttr(String key) {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		if (session == null) {
			return null;
		} else {
			return session.getAttribute(key);
		}
	}
	
	/**
	 * 给session赋值
	 * @param key
	 * @param value
	 */
	public void setSessionAttr(String key, Object value) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute(key, value);
	}	
	
	/**
	 * 移除session中的属性
	 * @param key
	 */
	public void removeAttribute(String key) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute(key);
	}
	
	/**
	 * 获得Session
	 * @return
	 */
	public HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}
	
	/**
	 * 获得response
	 * @return
	 */
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	/**
	 * 获得Request
	 * @return
	 */
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
	
	/**
	 * 从Request的Parameter中获取值
	 * @param key
	 * @return
	 */
	public Object getRequestParm(String key) {
		return ServletActionContext.getRequest().getParameter(key);
	}
	
	/**
	 * 从Request的ParameterValues中获取值
	 * @param key
	 * @return
	 */
	public Object[] getRequestparms(String key) {
		return ServletActionContext.getRequest().getParameterValues(key);
	}
	
	/**
	 * 移除session中的属性
	 * @param key
	 */
	public Object getApplicationAttr(String key) {
		return ServletActionContext.getServletContext().getAttribute(key);
	}

	public void setApplicationAttr(String key, Object value) {
		ServletActionContext.getServletContext().setAttribute(key, value);
	}

	/**
	 * 获得访问者的代理全部信息
	 * @return
	 */
	public String getRequestUserAgent() {
		HttpServletRequest req = ServletActionContext.getRequest();
		String userAgent = req.getHeader("user-agent");
		return userAgent;
	}

	/**
	 * 添加cookie
	 * @param cookie
	 */
	public void addCookie(Cookie cookie) {
		ServletActionContext.getResponse().addCookie(cookie);
	}

	/**
	 * 获取cookie
	 * @param name
	 * @return
	 */
	public Cookie getCookie(String name) {
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals(name)) {
					return c;
				}
			}
		}
		return null;
	}
	
	/**
	 * 是否是post请求
	 * @return
	 */
	public boolean isMethodPost() {
		String method = ServletActionContext.getRequest().getMethod();
		if ("post".equalsIgnoreCase(method)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 是否为linux操作系统
	 */
	public boolean isLinux() {
		String userAgent = System.getProperty("os.name");
		if(userAgent.indexOf("Win")>-1 || userAgent.indexOf("win")>-1){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 编码
	 * @param keyword
	 * @return
	 */
	public String encode(String keyword){
		try {
			if(keyword != null && !"".equals(keyword)){
				return URLEncoder.encode(keyword, "UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			Loggers.error("ContextPvdImpl：public String encode(String keyword)编码异常!"+e);
		}
		return null;
	}
	
	/**
	 * 解码
	 * @param keyword
	 * @return
	 */
	public String decode(String keyword){
		try {
			if(keyword != null && !"".equals(keyword)){
				String temp = new String(keyword.getBytes("ISO-8859-1"),"UTF-8");
				keyword = URLDecoder.decode(temp, "UTF-8");
				return keyword;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			Loggers.error("ContextPvdImpl：public String decode(String keyword)解码异常!"+e);
		}
		return null;
	}
	
	/**
	 * 先解码再编码
	 * @param keyword
	 * @return
	 */
	public String decodeAndEncode(String keyword){
		try {
			if(keyword != null && !"".equals(keyword)){
				String temp = new String(keyword.getBytes("ISO-8859-1"),"UTF-8");
				keyword = URLDecoder.decode(temp, "UTF-8");
				return URLEncoder.encode(keyword, "UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			Loggers.error("ContextPvdImpl：public String decode(String keyword)解码异常!"+e);
		}
		return null;
	}
	
	/**
	 * 获得用户id
	 * @param key
	 * @return
	 */
	public int getSessionId(String key) {
		HttpSession session = ServletActionContext.getRequest().getSession(false);
		TDrivingUser user = (TDrivingUser) session.getAttribute(key);
		if(user != null){
			return user.getId();
		}else{
			return 0;
		}
	}
}

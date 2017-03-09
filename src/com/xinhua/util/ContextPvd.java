package com.xinhua.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
* interfacename:ContextPvd
* Version information:1.1
* Date:2012-05-14 11:10
* Creator:liuyanan
*/

public interface ContextPvd {
	
	/**
	 * 获得系统绝对路径 如：F:\webapps\CmsSys
	 * @param path	可以传入空串
	 * @return
	 */
	public String getAppRealPath(String path);

	/**
	 * 获得应用绝对根路径
	 * @return
	 */
	public String getAppRoot();

	/**
	 * 获得系统根路径 如：/CmsSys
	 * @return
	 */
	public String getAppCxtPath();

	/**
	 * 获得应用端口号
	 * @return
	 */
	public int getServerPort();
	
	/**
	 * 退出
	 * @return
	 */
	public void logout();
	
	/**
	 * 获得访问者IP
	 * @return
	 */
	public String getRemoteIp();

	/**
	 * 获得访问者端口
	 * @return
	 */
	public int getRemotePort();

	/**
	 * 获得访问者URL
	 * @return
	 */
	public String getRequestURL();

	/**
	 * 获得访问者浏览器
	 * @return
	 */
	public String getRequestBrowser();

	/**
	 * 获得访问者操作系统
	 * @return
	 */
	public String getRequestOs();

	/**
	 * 从Request的Attribute中获取值
	 * @param key
	 * @return
	 */
	public Object getRequestAttr(String key);
	
	/**
	 * 设置Request的Attribute值
	 * @param key
	 * @param value
	 * @return
	 */
	public void setRequestAttr(String key, Object value);
	
	/**
	 * 从session中获得值
	 * @param key
	 * @return
	 */
	public Object getSessionAttr(String key);
	
	
	/**
	 * 获得用户id
	 * @param key
	 * @return
	 */
	public int getSessionId(String key);
	
	
	
	/**
	 * 给session赋值
	 * @param key
	 * @param value
	 */
	public void setSessionAttr(String key, Object value);

	/**
	 * 移除session中的属性
	 * @param key
	 */
	public void removeAttribute(String key);
	
	/**
	 * 获得Session
	 * @return
	 */
	public HttpSession getSession();
	
	/**
	 * 获得response
	 * @return
	 */
	public HttpServletResponse getResponse();
	
	/**
	 * 获得Request
	 * @return
	 */
	public HttpServletRequest getRequest();

	/**
	 * 从Request的Parameter中获取值
	 * @param key
	 * @return
	 */
	public Object getRequestParm(String key);
	
	/**
	 * 从Request的ParameterValues中获取值
	 * @param key
	 * @return
	 */
	public Object[] getRequestparms(String key);
	
	/**
	 * 移除session中的属性
	 * @param key
	 */
	public Object getApplicationAttr(String key);

	public void setApplicationAttr(String key, Object value);

	/**
	 * 获得访问者的代理全部信息
	 * @return
	 */
	public String getRequestUserAgent();

	/**
	 * 添加cookie
	 * @param cookie
	 */
	public void addCookie(Cookie cookie);

	/**
	 * 获取cookie
	 * @param name
	 * @return
	 */
	public Cookie getCookie(String name);

	/**
	 * 是否是post请求
	 * @return
	 */
	public boolean isMethodPost();
	
	/**
	 * 是否为linux操作系统
	 */
	public boolean isLinux();	
	
	/**
	 * 编码
	 * @param keyword
	 * @return
	 */
	public String encode(String keyword);
		
	/**
	 * 解码
	 * @param keyword
	 * @return
	 */
	public String decode(String keyword);
	
	/**
	 * 先解码再编码
	 * @param keyword
	 * @return
	 */
	public String decodeAndEncode(String keyword);
}

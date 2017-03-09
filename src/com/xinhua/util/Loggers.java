package com.xinhua.util;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;

/**
* interfacename:ContextPvd
* Version information:1.1
* Date:2012-05-14 13:53
* Creator:liuyanan
*/
public final class Loggers {
	private final static Logger logger = Logger.getRootLogger();
	
	private final static Logger loggerDB = Logger.getLogger("reslog");
	
	public static void info(Object obj){
		logger.info(obj);
	}
	public static void debug(Object obj){
		logger.debug(obj);
	}
	public static void error(Object obj){
		logger.error(obj);
	}
	public static void warn(Object obj){
		logger.warn(obj);
	}
	
	/**
	 * 添加日志到数据库
	 * @param message
	 * @param userId 操作用户id
	 * @param typeId 操作类型编码
	 */
	public static void logToDB(String message, Integer userId, Integer typeId) {
		MDC.put("userId",userId);
		MDC.put("typeId",typeId);
		loggerDB.info(message);
	}
}

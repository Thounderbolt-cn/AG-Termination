package com.aplus.gaming.web.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtil {

	private static Logger objLog;

	private LoggerUtil() {
	}

	// 信息内容
	public static void info(String message, Exception exception) {
		getLogger().info(message, exception);
	}

	// 信息内容
	public static void error(String message, Exception exception) {
		getLogger().error(message, exception);
	}

	public static void info(Object message) {
		getLogger().info(message+"");
	}
	
	public static void error(Object message) {
		getLogger().error( message+"");
	}

//	public static void log(String level, Object msg) {
//		getLogger().error(level, msg, null);
//	}

	private static Logger getLogger() {
		if (objLog == null) {
			objLog = LoggerFactory.getLogger(LoggerUtil.class);
		}
		return objLog;
	}

}
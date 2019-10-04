package com.aplus.gaming.web.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class FileConfig {

	private static final Logger logger = LoggerFactory.getLogger(FileConfig.class);
	
	private String filePath = "system.config";
	
	private Map<String, String> configs = new HashMap<String, String>();
	
	/**
	 * see the {@link #filePath}
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	@SuppressWarnings("unchecked")
	public FileConfig() {
		
		Properties pps = new Properties();
		try {
			pps.load(this.getClass().getClassLoader().getResourceAsStream(filePath));
			Enumeration enum1 = pps.propertyNames();
			while (enum1.hasMoreElements()) {
				String strKey = (String) enum1.nextElement();
				String strValue = pps.getProperty(strKey);
				logger.info("init : "+strKey + "=" + strValue);
				configs.put(strKey, strValue);
			}
		} catch(Exception e) {
			logger.error(e.getMessage());
			for (StackTraceElement ste : e.getStackTrace()) {
				logger.error("\tat "+ste);
			}
		}
	}
	
	public String get(String key) {
		return configs.get(key);
	}

	public Map<String, String> allConfigs() {
		return configs;
	}
	
	public synchronized void set(String key, String val) {
		configs.put(key, val);
	}
	
	/**
	 *
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public boolean getBooleanProperty(final String key, final boolean defaultValue) {
		String value = get(key);

		if (null != value) {
			return "true".equalsIgnoreCase(value)
					|| "on".equalsIgnoreCase(value)
					|| "yes".equalsIgnoreCase(value)
					|| "1".equalsIgnoreCase(value);
		} else {
			return defaultValue;
		}
	}


	/**
	 *
	 * @param key
	 * @return
	 */
	public boolean getBooleanProperty(final String key) {
		return getBooleanProperty(key, false);
	}

}

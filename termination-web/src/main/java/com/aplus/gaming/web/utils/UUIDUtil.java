package com.aplus.gaming.web.utils;

import java.util.UUID;

/**
 * UUID工具
 * @author 张呈彬
 * 
 */
public class UUIDUtil {

	/**
	 * 生成UUID 32位 小写
	 * @return
	 */
	public static String uuid(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}

/**
 * Copyright (c) 2011-2014, hubin (jobob@qq.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.aplus.gaming.web.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Formatter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MD5 {

	public static final Logger LOGGER = LoggerFactory.getLogger(MD5.class);

	private MD5() {
	}

	/**
	 * @Description 字符串加密为MD5 中文加密一致通用,必须转码处理： plainText.getBytes("UTF-8")
	 * @param plainText
	 *            需要加密的字符串
	 * @return
	 */
	public static String toMD5(String plainText) {
		StringBuilder rlt = new StringBuilder();
		try {
			rlt.append(md5String(plainText.getBytes("UTF-8")));
		} catch (UnsupportedEncodingException e) {
			LOGGER.error(" CipherHelper toMD5 exception.",e);
		}
		return rlt.toString();
	}

	/**
	 * MD5 参数签名生成算法
	 * 
	 * @param HashMap<String,String>
	 *            params 请求参数集，所有参数必须已转换为字符串类型
	 * @param String
	 *            secret 签名密钥
	 * @return 签名
	 * @throws IOException
	 */
	public static String getSignature(Map<String, String> params, String secret) {
		Map<String, String> sortedParams = new TreeMap<>(params);
		Set<Entry<String, String>> entrys = sortedParams.entrySet();
		StringBuilder basestring = new StringBuilder();
		for (Entry<String, String> param : entrys) {
			basestring.append(param.getKey()).append("=").append(param.getValue());
		}
		return getSignature(basestring.toString(), secret);
	}

	/**
	 * MD5 参数签名生成算法
	 * 
	 * @param String
	 *            sigstr 签名字符串
	 * @param String
	 *            secret 签名密钥
	 * @return 签名
	 * @throws IOException
	 */
	public static String getSignature(String sigstr, String secret) {
		StringBuilder basestring = new StringBuilder(sigstr);
		basestring.append("#");
		basestring.append(toMD5(secret));
		return toMD5(basestring.toString());
	}

	public static byte[] md5Raw(byte[] data) {
		byte[] md5buf = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("md5");
			md5buf = md5.digest(data);
		} catch (Exception e) {
			md5buf = null;
			LOGGER.error("md5Raw error.",e);
		}
		return md5buf;
	}

	public static String md5String(byte[] data) {
		String md5Str = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("md5");
			md5Str = "";
			byte[] buf = md5.digest(data);
			for (int i = 0; i < buf.length; i++) {
				md5Str += byte2Hex(buf[i]);
			}
		} catch (Exception e) {
			md5Str = null;
			LOGGER.error("md5String error.",e);
		}
		return md5Str;
	}

	public static String byte2Hex(byte b) {
		String hex = Integer.toHexString(b);
		if (hex.length() > 2) {
			hex = hex.substring(hex.length() - 2);
		}
		while (hex.length() < 2) {
			hex = "0" + hex;
		}
		return hex;
	}

	public static String byte2Hex(byte[] bytes) {
		Formatter formatter = new Formatter();
		for (byte b : bytes) {
			formatter.format("%02x", b);
		}
		String hash = formatter.toString();
		formatter.close();
		return hash;
	}
}

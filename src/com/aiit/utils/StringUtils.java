package com.aiit.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串处理类
 * 
 * @author icelo
 *
 */

public class StringUtils {

	/**
	 * 判断为空函数
	 * 
	 * @param str 传入判断字符
	 * @return 判断结果
	 */
	public static boolean isEmpty(String str) {

		if (str == null || str.trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 手机号验证
	 * @param str 
	 * @return
	 */

	public static boolean isMobile(String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
		m = p.matcher(str);
		b = m.matches();
		return b;
	}
	
	/**
	 * 年龄验证
	 * @param str
	 * @return
	 */
	public static boolean isAge(String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^(?:[1-9][0-9]?|1[01][0-9]|120)$"); // 验证年龄在0-120之间
		m = p.matcher(str);
		b = m.matches();
		return b;
	}
	/*
	 * 密码验证
	 */
	public static boolean isPassword(String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$"); // 验证密码（6-16位数字和字母的组合）
		m = p.matcher(str);
		b = m.matches();
		return b;
	}
	/**
	 * 用户名验证
	 * @param str
	 * @return
	 */
	public static boolean isUsername(String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^\\w+$"); // 用户名使用纯字母，且不能重复
		m = p.matcher(str);
		b = m.matches();
		return b;
	}
}

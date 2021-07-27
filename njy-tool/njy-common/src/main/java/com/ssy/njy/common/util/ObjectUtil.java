package com.ssy.njy.common.util;

import org.springframework.lang.Nullable;

/**
 * 对象工具类
 * @author: mqxu
 * @date: 2021-07-26
 */
public class ObjectUtil extends org.springframework.util.ObjectUtils {

	/**
	 * 判断元素不为空
	 * @param obj object
	 * @return boolean
	 */
	public static boolean isNotEmpty(@Nullable Object obj) {
		return !ObjectUtil.isEmpty(obj);
	}

}

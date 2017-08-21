/*
 * Copyright 2017 licensed to mbpsoft Co, Ltd;
 * You may not use this file except in compliance with the 'License' from mbpsoft company
 * Please contact at info@mbpsoft.com
 */
package com.microservice.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.BeanUtils;

import net.sf.cglib.beans.BeanCopier;

/**
 * bean拷贝 - Util类
 * 
 * @author MBP.Jagger
 * 
 */
public class BeanCopyUtil {

	private static final Map<String, BeanCopier> beanCopierCache = new ConcurrentHashMap<>();

	/**
	 * 拷贝bean属性到Dto
	 * 
	 * @param source
	 * @param targetClass
	 * @return
	 */
	public static <T> T copyProperties2Dto(Object source, Class<T> targetClass) {

		T target = null;
		try {
			target = targetClass.newInstance();
			if (source != null) {
				BeanUtils.copyProperties(source, target);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return target;
	}

	/**
	 * 拷贝bean属性到Dto
	 * 
	 * @param source
	 * @param targetClass
	 * @param ignoreProperties
	 *            需要忽略的属性
	 * @return
	 */
	public static <T> T copyProperties2Dto(Object source, Class<T> targetClass, String... ignoreProperties) {

		T target = null;
		try {
			target = targetClass.newInstance();
			if (source != null) {
				BeanUtils.copyProperties(source, target, ignoreProperties);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return target;
	}

	/**
	 * 拷贝集合属性到Dto
	 * 
	 * @param sourceList
	 * @param targetClass
	 * @return
	 */
	public static <T> List<T> copyPropertiesOfList2Dto(List<?> sourceList, Class<T> targetClass) {
		if (sourceList == null || sourceList.size() == 0) {
			return Collections.emptyList();
		}
		List<T> resultList = new ArrayList<>(sourceList.size());
		for (Object o : sourceList) {
			T t = null;
			try {
				t = targetClass.newInstance();
				BeanUtils.copyProperties(o, t);
				resultList.add(t);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return resultList;
	}

	/**
	 * 拷贝集合属性到Dto
	 * 
	 * @param sourceList
	 * @param targetClass
	 * @param ignoreProperties
	 *            需要忽略的属性
	 * @return
	 */
	public static <T> List<T> copyPropertiesOfList2Dto(List<?> sourceList, Class<T> targetClass, String... ignoreProperties) {
		if (sourceList == null || sourceList.size() == 0) {
			return Collections.emptyList();
		}
		List<T> resultList = new ArrayList<>(sourceList.size());
		for (Object o : sourceList) {
			T t = null;
			try {
				t = targetClass.newInstance();
				BeanUtils.copyProperties(o, t, ignoreProperties);
				resultList.add(t);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return resultList;
	}

	/**
	 * 拷贝bean属性
	 * 
	 * @param source
	 * @param targetClass
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public static <T> T copyProperties(Object source, Class<T> targetClass) {

		T target = null;
		try {
			target = targetClass.newInstance();
			if (source != null) {
				copyProperties(source, target);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return target;
	}

	/**
	 * 拷贝集合属性
	 * 
	 * @param sourceList
	 * @param targetClass
	 * @return
	 */
	public static <T> List<T> copyPropertiesOfList(List<?> sourceList, Class<T> targetClass) {
		if (sourceList == null || sourceList.size() == 0) {
			return Collections.emptyList();
		}
		List<T> resultList = new ArrayList<>(sourceList.size());
		for (Object o : sourceList) {
			T t = null;
			try {
				t = targetClass.newInstance();
				copyProperties(o, t);
				resultList.add(t);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return resultList;
	}

	public static void copyProperties(Object source, Object target) {
		BeanCopier copier = getBeanCopier(source.getClass(), target.getClass());
		copier.copy(source, target, null);
	}

	private static BeanCopier getBeanCopier(Class<?> sourceClass, Class<?> targetClass) {
		String beanKey = generateKey(sourceClass, targetClass);
		BeanCopier copier = null;
		if (!beanCopierCache.containsKey(beanKey)) {
			copier = BeanCopier.create(sourceClass, targetClass, false);
			beanCopierCache.put(beanKey, copier);
		} else {
			copier = beanCopierCache.get(beanKey);
		}
		return copier;
	}

	private static String generateKey(Class<?> class1, Class<?> class2) {
		return class1.toString() + class2.toString();
	}
}

package com.daxie.daxie_api.core;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * BeanUtils用于属性拷贝
 */
public final class BeanUtils {

	private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

	/**
	 * 需要忽略的包名
	 */
	private static final String ignoredPackage = "com.ibm.topscore";

	/**
	 * Bean属性拷贝，适合用于拷贝至空的对象.
	 *
	 * @param source
	 *            源对象
	 * @param target
	 *            目标对象
	 */
//	public static void copyProperties(Object source, Object target) {
//		if (source != null) {
//			try {
//				org.apache.commons.beanutils.BeanUtils.copyProperties(target, source);
//			} catch (IllegalAccessException | InvocationTargetException e) {
//				logger.error(e.getMessage());
//			}
//		}
//	}

	/**
	 * 复制JavaBean对象中的对应属性值,
	 * 
	 * 当属性为下列情况时，不进行copy:
	 * <p>
	 * 1. 当该属性为 java.util 包下面的引用 2. 当该属性为 com.ibm.topscore 包下面的引用 3. 当该属性为
	 * Collection 接口的实现类的引用 4. 当该属性为 hashCode、serialVersionUID
	 * <p>
	 * 注: 复杂对象请使用dozer进行对应的属性对应设置
	 * 
	 * @param source
	 * @param target
	 */
//	public static void copyPropertiesExcludeSpecialObject(Object source, Object target) {
//
//		Field[] fields = target.getClass().getDeclaredFields();
//		Field[] sourceFile = source.getClass().getDeclaredFields();
//		List<String> sourceFiledNameList = new ArrayList<String>();
//		for (int i = 0; i < sourceFile.length; i++) {
//			String sourcefiledName = sourceFile[i].getName();
//			sourceFiledNameList.add(sourcefiledName);
//		}
//
//		for (int i = 0; i < fields.length; i++) {
//			try {
//				String fieldName = fields[i].getName();
//				if (!sourceFiledNameList.contains(fieldName)) {
//					continue;
//				}
//				Class<?> clazzType = fields[i].getType();
//				Package packageType = clazzType.getPackage();
//				Object fo = ReflectionUtils.getFieldValue(target, fieldName);
//				char firstWord = fieldName.charAt(0);
//
//				if (!(fo instanceof Collection) && null != packageType && Character.isLowerCase(firstWord)
//						&& !fieldName.equals("hashCode") && !fieldName.equals("serialVersionUID")
//						&& !StringUtils.startsWith(packageType.getName(), ignoredPackage)
//						&& !StringUtils.startsWith(packageType.getName(), "java.util")) {
//
//					String setMethodName = "set" + String.valueOf(firstWord).toUpperCase()
//							+ fieldName.substring(1, fieldName.length());
//					String getMethodName = "get" + String.valueOf(firstWord).toUpperCase()
//							+ fieldName.substring(1, fieldName.length());
//
//					Method getMethod = source.getClass().getMethod(getMethodName, new Class[] {});
//					if (getMethod != null) {
//						Object getValue = getMethod.invoke(source, new Object[] {});
//						if (getValue != null && getMethod.getReturnType() != null) {
//							Method setMethod = target.getClass().getMethod(setMethodName,
//									new Class[] { getMethod.getReturnType() });
//							if (setMethod != null) {
//								setMethod.invoke(target, new Object[] { getValue });
//							}
//						}
//					}
//				}
//			} catch (Exception e) {
//				logger.error("TopScoreBeanUtils, copyPropertiesLessToMoreAndExcludeObjAndNull", e.getMessage());
//			}
//		}
//	}

	/**
	 * Bean属性拷贝，不拷贝值为空的属性.
	 * 
	 * 当属性为下列情况时，不进行copy:
	 * <p>
	 * 1. 当该属性为 hashCode、serialVersionUID
	 * <p>
	 * 
	 * 注: 不支持复杂多级bean对象的Copy 复杂对象请使用dozer进行对应的属性对应设置
	 *
	 * @param source
	 * @param target
	 */
	public static void copyPropertiesNotNull(Object source, Object target) {
		Field[] fileds = target.getClass().getDeclaredFields();
		for (int i = 0; i < fileds.length; i++) {
			try {
				String filedName = fileds[i].getName();
				char firstWord = filedName.charAt(0);
				if (Character.isLowerCase(firstWord) && !filedName.equals("hashCode")
						&& !filedName.equals("serialVersionUID")) {

					String setMethodName = "set" + String.valueOf(firstWord).toUpperCase()
							+ filedName.substring(1, filedName.length());
					String getMethodName = "get" + String.valueOf(firstWord).toUpperCase()
							+ filedName.substring(1, filedName.length());
					Method getMethod = source.getClass().getMethod(getMethodName, new Class[] {});
					if (getMethod != null) {
						Object getValue = getMethod.invoke(source, new Object[] {});
						if (getValue != null && getMethod.getReturnType() != null) {
							Method setMethod = target.getClass().getMethod(setMethodName,
									new Class[] { getMethod.getReturnType() });
							if (setMethod != null) {
								setMethod.invoke(target, new Object[] { getValue });
							}
						}
					}
				}
			} catch (Exception e) {
				logger.error("TopScoreBeanUtils, copyPropertiesNoID", e.getMessage());
			}
		}
	}

	/**
	 * Bean属性拷贝，不拷贝"id"成员变量，适合用于拷贝至非空的对象.
	 *
	 * @param source
	 * @param target
	 */
	public static void copyPropertiesNoID(Object source, Object target) {
		Field[] fileds = target.getClass().getDeclaredFields();
		for (int i = 0; i < fileds.length; i++) {
			try {
				String filedName = fileds[i].getName();
				char firstWord = filedName.charAt(0);
				if (Character.isLowerCase(firstWord) && !filedName.equals("id")
						&& !filedName.equals("hashCode") && !filedName.equals("serialVersionUID")) {

					String setMethodName = "set" + String.valueOf(firstWord).toUpperCase()
							+ filedName.substring(1, filedName.length());
					String getMethodName = "get" + String.valueOf(firstWord).toUpperCase()
							+ filedName.substring(1, filedName.length());
					Method getMethod = source.getClass().getMethod(getMethodName, new Class[] {});
					if (getMethod != null) {
						Object getValue = getMethod.invoke(source, new Object[] {});
						if (getValue != null && getMethod.getReturnType() != null) {
							Method setMethod = target.getClass().getMethod(setMethodName,
									new Class[] { getMethod.getReturnType() });
							if (setMethod != null) {
								setMethod.invoke(target, new Object[] { getValue });
							}
						}
					}
				}
			} catch (Exception e) {
				logger.error("TopScoreBeanUtils, copyPropertiesNoID", e.getMessage());
			}
		}
	}

	/**
	 * Bean属性拷贝，不拷贝值为空的属性， 适合用于拷贝至非空的对象.
	 * 
	 * 当属性为下列情况时，不进行copy:
	 * <p>
	 * 当该属性为 id、hashCode、serialVersionUID
	 * <p>
	 * 
	 * 注: 不支持复杂多级bean对象的Copy 复杂对象请使用dozer进行对应的属性对应设置
	 *
	 * @param source
	 * @param target
	 */
	public static void copyPropertiesLessToMore(Object source, Object target) {

		Field[] fileds = target.getClass().getDeclaredFields();
		Field[] sourceFile = source.getClass().getDeclaredFields();
		List<String> sourceFiledNameList = new ArrayList<String>();
		for (int i = 0; i < sourceFile.length; i++) {
			String sourcefiledName = sourceFile[i].getName();
			sourceFiledNameList.add(sourcefiledName);
		}
		for (int i = 0; i < fileds.length; i++) {
			try {
				String filedName = fileds[i].getName();
				if (!sourceFiledNameList.contains(filedName)) {
					continue;
				}

				char firstWord = filedName.charAt(0);
				if (Character.isLowerCase(firstWord) && !filedName.equals("id")
						&& !filedName.equals("hashCode") && !filedName.equals("serialVersionUID")) {

					String setMethodName = "set" + String.valueOf(firstWord).toUpperCase()
							+ filedName.substring(1, filedName.length());
					String getMethodName = "get" + String.valueOf(firstWord).toUpperCase()
							+ filedName.substring(1, filedName.length());
					Method getMethod = source.getClass().getMethod(getMethodName, new Class[] {});
					if (getMethod != null) {
						Object getValue = getMethod.invoke(source, new Object[] {});
						if (getValue != null && getMethod.getReturnType() != null) {
							Method setMethod = target.getClass().getMethod(setMethodName,
									new Class[] { getMethod.getReturnType() });
							if (setMethod != null) {
								setMethod.invoke(target, new Object[] { getValue });
							}
						}
					}
				}
			} catch (Exception e) {
				logger.error("TopScoreBeanUtils, copyPropertiesLessToMore", e.getMessage());
			}
		}
	}

	/**
	 * 将Map集合转化为JavaBean
	 * 
	 * @param type,
	 *            JavaBean的类型
	 * @param map
	 *            原始的Map集合
	 * @return JavaBean 转化后的结果
	 */
	public static final <T> T toBean(Class<T> type, Map<String, ? extends Object> map) {

		if (map == null || map.size() == 0) {
			return null;
		}
		T obj = null;
		try {
			obj = type.newInstance();
			BeanInfo beanInfo = Introspector.getBeanInfo(type);
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor descriptor : propertyDescriptors) {
				String propertyName = descriptor.getName();
				if (map.containsKey(propertyName)) {
					Object value = map.get(propertyName);
					if (value instanceof Integer) {
						value = Long.valueOf(String.valueOf(value));
					}
					Object[] args = new Object[1];
					args[0] = value;
					descriptor.getWriteMethod().invoke(obj, args);
				}
			}
		} catch (IntrospectionException | IllegalAccessException | InstantiationException
				| InvocationTargetException e) {
			logger.error("BeanMapUtils MapToBean", e.getMessage());
			return obj;
		}
		return obj;
	}

	/**
	 * 将JavaBean转化为Map
	 * 
	 * @param bean,
	 *            原始的 javabean
	 * @param ignoreEmptyParameter;
	 *            是否忽略空值
	 * @return map, 结果Map集合
	 */
	public static final Map<String, Object> toMap(Object bean, boolean ignoreEmptyParameter) {

		Map<String, Object> returnMap = Maps.newHashMap();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

			for (PropertyDescriptor descriptor : propertyDescriptors) {
				String propertyName = descriptor.getName();
				if (StringUtils.equals(propertyName, "class")) {
					continue;
				}
				Method readMethod = descriptor.getReadMethod();
				Object result = readMethod.invoke(bean, new Object[0]);
				if (result != null) {
					returnMap.put(propertyName, result);
				} else if (!ignoreEmptyParameter) {
					returnMap.put(propertyName, "");
				}
			}
		} catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
			logger.error("BeanMapUtils,  BeanToMap", e.getMessage());
			return returnMap;
		}
		return returnMap;
	}
	/**
	 * 
	 * @param beanfieldName_ColumnMap bean的数据库字段对应map
	 * @param bean bean
	 * @param ignoreEmptyParameter 忽略字段
	 * @return
	 */
	public static final Map<String, Object> beanToColumnMap(Map<String, String> beanfieldName_ColumnMap, Object bean, boolean ignoreEmptyParameter) {
		Map<String, Object> columnMap = new HashMap<String, Object>();
		Map<String, Object> beanMap = toMap(bean, ignoreEmptyParameter);
		for (Map.Entry<String, Object> keyValue : beanMap.entrySet()) {
			if(beanfieldName_ColumnMap.containsKey(keyValue.getKey())){
				columnMap.put(beanfieldName_ColumnMap.get(keyValue.getKey()), keyValue.getValue());
			}
		}
		return columnMap;
	}

	/**
	 * 容器中对象转换为定义类
	 * 
	 * @param <E>
	 *
	 * @param sourceCollection
	 * @param clazz
	 * @return
	 */
//	public static <T> Collection<T> collectionCopyBeanSwitch(Collection<?> sourceCollection, Class<T> clazz) {
//
//		if (null == sourceCollection) {
//			return Collections.emptyList();
//		}
//		List<T> targetList = Lists.newArrayList();
//		try {
//			for (Object source : sourceCollection) {
//				if (source == null)
//					continue;
//				T target = clazz.newInstance();
//				BeanUtils.copyProperties(source, target);
//				targetList.add(target);
//			}
//		} catch (Exception e) {
//			logger.error("TopScoreBeanUtils, collectionPoVoSwitchNoID", e.getMessage());
//		}
//		return targetList;
//	}

	/**
	 * 容器中对象转换为定义类,不拷贝ID
	 * 
	 * @param sourceCollection
	 * @param clazz
	 * @return
	 */
	public static <T> Collection<T> collectionCopyBeanNoID(Collection<?> sourceCollection, Class<T> clazz) {

		if (null == sourceCollection) {
			return Collections.emptyList();
		}
		List<T> targetList = Lists.newArrayList();
		try {
			for (Object source : sourceCollection) {
				if (source != null) {
					T target = clazz.newInstance();
					BeanUtils.copyPropertiesNoID(source, target);
					targetList.add(target);
				}
			}
		} catch (Exception e) {
			logger.error("TopScoreBeanUtils, collectionPoVoSwitchNoID", e.getMessage());
		}
		return targetList;
	}

	/**
	 * 容器中对象转换为定义类
	 * 
	 * @param sourceCollection
	 * @param clazz
	 * @return
	 */
//	public static <T> Collection<T> convertSetCollection(Collection<?> sourceCollection, Class<T> clazz) {
//
//		if (sourceCollection == null) {
//			return Collections.emptySet();
//		}
//		Set<T> targetSet = new TreeSet<T>();
//		try {
//			for (Object source : sourceCollection) {
//
//				T target = clazz.newInstance();
//				BeanUtils.copyProperties(source, target);
//				targetSet.add(target);
//			}
//		} catch (Exception e) {
//			logger.error("TopScoreBeanUtils, convertSetCollection", e.getMessage());
//		}
//		return targetSet;
//	}

}
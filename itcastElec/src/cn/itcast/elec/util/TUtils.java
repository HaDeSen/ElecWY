package cn.itcast.elec.util;

import java.lang.reflect.ParameterizedType;

public class TUtils {

	/**泛型转换成真实类型（范类转换）*/
	public static Class getTClass(Class entity) {
		ParameterizedType parameterizedType = (ParameterizedType) entity.getGenericSuperclass();
		Class entityClass = (Class) parameterizedType.getActualTypeArguments()[0];
		return entityClass;
	}

}


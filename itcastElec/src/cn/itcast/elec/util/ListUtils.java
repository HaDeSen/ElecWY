package cn.itcast.elec.util;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class ListUtils {
	/**
	 * 将指定字符串，按照传递的符号进行分隔，返回集合
	 */
	public static List<String> stringToList(String name,String sign) {
		List<String> list=null;
		if(StringUtils.isNotBlank(name)){
			String[] arrays=name.split(sign);
			if(arrays!=null&&arrays.length>0){
				list=Arrays.asList(arrays);  //j将数组转换成集合
			}
		}
		return list;
	}
	
	
}

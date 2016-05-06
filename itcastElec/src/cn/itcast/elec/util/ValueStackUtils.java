package cn.itcast.elec.util;

import org.apache.struts2.ServletActionContext;

import cn.itcast.elec.domain.ElecCommonMsg;

public class ValueStackUtils {

	/*
	 * 将新的对象压入栈顶   并删除之前栈顶对象
	 */
	public static void setValueStack(Object eneity) {
		ServletActionContext.getContext().getValueStack().pop();
		ServletActionContext.getContext().getValueStack().push(eneity);
		
	}
	
}

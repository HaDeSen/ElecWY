package cn.itcast.elec.web.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.elec.domain.ElecCommonMsg;
import cn.itcast.elec.service.IElecCommonMsgService;
import cn.itcast.elec.service.IElecTextService;
import cn.itcast.elec.util.ValueStackUtils;

import com.opensymphony.xwork2.ActionSupport;

@Controller("elecCommonMsgAction")
@Scope(value="prototype")
public class ElecCommonMsgAction extends BaseAction<ElecCommonMsg>{
	
	ElecCommonMsg elecCommonMsg = this.getModel();
	
	@Resource(name=IElecCommonMsgService.SERVICE_NAME)
	private IElecCommonMsgService elecCommonMsgService;
	
	/**执行保存*/
	public String home(){
		//1:查询运行监控表，获取唯一数据		
		ElecCommonMsg commonMsg= elecCommonMsgService.findCommonMsg();
		//2:将查询对象压入栈顶对象   目的使用struts2标签   支持表单回显
		
		ValueStackUtils.setValueStack(commonMsg);
		return "home";
	}
	
	
	public String save(){
		elecCommonMsgService.saveCommonMsg(elecCommonMsg);
		return "save";
	}
}

package cn.itcast.elec.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.elec.domain.ElecCommonMsg;
import cn.itcast.elec.domain.ElecSystemDDL;
import cn.itcast.elec.service.IElecCommonMsgService;
import cn.itcast.elec.service.IElecSystemDDLService;
import cn.itcast.elec.service.IElecTextService;
import cn.itcast.elec.util.ValueStackUtils;

import com.opensymphony.xwork2.ActionSupport;

@Controller("elecSystemDDLAction")
@Scope(value="prototype")
public class ElecSystemDDLAction extends BaseAction<ElecSystemDDL>{
	
	ElecSystemDDL elecSystemDDL = this.getModel();
	
	@Resource(name=IElecSystemDDLService.SERVICE_NAME)
	private IElecSystemDDLService elecSystemDDLService;
	
	public String home(){
		//1：查询数据字典中存在的已有的数据类型，存放到一个集合List<ElecSystemDDL>
		List<ElecSystemDDL> list= elecSystemDDLService.findSystemDDLWithDistinct();
		request.setAttribute("list", list);
		return "home";
	}
}

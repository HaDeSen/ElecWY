package cn.itcast.elec.web.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.elec.domain.ElecText;
import cn.itcast.elec.service.IElecTextService;

import com.opensymphony.xwork2.ActionSupport;

@Controller("elecTextAction")
@Scope(value="prototype")
public class ElecTextAction extends BaseAction<ElecText>{
	
	ElecText elecText = this.getModel();
	
	@Resource(name=IElecTextService.SERVICE_NAME)
	private IElecTextService elecTextService;
	
	/**执行保存*/
	public String save(){
		//保存
		elecTextService.saveElecText(elecText);
		return "save";
	}
}

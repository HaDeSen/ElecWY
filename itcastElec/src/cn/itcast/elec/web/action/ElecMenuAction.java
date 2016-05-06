package cn.itcast.elec.web.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.elec.domain.ElecCommonMsg;
import cn.itcast.elec.service.IElecCommonMsgService;
import cn.itcast.elec.util.ValueStackUtils;
import cn.itcast.elec.web.Form.MenuForm;

import com.opensymphony.xwork2.ActionSupport;

@Controller("elecMenuAction")
@Scope(value = "prototype")
public class ElecMenuAction extends BaseAction<MenuForm> {

	MenuForm menuForm = this.getModel();
	@Resource(name=IElecCommonMsgService.SERVICE_NAME)
	private IElecCommonMsgService elecCommonMsgService;
	/***/
	public String menuHome() {

		return "menuHome";
	}

	/* 标题 */
	public String title() {

		return "title";
	}

	public String left() {

		return "left";
	}

	/* 框架改变 */
	public String change() {

		return "change";
	}

	/* 加载数据页面 */
	public String loading() {

		return "loading";
	}

	public String alermDevice() {
		// 1:查询运行监控表，获取唯一数据
		ElecCommonMsg commonMsg = elecCommonMsgService.findCommonMsg();
		// 2:将查询对象压入栈顶对象 目的使用struts2标签 支持表单回显

		ValueStackUtils.setValueStack(commonMsg);
		return "alermDevice";
	}

	public String alermStation() {
		// 1:查询运行监控表，获取唯一数据
		ElecCommonMsg commonMsg = elecCommonMsgService.findCommonMsg();
		// 2:将查询对象压入栈顶对象 目的使用struts2标签 支持表单回显

		ValueStackUtils.setValueStack(commonMsg);
		return "alermStation";
	}

	public String logout() {
		// 清空Session
		// request.getSession().removeAttribute(arg0);
		// 清空所有Session
		request.getSession().invalidate();
		return "logout";
	}
}

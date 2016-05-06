package cn.itcast.elec.web.action;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.LinkedMap;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.elec.domain.ElecCommonMsg;
import cn.itcast.elec.domain.ElecExportFields;
import cn.itcast.elec.service.IElecCommonMsgService;
import cn.itcast.elec.service.IElecExportFieldsService;
import cn.itcast.elec.service.IElecTextService;
import cn.itcast.elec.util.ListUtils;
import cn.itcast.elec.util.ValueStackUtils;

import com.opensymphony.xwork2.ActionSupport;

@Controller("elecExportFieldsAction")
@Scope(value = "prototype")
public class ElecExportFieldsAction extends BaseAction<ElecExportFields> {

	ElecExportFields elecExportFields = this.getModel();

	@Resource(name = IElecExportFieldsService.SERVICE_NAME)
	private IElecExportFieldsService elecExportFieldsService;

	/**
	 * 跳转到system/exportExcel.jsp
	 * 
	 */
	public String setExportExcel() {
		// 获取主键
		String belongTo = elecExportFields.getBelongTo();
		// 1：使用belongTo作为主键，查询对象ElecExportFields
		ElecExportFields exportFields = elecExportFieldsService
				.findExportFieldsByID(belongTo);
		// 2：设置2个Map<String,String>集合，1个Map集合存放未导出的数据，1个Map集合存放导出的数据
		// * map集合的key，存放未导出/导出的英文字段
		// * map集合的value，存放未导出/导出的中文字段
		
		Map<String,String> map= new LinkedHashMap<String,String>();
		Map<String,String> nomap= new LinkedHashMap<String,String>();
		
		//
		// 3：使用查询对象ElecExportFields获取4个字符串expNameList expFieldName noExpNameList
		// noExpFieldName
		// 将4个字符串转换成4个List<Strimng>，使用‘#’号分割
		List<String> zList= ListUtils.stringToList(exportFields.getExpNameList(),"#");
		List<String> eList= ListUtils.stringToList(exportFields.getExpFieldName(),"#");
		List<String> noZList= ListUtils.stringToList(exportFields.getNoExpNameList(),"#");
		List<String> noEList= ListUtils.stringToList(exportFields.getNoExpFieldName(),"#");
		//由于导出的字段中文名称和英文名称，以及未导出的中文名称和英文名称一一对应
		if(zList!=null&& zList.size()>0){
			for(int i=0;i<zList.size();i++){
				map.put(eList.get(i), zList.get(i));
			}
		}
		if(noZList!=null&& noZList.size()>0){
			for(int i=0;i<noZList.size();i++){
				nomap.put(noEList.get(i), noZList.get(i));
			}
		}
		request.setAttribute("map", map);
		request.setAttribute("nomap", nomap);
		return "setExportExcel";
	}
	
	public String saveSetExportExcel(){
		//1：获取5个隐藏的域的值，使用id完成update的更新

		elecExportFieldsService.updateExportExcelByID(elecExportFields);
		return "close";
	}
}

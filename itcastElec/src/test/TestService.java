package test;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.elec.dao.IElecTextDao;
import cn.itcast.elec.domain.ElecText;
import cn.itcast.elec.service.IElecTextService;

public class TestService {
	@Test
	public void save() {
		// 加载类路径下的spring容器		
				ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
				
				// 调用接口
				IElecTextService iet = (IElecTextService) ac.getBean(IElecTextService.SERVICE_NAME);

				ElecText elecText = new ElecText();
				elecText.setTextName("测试service名称");
				elecText.setTextDate(new Date());
				elecText.setTextRemark("测试service备注");
				iet.saveElecText(elecText);
	}
	/*
	 * 测试指定查询条件   查询对应结果  返回LIST
	 */
	@Test
	public void findCollectionByConditionNoPage() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		IElecTextService elecTextService = (IElecTextService)ac.getBean(IElecTextService.SERVICE_NAME);
		
		ElecText elecText = new ElecText();
		elecText.setTextName("测试");
		elecText.setTextRemark("测试");
		
		List<ElecText> list = elecTextService.findCollectionByConditionNoPage(elecText);
		if(list!=null && list.size()>0){
			for(ElecText text:list){
				System.out.println(text.getTextName()+"   "+text.getTextRemark()+"   "+text.getTextDate());
			}
		}
	}
}

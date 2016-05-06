package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import sunw.io.Serializable;

import cn.itcast.elec.dao.IElecTextDao;
import cn.itcast.elec.domain.ElecText;

public class TestDao {
	@Test
	public void save() {
		// 加载类路径下的spring容器		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		// 调用接口
		IElecTextDao iet = (IElecTextDao) ac.getBean(IElecTextDao.SERVICE_NAME);

		ElecText elecText = new ElecText();
		elecText.setTextName("测试spring名称");
		elecText.setTextDate(new Date());
		elecText.setTextRemark("测试spring备注");
		iet.save(elecText);
	}
	@Test
	public void update() {
		// 加载类路径下的spring容器		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		// 调用接口
		IElecTextDao iet = (IElecTextDao) ac.getBean(IElecTextDao.SERVICE_NAME);

		ElecText elecText = new ElecText();
		elecText.setTextID("2c90891f51eb71660151eb737e3c0001");
		elecText.setTextName("123");
		elecText.setTextDate(new Date());
		elecText.setTextRemark("测试123备注");
		iet.update(elecText);
	}
	@Test
	public void findObjectByID()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		// 调用接口
		IElecTextDao iet = (IElecTextDao) ac.getBean(IElecTextDao.SERVICE_NAME);
		java.io.Serializable id="2c90891f51eb71660151eb737e3c0001";
		ElecText elecText = iet.findObjectByID(id);
		System.out.println(elecText.getTextName()+" "+elecText.getTextDate());
	
	}
	@Test
	public void deleteObjectByIDs()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		// 调用接口
		IElecTextDao iet = (IElecTextDao) ac.getBean(IElecTextDao.SERVICE_NAME);
		java.io.Serializable[] id={"2c90891f547464610154746463030001","2c90891f547486e001547486e28c0001"};
		 iet.deleteObjectByIDs(id);	
	
	}
	@Test
	public void deleteObjectByCollection()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		// 调用接口
		IElecTextDao iet = (IElecTextDao) ac.getBean(IElecTextDao.SERVICE_NAME);
		
		List<ElecText> list=new ArrayList<ElecText>(); 
		ElecText elecText1=new ElecText();
		elecText1.setTextID("2c90891f51ce586f0151ce5871db0001");
		
		ElecText elecText2=new ElecText();
		elecText2.setTextID("2c90891f51ce5a850151ce5a86c40001");
		
		list.add(elecText1);
		list.add(elecText2);
				
		iet.deleteObjectByCollection(list);	
	
	}
	
}

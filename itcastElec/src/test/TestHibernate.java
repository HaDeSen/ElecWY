package test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.itcast.elec.domain.ElecText;

public class TestHibernate {
	@Test
	public void save() {
		Configuration cfg = new Configuration();
		cfg.configure();// 加载hibernate.cfg.xml映射文件
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();

		// 测试操作对象的过程，就是操作数据库表
		ElecText elecText = new ElecText();
		elecText.setTextName("测试名称");
		elecText.setTextDate(new Date());
		elecText.setTextRemark("测试备注");
		s.save(elecText);

		t.commit();
		s.close();
	}
}

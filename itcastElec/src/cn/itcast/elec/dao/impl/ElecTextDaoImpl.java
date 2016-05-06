package cn.itcast.elec.dao.impl;

import org.springframework.stereotype.Repository;

import cn.itcast.elec.dao.IElecTextDao;
import cn.itcast.elec.domain.ElecText;
/***
 * 相当于spring容器定义
 * @author MTY
 *
 * 优势：1.增强了接口和实现类耦合
 *     2.保证bean id的唯一
 */
 
@Repository(IElecTextDao.SERVICE_NAME)
public class ElecTextDaoImpl extends CommonDaoImpl<ElecText> implements IElecTextDao{
	

}

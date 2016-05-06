package cn.itcast.elec.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import cn.itcast.elec.dao.IElecCommonMsgDao;
import cn.itcast.elec.dao.IElecExportFieldsDao;
import cn.itcast.elec.dao.IElecSystemDDLDao;
import cn.itcast.elec.domain.ElecCommonMsg;
import cn.itcast.elec.domain.ElecExportFields;
import cn.itcast.elec.domain.ElecSystemDDL;
@Repository(IElecSystemDDLDao.SERVICE_NAME)
public class ElecSystemDDLDaoImpl extends CommonDaoImpl<ElecSystemDDL> implements IElecSystemDDLDao{

	/***
	 * 
	 */
	public List<ElecSystemDDL> findSystemDDLWithDistinct() {
		//返回结果集
		//方案一
//		List<ElecSystemDDL> systemList=new ArrayList<ElecSystemDDL>();
//		String hql="select distinct o.keyword from ElecSystemDDL o";
//		List<Object> list=this.getHibernateTemplate().find(hql);
//		if(list!=null&& list.size()>0){
//			for(Object o:list){
//				ElecSystemDDL elecSystemDDL=new ElecSystemDDL();
//				elecSystemDDL.setKeyword(o.toString());
//				systemList.add(elecSystemDDL);
//			}
//		}
		
		//方案二：
		String hql="select distinct new cn.itcast.elec.domain.ElecSystemDDL(o.keyword) from ElecSystemDDL o";
		List<ElecSystemDDL> systemList=this.getHibernateTemplate().find(hql);		
		return systemList;
	}
	

}

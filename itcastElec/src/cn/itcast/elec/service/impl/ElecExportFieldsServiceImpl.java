package cn.itcast.elec.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.elec.dao.IElecCommonMsgDao;
import cn.itcast.elec.dao.IElecExportFieldsDao;
import cn.itcast.elec.domain.ElecCommonMsg;
import cn.itcast.elec.domain.ElecExportFields;
import cn.itcast.elec.service.IElecCommonMsgService;
import cn.itcast.elec.service.IElecExportFieldsService;



@Service(IElecExportFieldsService.SERVICE_NAME)
@Transactional(readOnly=true)
public class ElecExportFieldsServiceImpl implements IElecExportFieldsService{

	@Resource(name=IElecExportFieldsDao.SERVICE_NAME)
	private IElecExportFieldsDao elecExportFieldsDao;
	
	/***
	 * 使用主键ID  查询导出设置表的对象
	 */
	public ElecExportFields findExportFieldsByID(String belongTo) {
		ElecExportFields elecExportFields= elecExportFieldsDao.findObjectByID(belongTo);
		return elecExportFields;
	}
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void updateExportExcelByID(ElecExportFields elecExportFields) {
		  
		elecExportFieldsDao.update(elecExportFields);
		
	}	
	

}

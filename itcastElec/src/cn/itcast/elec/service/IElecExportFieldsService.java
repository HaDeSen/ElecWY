package cn.itcast.elec.service;

import cn.itcast.elec.domain.ElecCommonMsg;
import cn.itcast.elec.domain.ElecExportFields;


public interface IElecExportFieldsService {
	
	public static final String SERVICE_NAME="cn.itcast.elec.service.impl.ElecExportFieldsServiceImpl";

	ElecExportFields findExportFieldsByID(String belongTo);
	
	void updateExportExcelByID(ElecExportFields elecExportFields);
	
	
}

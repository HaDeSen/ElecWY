package cn.itcast.elec.dao.impl;

import org.springframework.stereotype.Repository;
import cn.itcast.elec.dao.IElecCommonMsgDao;
import cn.itcast.elec.dao.IElecExportFieldsDao;
import cn.itcast.elec.domain.ElecCommonMsg;
import cn.itcast.elec.domain.ElecExportFields;
@Repository(IElecExportFieldsDao.SERVICE_NAME)
public class ElecExportFieldsDaoImpl extends CommonDaoImpl<ElecExportFields> implements IElecExportFieldsDao{
	

}

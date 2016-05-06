package cn.itcast.elec.service;

import cn.itcast.elec.domain.ElecCommonMsg;


public interface IElecCommonMsgService {
	
	public static final String SERVICE_NAME="cn.itcast.elec.service.impl.ElecCommonMsgServiceImpl";
	
	void saveElecText(ElecCommonMsg elecCommonMsg);

	ElecCommonMsg findCommonMsg();

	void saveCommonMsg(ElecCommonMsg elecCommonMsg);


}

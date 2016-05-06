package cn.itcast.elec.service;

import java.util.List;

import cn.itcast.elec.domain.ElecText;

public interface IElecTextService {
	
	public static final String SERVICE_NAME="cn.itcast.elec.service.impl.ElecTextServiceImpl";
	
	void saveElecText(ElecText elecText);

	List<ElecText> findCollectionByConditionNoPage(ElecText elecText);
	
	
}

package cn.itcast.elec.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.LinkedMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.elec.dao.IElecTextDao;
import cn.itcast.elec.domain.ElecText;
import cn.itcast.elec.service.IElecTextService;

@Service(IElecTextService.SERVICE_NAME)
@Transactional(readOnly=true)
public class ElecTextServiceImpl implements IElecTextService{

	@Resource(name=IElecTextDao.SERVICE_NAME)
	private IElecTextDao elecTextDao;
	
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveElecText(ElecText elecText) {
		// TODO Auto-generated method stub
		elecTextDao.save(elecText);
	}
	
	public List<ElecText> findCollectionByConditionNoPage(ElecText elecText){
		String condition="";
		List<Object> paramList=new ArrayList<Object>();
		if(StringUtils.isNotBlank(elecText.getTextName())){
			condition+=" and o.textName like ?";
			paramList.add("%"+elecText.getTextName()+"%");
		}
		if(StringUtils.isNotBlank(elecText.getTextRemark())){
			condition+=" and o.textRemark like ?";
			paramList.add("%"+elecText.getTextRemark()+"%");
		}
		Object[] params=paramList.toArray();
		//组织排序语句
		Map<String,String> orderby=new LinkedHashMap<String, String>();
		orderby.put("o.textName","asc");
		orderby.put("o.textRemark","desc");
		
		List<ElecText> list=elecTextDao.findCollectionByConditionNoPage(condition,params,orderby);	
		
		return list;
	}

}

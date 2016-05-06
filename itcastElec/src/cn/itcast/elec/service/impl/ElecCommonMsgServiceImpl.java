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
import cn.itcast.elec.domain.ElecCommonMsg;
import cn.itcast.elec.service.IElecCommonMsgService;



@Service(IElecCommonMsgService.SERVICE_NAME)
@Transactional(readOnly=true)
public class ElecCommonMsgServiceImpl implements IElecCommonMsgService{

	@Resource(name=IElecCommonMsgDao.SERVICE_NAME)
	private IElecCommonMsgDao elecCommonMsgDao;
	
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveElecText(ElecCommonMsg elecCommonMsg) {
		// TODO Auto-generated method stub
		
	}
	/***
	 * 获取运行监控数据
	 */
	public ElecCommonMsg findCommonMsg() {
		
		List<ElecCommonMsg> list= elecCommonMsgDao.findCollectionByConditionNoPage("", null, null);
		ElecCommonMsg commonMsg=null;
		//查询唯一数据
		if(list!=null&&list.size()>0){
			commonMsg=list.get(0);
		}
		return commonMsg;
	}
	
	//添加事务      事务的隔离级别  ，  传播行为  ， 是否只读
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveCommonMsg(ElecCommonMsg elecCommonMsg) {
		//1:查询监控数据   返回LIST
		List<ElecCommonMsg> list= elecCommonMsgDao.findCollectionByConditionNoPage("", null, null);
		//2：判断LIST集合是否为空
		if(list.size()>0&&list!=null){
			ElecCommonMsg commonMsg=list.get(0);//po对象  存在ID
			//po对象   属性发生变化   事务提交时   与数据库中进行对比  发生变化后会自动更新
			//hibernate 快照更新
			commonMsg.setDevRun(elecCommonMsg.getDevRun());
			commonMsg.setStationRun(elecCommonMsg.getStationRun());
			commonMsg.setCreateDate(new Date());
		}else{
			elecCommonMsg.setCreateDate(new Date());
			elecCommonMsgDao.save(elecCommonMsg);
		}
		
	}

}

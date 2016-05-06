package cn.itcast.elec.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.elec.dao.IElecCommonDao;
import cn.itcast.elec.util.TUtils;

public class CommonDaoImpl<T> extends HibernateDaoSupport implements
		IElecCommonDao<T> {
	 /**泛型转换，获取真实对象实体*/
		Class entityClass = TUtils.getTClass(this.getClass());	
	
	/** 使用@Resource注入SessionFactory */
	@Resource(name = "sessionFactory")
	public final void setSessionFactoryDi(SessionFactory sf) {
		this.setSessionFactory(sf);
	}

	/** 保存 */
	public void save(T entity) {
		
		this.getHibernateTemplate().save(entity);
	}
	/**更新*/
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
	}

	/**使用主键ID，查询对象*/
	public T findObjectByID(Serializable id) {
		return (T) this.getHibernateTemplate().get(entityClass, id);
	}
	
	/**使用主键ID，删除对象（删除一个或者多个对象）*/
	public void deleteObjectByIDs(Serializable... ids) {
		if(ids!=null && ids.length>0){
			for(Serializable id:ids){
				Object entity = this.findObjectByID(id);
				this.getHibernateTemplate().delete(entity);
			}
		}
	}
	
	/**使用封装对象的集合，批量删除对象*/
	public void deleteObjectByCollection(List<T> list) {
		this.getHibernateTemplate().deleteAll(list);
	}
	
	/**测试指定查询条件，查询结果集（不分页）*/
	/**
	这里1=1的目的是方便在Service层拼装sql或者hql语句，连接统一使用and
	 * SELECT o FROM ElecText o WHERE 1=1             #Dao层填写
			AND o.textName LIKE '%张%'                  #Service拼装
			AND o.textRemark LIKE '%张%'                #Service拼装
			ORDER BY o.textDate ASC,o.textName desc   #Service拼装
	 */
	public List<T> findCollectionByConditionNoPage(String condition,
			final Object[] params, Map<String, String> orderby) {
		String hql = "FROM "+entityClass.getSimpleName()+" o WHERE 1=1";
		String orderByHql = this.initOrderByHql(orderby);
		final String finalHql = hql + condition + orderByHql;
		//执行hql语句
		/**方式一：直接使用HibernateTemplate的find()方法，find方法支持执行hql语句*/
/*		List<T> list = this.getHibernateTemplate().find(finalHql, params);*/
		/**方式二：获取SessionFactory，在获取Session*/
//		SessionFactory sf = this.getHibernateTemplate().getSessionFactory();
//		Session s = sf.getCurrentSession();
//		Query query = s.createQuery(finalHql);
//		query.setParameter(0, params[0]);
//		query.setParameter(1, params[1]);
//		List<T> list = query.list();
		/**方式三：使用hibernateTemplate调用回调函数*/
		List<T> list = this.getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(finalHql);
				if(params!=null && params.length>0){
					for(int i=0;i<params.length;i++){
						query.setParameter(i, params[i]);
					}
				}
				return query.list();
			}
		});
		return list;
	}

	/**组织排序语句，将Map集合转换成String类型*/
	private String initOrderByHql(Map<String, String> orderby) {
		StringBuffer buffer = new StringBuffer("");
		if(orderby!=null && orderby.size()>0){
			buffer.append(" ORDER BY ");
			for(Map.Entry<String, String> map:orderby.entrySet()){
				buffer.append(map.getKey()+" "+map.getValue()+",");
			}
			//删除最后一个逗号
			buffer.deleteCharAt(buffer.length()-1);
		}
		return buffer.toString();
	}

}

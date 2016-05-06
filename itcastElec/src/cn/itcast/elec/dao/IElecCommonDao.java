package cn.itcast.elec.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface IElecCommonDao<T> {
	void save(T entity);
	void update(T entity);
	T findObjectByID(Serializable id);
	void deleteObjectByIDs(Serializable... id);
	void deleteObjectByCollection(List<T> list);
	List<T> findCollectionByConditionNoPage(String condition,
			Object[] params, Map<String, String> orderby);
}

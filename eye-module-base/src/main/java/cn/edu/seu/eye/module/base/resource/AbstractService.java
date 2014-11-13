package cn.edu.seu.eye.module.base.resource;

import com.iron.fast.beans.*;
import com.iron.fast.repository.GenericDao;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract class AbstractService<T> implements IService<T> {

	@Resource(name = "genericDao")
	protected GenericDao genericDao;

	@Override
	@Transactional
	public int insert(T t, String... properties) {
		return getIDao().insert(t, properties);
	}

	@Override
	@Transactional
	public int insert(Map<String, Object> map, String... properties) {
		return getIDao().insert(map, properties);
	}

	@Override
	@Transactional
	public int batchInsert(List<T> list, String... properties) {
		return getIDao().batchInsert(list, properties);
	}

	@Override
	@Transactional
	public int batchMapInsert(List<? extends Map<String, Object>> list,
			String... properties) {
		return getIDao().batchMapInsert(list, properties);
	}

	@Override
	@Transactional
	public int delete(Serializable... pKeys) {
		return getIDao().delete(pKeys);
	}

	@Override
	@Transactional
	public int delete(Criteria criteria) {
		return getIDao().delete(criteria);
	}

	@Override
	@Transactional
	public int updateWithLog(T t, String... properties) {
		return getIDao().updateWithLog(t, properties);
	}

	@Override
	@Transactional
	public int update(T t, String... properties) {
		return getIDao().update(t, properties);
	}

	@Override
	@Transactional
	public int updateWithLog(Map<String, Object> map, String... properties) {
		return getIDao().updateWithLog(map, properties);
	}

	@Override
	@Transactional
	public int update(Map<String, Object> map, String... properties) {
		return getIDao().update(map, properties);
	}

	@Override
	@Transactional
	public int update(Parameters parameters, Criteria criteria) {
		return getIDao().update(parameters, criteria);
	}

	@Override
	@Transactional
	public int batchUpdate(List<T> list, String... properties) {
		return getIDao().batchUpdate(list, properties);
	}

	@Override
	@Transactional
	public int batchMapUpdateWithLog(List<? extends Map<String, Object>> list,
			String... properties) {
		return getIDao().batchMapUpdateWithLog(list, properties);
	}

	@Override
	@Transactional
	public int batchMapUpdate(List<? extends Map<String, Object>> list,
			String... properties) {
		return getIDao().batchMapUpdate(list, properties);
	}

	@Override
	public T get(Serializable id) {
		return getIDao().get(id);
	}

	@Override
	public T get(Criteria criteria, String... properties) {
		return getIDao().get(criteria, properties);
	}

	@Override
	public T getWithDetail(Criteria criteria, String... properties) {
		return getIDao().getWithDetail(criteria, properties);
	}

	@Override
	public Map<String, Object> getMap(Criteria criteria, String... properties) {
		return getIDao().getMap(criteria, properties);
	}

	@Override
	public List<T> getAll() {
		return getIDao().getAll();
	}

	@Override
	public List<T> getListWithDetail(Criteria criteria, Order order,
			String... properties) {
		return getIDao().getListWithDetail(criteria, order, properties);
	}

	@Override
	public List<T> getList(Criteria criteria, String... properties) {
		return getIDao().getList(criteria, properties);
	}

	@Override
	public List<T> getList(Criteria criteria, Order order, String... properties) {
		return getIDao().getList(criteria, order, properties);
	}

	@Override
	public List<T> getTopList(Criteria criteria, int topNRows,
			String... properties) {
		return getIDao().getTopList(criteria, topNRows, properties);
	}

	@Override
	public List<T> getTopList(Criteria criteria, Order order, int topNRows,
			String... properties) {
		return getIDao().getTopList(criteria, order, topNRows, properties);
	}

	@Override
	public List<Map<String, Object>> getMapList(Criteria criteria, Order order,
			String... properties) {
		return getIDao().getMapList(criteria, order, properties);
	}

	@Override
	public List<Map<String, Object>> getMapList(Criteria criteria,
			String... properties) {
		return getIDao().getMapList(criteria, properties);
	}

	@Override
	public PageList<T> getPageList(Page page, Criteria criteria,
			String... properties) {
		return getIDao().getPageList(page, criteria, properties);
	}

	@Override
	public PageList<T> getPageList(Page page, Criteria criteria, Order order,
			String... properties) {
		return getIDao().getPageList(page, criteria, order, properties);
	}

    @Override
    public PageList<T> getPageListWithDetail(Page page, Criteria criteria, Order order, String... properties) {
        return getIDao().getPageListWithDetail(page, criteria, order, properties);
    }

    @Override
	public PageList<Map<String, Object>> getPageMapList(Page page,
			Criteria criteria, String... properties) {
		return getIDao().getPageMapList(page, criteria, properties);
	}

	@Override
	public PageList<Map<String, Object>> getPageMapList(Page page,
			Criteria criteria, Order order, String... properties) {
		return getIDao().getPageMapList(page, criteria, order, properties);
	}

	@Override
	public <N extends Number> N getCount(Criteria criteria,
			String countPropertyName, Class<N> requiredType) {
		return getIDao().getCount(criteria, countPropertyName, requiredType);
	}

	@Override
	public <N extends Number> N getSum(Criteria criteria,
			String sumPropertyName, Class<N> requiredType) {
		return getIDao().getSum(criteria, sumPropertyName, requiredType);
	}

	@Override
	public <N extends Number> N getMin(Criteria criteria,
			String minPropertyName, Class<N> requiredType) {
		return getIDao().getMin(criteria, minPropertyName, requiredType);
	}

	@Override
	public <N extends Number> N getMax(Criteria criteria,
			String maxPropertyName, Class<N> requiredType) {
		return getIDao().getMax(criteria, maxPropertyName, requiredType);
	}
}

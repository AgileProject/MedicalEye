package cn.edu.seu.eye.module.base.resource;

import com.iron.fast.beans.*;
import com.iron.fast.repository.IDao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface IService<T> {

    IDao<T> getIDao();

    int insert(T t, String... properties);

    int insert(Map<String, Object> map, String... properties);

    int batchInsert(List<T> list, String... properties);

    int batchMapInsert(List<? extends Map<String, Object>> list,
                       String... properties);

    int delete(Serializable... pKeys);

    int delete(Criteria criteria);

    int updateWithLog(T t, String... properties);

    int update(T t, String... properties);

    int updateWithLog(Map<String, Object> map, String... properties);

    int update(Map<String, Object> map, String... properties);

    int update(Parameters parameters, Criteria criteria);

    int batchUpdate(List<T> list, String... properties);

    int batchMapUpdateWithLog(List<? extends Map<String, Object>> list,
                              String... properties);

    int batchMapUpdate(List<? extends Map<String, Object>> list,
                       String... properties);

    T get(Serializable id);

    T get(Criteria criteria, String... properties);

    T getWithDetail(Criteria criteria, String... properties);

    Map<String, Object> getMap(Criteria criteria, String... properties);

    List<T> getAll();

    List<T> getListWithDetail(Criteria criteria, Order order, String... properties);

    List<T> getList(Criteria criteria, String... properties);

    List<T> getList(Criteria criteria, Order order, String... properties);

    List<T> getTopList(Criteria criteria, int topNRows, String... properties);

    List<T> getTopList(Criteria criteria, Order order, int topNRows,
                       String... properties);

    List<Map<String, Object>> getMapList(Criteria criteria, Order order,
                                         String... properties);

    List<Map<String, Object>> getMapList(Criteria criteria,
                                         String... properties);

    PageList<T> getPageList(Page page, Criteria criteria, String... properties);

    PageList<T> getPageList(Page page, Criteria criteria, Order order,
                            String... properties);

    PageList<T> getPageListWithDetail(Page page, Criteria criteria, Order order,
                            String... properties);

    PageList<Map<String, Object>> getPageMapList(Page page, Criteria criteria,
                                                 String... properties);

    PageList<Map<String, Object>> getPageMapList(Page page, Criteria criteria,
                                                 Order order, String... properties);

    <N extends Number> N getCount(Criteria criteria, String countPropertyName,
                                  Class<N> requiredType);

    <N extends Number> N getSum(Criteria criteria, String sumPropertyName,
                                Class<N> requiredType);

    <N extends Number> N getMin(Criteria criteria, String minPropertyName,
                                Class<N> requiredType);

    <N extends Number> N getMax(Criteria criteria, String maxPropertyName,
                                Class<N> requiredType);
}

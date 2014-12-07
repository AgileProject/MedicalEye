package cn.edu.seu.eye.core.MongoDBDao.dao;

import cn.edu.seu.eye.core.MongoDBDao.entity.Computer;

import java.util.List;

/**
 * Created by Administrator on 14-12-1.
 */
public interface IComputerDao extends IDao<Computer> {
    List<Computer> getAllComputers(String computerName);

    int insert(Computer computer);
}

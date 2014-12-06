package cn.edu.seu.eye.module.base.service.management;

import cn.edu.seu.eye.module.base.entity.management.Computer;
import cn.edu.seu.eye.module.base.resource.IService;

import java.util.List;
import java.util.Map;

/**
 * Created by DL on 2014/12/2.
 */
public interface IComputer extends IService<Computer>{

    Computer insertComputer(Computer computer);

    void deleteComputer(Computer computer);


    void updateComputer(Computer computer);

}

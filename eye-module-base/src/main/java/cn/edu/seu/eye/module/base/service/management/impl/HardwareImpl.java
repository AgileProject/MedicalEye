package cn.edu.seu.eye.module.base.service.management.impl;

import cn.edu.seu.eye.module.base.dao.management.IHardwareDao;
import cn.edu.seu.eye.module.base.entity.management.Hardware;
import cn.edu.seu.eye.module.base.resource.AbstractService;
import cn.edu.seu.eye.module.base.service.management.IHardware;
import com.iron.fast.repository.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ling on 2014/12/6.
 */

@Service
public class HardwareImpl extends AbstractService<Hardware> implements IHardware{

	@Autowired
	private IHardwareDao hardwareDao;

	@Override
	public IDao<Hardware> getIDao() {
		return hardwareDao;
	}

}
